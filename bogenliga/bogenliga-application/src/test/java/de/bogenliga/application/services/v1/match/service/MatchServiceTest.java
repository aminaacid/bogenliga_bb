package de.bogenliga.application.services.v1.match.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import de.bogenliga.application.business.passe.api.PasseComponent;
import de.bogenliga.application.business.passe.api.types.PasseDO;
import de.bogenliga.application.business.mannschaftsmitglied.api.MannschaftsmitgliedComponent;
import de.bogenliga.application.business.mannschaftsmitglied.api.types.MannschaftsmitgliedDO;
import de.bogenliga.application.business.match.api.MatchComponent;
import de.bogenliga.application.business.match.api.types.MatchDO;
import de.bogenliga.application.common.errorhandling.exception.BusinessException;
import de.bogenliga.application.services.v1.match.mapper.MatchDTOMapper;
import de.bogenliga.application.services.v1.match.model.MatchDTO;
import de.bogenliga.application.services.v1.passe.mapper.PasseDTOMapper;
import de.bogenliga.application.services.v1.passe.model.PasseDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * @author Dominik Halle, HSRT MKI SS19 - SWT2
 */
public class MatchServiceTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private PasseComponent passeComponent;

    @Mock
    private Principal principal;

    @Mock
    private MatchComponent matchComponent;

    @Mock
    private MannschaftsmitgliedComponent mannschaftsmitgliedComponent;

    @InjectMocks
    private MatchService underTest;

    protected static final Long MATCH_ID = 1L;
    protected static final Long MATCH_NR = 1L;
    protected static final Long MATCH_BEGEGNUNG = 1L;
    protected static final Long MATCH_WETTKAMPF_ID = 1L;
    protected static final Long MATCH_MANNSCHAFT_ID = 1L;
    protected static final Long MATCH_SCHEIBENNUMMER = 3L;
    protected static final Long MATCH_MATCHPUNKTE = 6L;
    protected static final Long MATCH_SATZPUNKTE = 3L;
    protected static final Long CURRENT_USER_ID = 1L;


    private static final Long PASSE_ID_1 = 1L;
    private static final Long PASSE_ID_2 = 2L;
    private static final Long PASSE_LFDR_NR = 2L;
    private static final Integer PASSE_SCHUETZE_NR_1 = 1;
    private static final Integer PASSE_SCHUETZE_NR_2 = 2;
    private static final Long PASSE_DSB_MITGLIED_ID = 1L;
    private static final Integer PASSE_PFEIL_1 = 10;
    private static final Integer PASSE_PFEIL_2 = 5;

    private static final Long MM_ID_1 = 1L;
    private static final Long MM_ID_2 = 2L;
    private static final Long MM_ID_3 = 3L;
    private static final Long MM_mannschaftsId = 1L;
    private static final Long MM_dsbMitgliedId = 100L;
    private static final Boolean MM_dsbMitgliedEingesetzt = true;
    private static final String MM_dsbMitgliedVorname = "Foo";
    private static final String MM_dsbMitgliedNachname= "Bar";

    protected MatchDO getMatchDO() {
        return new MatchDO(
                MATCH_ID,
                MATCH_NR,
                MATCH_BEGEGNUNG,
                MATCH_MANNSCHAFT_ID,
                MATCH_WETTKAMPF_ID,
                MATCH_MATCHPUNKTE,
                MATCH_SCHEIBENNUMMER,
                MATCH_SATZPUNKTE
        );
    }


    protected PasseDO getPasseDO(Long id) {
        return new PasseDO(
                id,
                MATCH_MANNSCHAFT_ID,
                MATCH_WETTKAMPF_ID,
                MATCH_NR,
                MATCH_ID,
                PASSE_LFDR_NR,
                PASSE_DSB_MITGLIED_ID,
                PASSE_PFEIL_1,
                PASSE_PFEIL_2,
                null, null, null, null
        );
    }

    protected MannschaftsmitgliedDO getMMDO (Long id) {
        return new MannschaftsmitgliedDO(
                id,
                MM_mannschaftsId,
                MM_dsbMitgliedId,
                MM_dsbMitgliedEingesetzt,
                MM_dsbMitgliedVorname,
                MM_dsbMitgliedNachname
        );
    }

    protected List<MannschaftsmitgliedDO> getMannschaftsMitglieder () {
        List<MannschaftsmitgliedDO> mmdos = new ArrayList<>();
        mmdos.add(getMMDO(MM_ID_1));
        mmdos.add(getMMDO(MM_ID_2));
        mmdos.add(getMMDO(MM_ID_3));
        return mmdos;
    }


    protected PasseDTO getPasseDTO(Long id, Integer nr) {
        PasseDTO passeDTO = PasseDTOMapper.toDTO.apply(getPasseDO(id));
        passeDTO.setSchuetzeNr(nr);
        return passeDTO;
    }


    @Before
    public void initMocks() {
        when(principal.getName()).thenReturn(String.valueOf(CURRENT_USER_ID));
    }


    @Test
    public void findById() {
        MatchDO matchDO = getMatchDO();
        when(matchComponent.findById(anyLong())).thenReturn(matchDO);
        final MatchDTO actual = underTest.findById(MATCH_ID);
        assertThat(actual).isNotNull();
        MatchService.checkPreconditions(actual, MatchService.matchConditionErrors);
    }


    @Test
    public void findById_Null() {
        when(matchComponent.findById(anyLong())).thenReturn(null);
        // expect a NPE as the null-state should be checked in MatchComponentImpl
        assertThatThrownBy(() -> {
            underTest.findById(MATCH_ID);
        }).isInstanceOf(NullPointerException.class);
    }


    @Test
    public void findMatchesByIds() {
        MatchDO matchDO1 = getMatchDO();
        when(matchComponent.findById(anyLong())).thenReturn(matchDO1);
        final List<MatchDTO> actual = underTest.findMatchesByIds(MATCH_ID, MATCH_ID);
        assertThat(actual).isNotNull().isNotEmpty().hasSize(2);
        MatchService.checkPreconditions(actual.get(0), MatchService.matchConditionErrors);
    }


    @Test
    public void findMatchesByIds_Null() {
        when(matchComponent.findById(anyLong())).thenReturn(null);
        // expect a NPE as the null-state should be checked in MatchComponentImpl
        assertThatThrownBy(() -> {
            underTest.findMatchesByIds(MATCH_ID, MATCH_ID);
        }).isInstanceOf(NullPointerException.class);
    }


    @Test
    public void saveMatches() {
        MatchDO matchDO1 = getMatchDO();
        MatchDTO matchDTO = MatchDTOMapper.toDTO.apply(matchDO1);
        ArrayList<MatchDTO> matches = new ArrayList<>();
        matches.add(matchDTO);
        matches.add(matchDTO);

        when(mannschaftsmitgliedComponent.findAllSchuetzeInTeam(anyLong())).thenReturn(getMannschaftsMitglieder());

        final List<MatchDTO> actual = underTest.saveMatches(matches, principal);
        assertThat(actual).isNotNull().isNotEmpty().hasSize(2);
        MatchService.checkPreconditions(actual.get(0), MatchService.matchConditionErrors);
    }


    @Test
    public void saveMatches_Null() {
        MatchDO matchDO1 = getMatchDO();
        MatchDTO matchDTO = MatchDTOMapper.toDTO.apply(matchDO1);
        ArrayList<MatchDTO> matches = new ArrayList<>();
        matches.add(null);
        matches.add(matchDTO);

        when(mannschaftsmitgliedComponent.findAllSchuetzeInTeam(anyLong())).thenReturn(getMannschaftsMitglieder());

        assertThatThrownBy(() -> {
            underTest.saveMatches(matches, principal);
        }).isInstanceOf(BusinessException.class);
    }

    @Test
    public void saveMatches_WithPasseUpdate() {
        MatchDO matchDO1 = getMatchDO();
        MatchDTO matchDTO = MatchDTOMapper.toDTO.apply(matchDO1);

        PasseDTO passe1 = getPasseDTO(PASSE_ID_1, PASSE_SCHUETZE_NR_1);
        PasseDTO passe2 = getPasseDTO(PASSE_ID_2, PASSE_SCHUETZE_NR_2);
        // change lfdnr of passe2 to make them distinguishable
        passe2.setLfdNr(PASSE_LFDR_NR + 1);

        List<PasseDTO> passeDTOS = new ArrayList<>();
        passeDTOS.add(passe1);
        passeDTOS.add(passe2);

        matchDTO.setPassen(passeDTOS);

        ArrayList<MatchDTO> matches = new ArrayList<>();
        matches.add(matchDTO);
        matches.add(matchDTO);

        when(mannschaftsmitgliedComponent.findAllSchuetzeInTeam(anyLong())).thenReturn(getMannschaftsMitglieder());

        final List<MatchDTO> actual = underTest.saveMatches(matches, principal);
        assertThat(actual).isNotNull().isNotEmpty().hasSize(2);
        MatchService.checkPreconditions(actual.get(0), MatchService.matchConditionErrors);
        MatchService.checkPreconditions(actual.get(1), MatchService.matchConditionErrors);

        // make sure update was called twice per passed DTO
        verify(passeComponent, times(4)).update(any(PasseDO.class), eq(CURRENT_USER_ID));
    }

    @Test
    public void saveMatches_WithPasseUpdate_Null() {
        MatchDO matchDO1 = getMatchDO();
        MatchDTO matchDTO = MatchDTOMapper.toDTO.apply(matchDO1);

        PasseDTO passe1 = getPasseDTO(PASSE_ID_1, PASSE_SCHUETZE_NR_1);
        PasseDTO passe2 = getPasseDTO(PASSE_ID_2, PASSE_SCHUETZE_NR_2);
        // change lfdnr of passe2 to make them distinguishable
        passe2.setLfdNr(PASSE_LFDR_NR + 1);

        List<PasseDTO> passeDTOS = new ArrayList<>();
        passeDTOS.add(passe1);
        passeDTOS.add(passe2);

        passeDTOS.set(0, null);

        matchDTO.setPassen(passeDTOS);

        when(mannschaftsmitgliedComponent.findAllSchuetzeInTeam(anyLong())).thenReturn(getMannschaftsMitglieder());

        ArrayList<MatchDTO> matches = new ArrayList<>();
        matches.add(matchDTO);
        matches.add(matchDTO);
        assertThatThrownBy(() -> {
            underTest.saveMatches(matches, principal);
        }).isInstanceOf(BusinessException.class);
    }


    @Test
    public void saveMatches_WithPasseCreate() {
        MatchDO matchDO1 = getMatchDO();
        MatchDTO matchDTO = MatchDTOMapper.toDTO.apply(matchDO1);

        PasseDTO passe1 = getPasseDTO(null, PASSE_SCHUETZE_NR_1);
        PasseDTO passe2 = getPasseDTO(null, PASSE_SCHUETZE_NR_2);
        // change lfdnr of passe2 to make them distinguishable
        passe2.setLfdNr(PASSE_LFDR_NR + 1);

        List<PasseDTO> passeDTOS = new ArrayList<>();
        passeDTOS.add(passe1);
        passeDTOS.add(passe2);

        matchDTO.setPassen(passeDTOS);

        ArrayList<MatchDTO> matches = new ArrayList<>();
        matches.add(matchDTO);
        matches.add(matchDTO);

        when(mannschaftsmitgliedComponent.findAllSchuetzeInTeam(anyLong())).thenReturn(getMannschaftsMitglieder());

        final List<MatchDTO> actual = underTest.saveMatches(matches, principal);
        assertThat(actual).isNotNull().isNotEmpty().hasSize(2);
        MatchService.checkPreconditions(actual.get(0), MatchService.matchConditionErrors);
        MatchService.checkPreconditions(actual.get(1), MatchService.matchConditionErrors);

        // make sure create was called twice per passed DTO
        verify(passeComponent, times(4)).create(any(PasseDO.class), eq(CURRENT_USER_ID));
    }


    @Test
    public void create() {
        MatchDO matchDO1 = getMatchDO();
        MatchDTO matchDTO = MatchDTOMapper.toDTO.apply(matchDO1);
        when(matchComponent.create(any(MatchDO.class), anyLong())).thenReturn(matchDO1);
        final MatchDTO actual = underTest.create(matchDTO, principal);
        assertThat(actual).isNotNull();
        MatchService.checkPreconditions(actual, MatchService.matchConditionErrors);
    }


    @Test
    public void create_Null() {
        assertThatThrownBy(() -> {
            underTest.create(null, principal);
        }).isInstanceOf(BusinessException.class);
    }


    @Test
    public void update() {
        MatchDO matchDO1 = getMatchDO();
        MatchDTO matchDTO = MatchDTOMapper.toDTO.apply(matchDO1);
        when(matchComponent.update(any(MatchDO.class), anyLong())).thenReturn(matchDO1);
        final MatchDTO actual = underTest.update(matchDTO, principal);
        assertThat(actual).isNotNull();
        MatchService.checkPreconditions(actual, MatchService.matchConditionErrors);
    }


    @Test
    public void update_Null() {
        assertThatThrownBy(() -> {
            underTest.update(null, principal);
        }).isInstanceOf(BusinessException.class);
    }
}