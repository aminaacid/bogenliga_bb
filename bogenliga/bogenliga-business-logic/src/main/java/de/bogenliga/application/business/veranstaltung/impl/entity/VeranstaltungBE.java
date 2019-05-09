package de.bogenliga.application.business.veranstaltung.impl.entity;

import java.sql.Date;
import de.bogenliga.application.common.component.entity.BusinessEntity;
import de.bogenliga.application.common.component.entity.CommonBusinessEntity;

/**
 * TODO [AL] class documentation
 *
 * @author Daniel Schott, daniel.schott@student.reutlingen-university.de
 */
public class VeranstaltungBE extends CommonBusinessEntity implements BusinessEntity{


    private static final long serialVersionUID = -7987623598712368L;
    private Long veranstaltungID;
    private Long veranstaltungWettkampftypID;
    private String veranstaltungName;
    private Long veranstaltungSportJahr;
    private Date veranstaltungMeldeDeadline;
    private Long veranstaltungKampfrichterAnzahl;
    private Long veranstaltungHoehere;
    private Long veranstaltungLigaleiterID;

    /**
     * Default Constructor of VeranstaltungBE
     */
    public VeranstaltungBE(){
        // empty constructor
    }

    //autogenerated getter and setters of all attributes.
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getVeranstaltungID() {
        return veranstaltungID;
    }

    public void setVeranstaltungID(Long veranstaltungID) {
        this.veranstaltungID = veranstaltungID;
    }

    public Long getVeranstaltungWettkampftypID() {
        return veranstaltungWettkampftypID;
    }

    public void setVeranstaltungWettkampftypID(Long veranstaltungWettkampftypID) {
        this.veranstaltungWettkampftypID = veranstaltungWettkampftypID;
    }

    public String getVeranstaltungName() {
        return veranstaltungName;
    }

    public void setVeranstaltungName(String veranstaltungName) {
        this.veranstaltungName = veranstaltungName;
    }

    public Long getVeranstaltungSportJahr() {
        return veranstaltungSportJahr;
    }

    public void setVeranstaltungSportJahr(Long veranstaltungSportJahr) {
        this.veranstaltungSportJahr = veranstaltungSportJahr;
    }

    public Date getVeranstaltungMeldeDeadline() {
        return veranstaltungMeldeDeadline;
    }

    public void setVeranstaltungMeldeDeadline(Date veranstaltungMeldeDeadline) {
        this.veranstaltungMeldeDeadline = veranstaltungMeldeDeadline;
    }

    public Long getVeranstaltungKampfrichterAnzahl() {
        return veranstaltungKampfrichterAnzahl;
    }

    public void setVeranstaltungKampfrichterAnzahl(Long veranstaltungKampfrichterAnzahl) {
        this.veranstaltungKampfrichterAnzahl = veranstaltungKampfrichterAnzahl;
    }

    public Long getVeranstaltungHoehere() {
        return veranstaltungHoehere;
    }

    public void setVeranstaltungHoehere(Long veranstaltungHoehere) {
        this.veranstaltungHoehere = veranstaltungHoehere;
    }

    public Long getVeranstaltungLigaleiterID() {
        return veranstaltungLigaleiterID;
    }

    public void setVeranstaltungLigaleiterID(Long veranstaltungLigaleiterID) {
        this.veranstaltungLigaleiterID = veranstaltungLigaleiterID;
    }

    @Override
    public String toString() {
        return "VeranstaltungBE{" +
                "veranstaltung_id='" + this.veranstaltungID + '\'' +
                ", wettkampf_id='" + veranstaltungWettkampftypID + '\'' +
                ", name='" + veranstaltungName + '\'' +
                ", sportjahr='" + this.veranstaltungSportJahr + '\'' +
                ", meldedeadline='" + this.veranstaltungMeldeDeadline + '\'' +
                ", ligaleiter_id='" + this.veranstaltungLigaleiterID + '\'' +
                "}";
    }
}
