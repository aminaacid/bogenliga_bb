package de.bogenliga.application.business.dsbmitglied.impl.entity;

import java.sql.Date;
import de.bogenliga.application.common.component.entity.BusinessEntity;
import de.bogenliga.application.common.component.entity.CommonBusinessEntity;

/**
 * I represent the dsbmitglied business entity <b>BUT</b> with the omission of the club name ("Vereinsname").
 * <p>
 * This class is <b>ONLY used for creating, updating and deleting</b> a DsbMitglied.
 * <p>
 * A dsbmitglied is a registered member of the DSB. The dsbmitglied is not necessarily a technical user of the system.
 * <p>
 * The {@link CommonBusinessEntity} contains the technical parameter. Business entities commonly use these parameters to
 * control their lifecycle.
 *
 * @see CommonBusinessEntity
 * @author Nikolas Orfanidis
 */
public class DsbMitgliedWithoutVereinsnameBE extends CommonBusinessEntity implements BusinessEntity {

    private static final long serialVersionUID = -76389969048178948L;
    private Long dsbMitgliedId;
    private String dsbMitgliedVorname;
    private String dsbMitgliedNachname;
    private Date dsbMitgliedGeburtsdatum;
    private String dsbMitgliedNationalitaet;
    private String dsbMitgliedMitgliedsnummer;
    private Long dsbMitgliedVereinsId;
    private Long dsbMitgliedUserId;
    private Date dsbMitgliedBeitrittsdatum;


    public DsbMitgliedWithoutVereinsnameBE(){
        // empty constructor
    }


    public DsbMitgliedWithoutVereinsnameBE(Long dsbMitgliedId, String dsbMitgliedVorname, String dsbMitgliedNachname,
                                           Date dsbMitgliedGeburtsdatum, String dsbMitgliedNationalitaet,
                                           String dsbMitgliedMitgliedsnummer, Long dsbMitgliedVereinsId,
                                           Long dsbMitgliedUserId, Date dsbMitgliedBeitrittsdatum) {
        this.dsbMitgliedId = dsbMitgliedId;
        this.dsbMitgliedVorname = dsbMitgliedVorname;
        this.dsbMitgliedNachname = dsbMitgliedNachname;
        this.dsbMitgliedGeburtsdatum = dsbMitgliedGeburtsdatum;
        this.dsbMitgliedNationalitaet = dsbMitgliedNationalitaet;
        this.dsbMitgliedMitgliedsnummer = dsbMitgliedMitgliedsnummer;
        this.dsbMitgliedVereinsId = dsbMitgliedVereinsId;
        this.dsbMitgliedUserId = dsbMitgliedUserId;
        this.dsbMitgliedBeitrittsdatum = dsbMitgliedBeitrittsdatum;
    }


    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }


    public Long getDsbMitgliedId() {
        return dsbMitgliedId;
    }


    public void setDsbMitgliedId(final Long dsbMitgliedId) {
        this.dsbMitgliedId = dsbMitgliedId;
    }

    public String getDsbMitgliedVorname() {
        return dsbMitgliedVorname;
    }


    public void setDsbMitgliedVorname(final String dsbMitgliedVorname) {
        this.dsbMitgliedVorname = dsbMitgliedVorname;
    }

    public String getDsbMitgliedNachname() {
        return dsbMitgliedNachname;
    }


    public void setDsbMitgliedNachname(final String dsbMitgliedNachname) {
        this.dsbMitgliedNachname = dsbMitgliedNachname;
    }


    public Date getDsbMitgliedGeburtsdatum() {
        return dsbMitgliedGeburtsdatum;
    }


    public void setDsbMitgliedGeburtsdatum(final Date dsbMitgliedGeburtsdatum) {
        this.dsbMitgliedGeburtsdatum = dsbMitgliedGeburtsdatum;
    }

    public String getDsbMitgliedNationalitaet() {
        return dsbMitgliedNationalitaet;
    }


    public void setDsbMitgliedNationalitaet(final String dsbMitgliedNationalitaet) {
        this.dsbMitgliedNationalitaet = dsbMitgliedNationalitaet;
    }

    public String getDsbMitgliedMitgliedsnummer() {
        return dsbMitgliedMitgliedsnummer;
    }


    public void setDsbMitgliedMitgliedsnummer(final String dsbMitgliedMitgliedsnummer) {
        this.dsbMitgliedMitgliedsnummer = dsbMitgliedMitgliedsnummer;
    }


    public Long getDsbMitgliedVereinsId() {
        return dsbMitgliedVereinsId;
    }


    public void setDsbMitgliedVereinsId(final Long dsbMitgliedVereinsId) {
        this.dsbMitgliedVereinsId = dsbMitgliedVereinsId;
    }

    public Long getDsbMitgliedUserId() {
        return dsbMitgliedUserId;
    }


    public void setDsbMitgliedUserId(final Long dsbMitgliedUserId) {
        this.dsbMitgliedUserId = dsbMitgliedUserId;
    }

    public Date getDsbMitgliedBeitrittsdatum() {
        return dsbMitgliedBeitrittsdatum;
    }


    public void setDsbMitgliedBeitrittsdatum(final Date dsbMitgliedBeitrittsdatum) {
        this.dsbMitgliedBeitrittsdatum = dsbMitgliedBeitrittsdatum;
    }

    @Override
    public String toString() {
        return "DsbMitgliedWithoutVereinsNameBE{" +
                "dsbMitgliedId=" + dsbMitgliedId +
                ", dsbMitgliedVorname='" + dsbMitgliedVorname + '\'' +
                ", dsbMitgliedNachname='" + dsbMitgliedNachname + '\'' +
                ", dsbMitgliedGeburtsdatum='" + dsbMitgliedGeburtsdatum + '\'' +
                ", dsbMitgliedNationalitaet='" + dsbMitgliedNationalitaet + '\'' +
                ", dsbMitgliedMitgliedsnummer='" + dsbMitgliedMitgliedsnummer + '\'' +
                ", dsbMitgliedVereinsId=" + dsbMitgliedVereinsId +
                ", dsbMitgliedUserId=" + dsbMitgliedUserId +
                ", dsbMitgliedBeitrittsdatum=" + dsbMitgliedBeitrittsdatum +
                '}';
    }
}
