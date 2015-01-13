package me.zirko.epidroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stage {

    @Expose
    private String company;
    @Expose
    private String link;
    @SerializedName("timeline_start")
    @Expose
    private String timelineStart;
    @SerializedName("timeline_end")
    @Expose
    private String timelineEnd;
    @SerializedName("timeline_barre")
    @Expose
    private String timelineBarre;
    @SerializedName("can_note")
    @Expose
    private Boolean canNote;
    @SerializedName("company_can_note")
    @Expose
    private Boolean companyCanNote;
    @Expose
    private String status;
    @Expose
    private Boolean mandatory;

    /**
     * @return The company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company The company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return The link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link The link
     */
    public void setLink(String link) {
        this.link = link;
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
     * @return The canNote
     */
    public Boolean getCanNote() {
        return canNote;
    }

    /**
     * @param canNote The can_note
     */
    public void setCanNote(Boolean canNote) {
        this.canNote = canNote;
    }

    /**
     * @return The companyCanNote
     */
    public Boolean getCompanyCanNote() {
        return companyCanNote;
    }

    /**
     * @param companyCanNote The company_can_note
     */
    public void setCompanyCanNote(Boolean companyCanNote) {
        this.companyCanNote = companyCanNote;
    }

    /**
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return The mandatory
     */
    public Boolean getMandatory() {
        return mandatory;
    }

    /**
     * @param mandatory The mandatory
     */
    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

}
