package me.zirko.epidroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Activite {

    @Expose
    private String title;
    @Expose
    private String module;
    @SerializedName("module_link")
    @Expose
    private String moduleLink;
    @SerializedName("module_code")
    @Expose
    private String moduleCode;
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
    @SerializedName("date_inscription")
    @Expose
    private Boolean dateInscription;
    @Expose
    private String salle;
    @Expose
    private String intervenant;
    @Expose
    private Object token;
    @SerializedName("token_link")
    @Expose
    private String tokenLink;
    @SerializedName("register_link")
    @Expose
    private String registerLink;

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
     * @return The module
     */
    public String getModule() {
        return module;
    }

    /**
     * @param module The module
     */
    public void setModule(String module) {
        this.module = module;
    }

    /**
     * @return The moduleLink
     */
    public String getModuleLink() {
        return moduleLink;
    }

    /**
     * @param moduleLink The module_link
     */
    public void setModuleLink(String moduleLink) {
        this.moduleLink = moduleLink;
    }

    /**
     * @return The moduleCode
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * @param moduleCode The module_code
     */
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
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
     * @return The dateInscription
     */
    public Boolean getDateInscription() {
        return dateInscription;
    }

    /**
     * @param dateInscription The date_inscription
     */
    public void setDateInscription(Boolean dateInscription) {
        this.dateInscription = dateInscription;
    }

    /**
     * @return The salle
     */
    public String getSalle() {
        return salle;
    }

    /**
     * @param salle The salle
     */
    public void setSalle(String salle) {
        this.salle = salle;
    }

    /**
     * @return The intervenant
     */
    public String getIntervenant() {
        return intervenant;
    }

    /**
     * @param intervenant The intervenant
     */
    public void setIntervenant(String intervenant) {
        this.intervenant = intervenant;
    }

    /**
     * @return The token
     */
    public Object getToken() {
        return token;
    }

    /**
     * @param token The token
     */
    public void setToken(Object token) {
        this.token = token;
    }

    /**
     * @return The tokenLink
     */
    public String getTokenLink() {
        return tokenLink;
    }

    /**
     * @param tokenLink The token_link
     */
    public void setTokenLink(String tokenLink) {
        this.tokenLink = tokenLink;
    }

    /**
     * @return The registerLink
     */
    public String getRegisterLink() {
        return registerLink;
    }

    /**
     * @param registerLink The register_link
     */
    public void setRegisterLink(String registerLink) {
        this.registerLink = registerLink;
    }

}
