package me.zirko.epidroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Projet {

    @Expose
    private String title;
    @SerializedName("title_link")
    @Expose
    private String titleLink;
    @SerializedName("timeline_start")
    @Expose
    private String timelineStart;
    @SerializedName("timeline_end")
    @Expose
    private String timelineEnd;
    @SerializedName("timeline_barre")
    @Expose
    private String timelineBarre;
    @SerializedName("id_activite")
    @Expose
    private String idActivite;

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
     * @return The titleLink
     */
    public String getTitleLink() {
        return titleLink;
    }

    /**
     * @param titleLink The title_link
     */
    public void setTitleLink(String titleLink) {
        this.titleLink = titleLink;
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
     * @return The timelineEnd
     */
    public String getTimelineEnd() {
        return timelineEnd;
    }

    /**
     * @param timelineEnd The timeline_end
     */
    public void setTimelineEnd(String timelineEnd) {
        this.timelineEnd = timelineEnd;
    }

    /**
     * @return The timelineBarre
     */
    public String getTimelineBarre() {
        return timelineBarre;
    }

    /**
     * @param timelineBarre The timeline_barre
     */
    public void setTimelineBarre(String timelineBarre) {
        this.timelineBarre = timelineBarre;
    }

    /**
     * @return The idActivite
     */
    public String getIdActivite() {
        return idActivite;
    }

    /**
     * @param idActivite The id_activite
     */
    public void setIdActivite(String idActivite) {
        this.idActivite = idActivite;
    }
}
