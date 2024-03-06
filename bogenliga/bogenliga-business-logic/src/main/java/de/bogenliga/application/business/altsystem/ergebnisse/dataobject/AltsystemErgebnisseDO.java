package de.bogenliga.application.business.altsystem.ergebnisse.dataobject;

import de.bogenliga.application.common.altsystem.AltsystemDO;

/**
 * Bean to store the data of the entity
 *
 * @author Andre Lehnert, eXXcellent solutions consulting & software gmbh
 */
public class AltsystemErgebnisseDO extends AltsystemDO {

    private Long schuetze_id;
    private int match;
    private Long ergebniss;


    public Long getSchuetze_Id() { return schuetze_id; }

    public void setSchuetze_Id( Long schuetze_id) {
        this.schuetze_id = schuetze_id;
    }
    public int getMatch() {
        return match;
    }
    public void setMatch(int match) {
        this.match = match;
    }

    public Long getErgebnis() {
        return ergebniss;
    }

    public void setErgebnis(Long ergebniss) {
        this.ergebniss = (ergebniss);
    }
}