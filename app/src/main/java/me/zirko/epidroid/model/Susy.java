package me.zirko.epidroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Susy {

    @Expose
    private String title;
    @SerializedName("creneau_link")
    @Expose
    private String creneauLink;
    @SerializedName("timeline_start")
    @Expose
    private String timelineStart;
    @SerializedName("timeline_barre")
    @Expose
    private Boolean timelineBarre;
    @SerializedName("timeline_end")
    @Expose
    private Boolean timelineEnd;
    @Expose
    private Boolean salle;
    @Expose
    private Boolean intervenant;
    @Expose
    private String etat;
    @Expose
    private Boolean type;

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The creneauLink
     */
    public String getCreneauLink() {
        return creneauLink;
    }

    /**
     * @param creneauLink The creneau_link
     */
    public void setCreneauLink(String creneauLink) {
        this.creneauLink = creneauLink;
    }

    /**
     * @return The timelineStart
     */
    public String getTimelineStart() {
        return timelineStart;
    }

    /**
     * @param timelineStart The timeline_start
     */
    public void setTimelineStart(String timelineStart) {
        this.timelineStart = timelineStart;
    }

    /**
     * @return The timelineBarre
     */
    public Boolean getTimelineBarre() {
        return timelineBarre;
    }

    /**
     * @param timelineBarre The timeline_barre
     */
    public void setTimelineBarre(Boolean timelineBarre) {
        this.timelineBarre = timelineBarre;
    }

    /**
     * @return The timelineEnd
     */
    public Boolean getTimelineEnd() {
        return timelineEnd;
    }

    /**
     * @param timelineEnd The timeline_end
     */
    public void setTimelineEnd(Boolean timelineEnd) {
        this.timelineEnd = timelineEnd;
    }

    /**
     * @return The salle
     */
    public Boolean getSalle() {
        return salle;
    }

    /**
     * @param salle The salle
     */
    public void setSalle(Boolean salle) {
        this.salle = salle;
    }

    /**
     * @return The intervenant
     */
    public Boolean getIntervenant() {
        return intervenant;
    }

    /**
     * @param intervenant The intervenant
     */
    public void setIntervenant(Boolean intervenant) {
        this.intervenant = intervenant;
    }

    /**
     * @return The etat
     */
    public String getEtat() {
        return etat;
    }

    /**
     * @param etat The etat
     */
    public void setEtat(String etat) {
        this.etat = etat;
    }

    /**
     * @return The type
     */
    public Boolean getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(Boolean type) {
        this.type = type;
    }

}
