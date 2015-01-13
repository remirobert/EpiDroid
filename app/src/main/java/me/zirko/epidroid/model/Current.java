package me.zirko.epidroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Current {

    @SerializedName("active_log")
    @Expose
    private String activeLog;
    @SerializedName("credits_min")
    @Expose
    private String creditsMin;
    @SerializedName("credits_norm")
    @Expose
    private String creditsNorm;
    @SerializedName("credits_obj")
    @Expose
    private String creditsObj;
    @SerializedName("nslog_min")
    @Expose
    private String nslogMin;
    @SerializedName("nslog_norm")
    @Expose
    private String nslogNorm;
    @SerializedName("semester_code")
    @Expose
    private String semesterCode;
    @SerializedName("semester_num")
    @Expose
    private String semesterNum;
    @Expose
    private Integer achieved;
    @Expose
    private Integer failed;
    @Expose
    private Integer inprogress;

    /**
     * @return The activeLog
     */
    public String getActiveLog() {
        return activeLog;
    }

    /**
     * @param activeLog The active_log
     */
    public void setActiveLog(String activeLog) {
        this.activeLog = activeLog;
    }

    /**
     * @return The creditsMin
     */
    public String getCreditsMin() {
        return creditsMin;
    }

    /**
     * @param creditsMin The credits_min
     */
    public void setCreditsMin(String creditsMin) {
        this.creditsMin = creditsMin;
    }

    /**
     * @return The creditsNorm
     */
    public String getCreditsNorm() {
        return creditsNorm;
    }

    /**
     * @param creditsNorm The credits_norm
     */
    public void setCreditsNorm(String creditsNorm) {
        this.creditsNorm = creditsNorm;
    }

    /**
     * @return The creditsObj
     */
    public String getCreditsObj() {
        return creditsObj;
    }

    /**
     * @param creditsObj The credits_obj
     */
    public void setCreditsObj(String creditsObj) {
        this.creditsObj = creditsObj;
    }

    /**
     * @return The nslogMin
     */
    public String getNslogMin() {
        return nslogMin;
    }

    /**
     * @param nslogMin The nslog_min
     */
    public void setNslogMin(String nslogMin) {
        this.nslogMin = nslogMin;
    }

    /**
     * @return The nslogNorm
     */
    public String getNslogNorm() {
        return nslogNorm;
    }

    /**
     * @param nslogNorm The nslog_norm
     */
    public void setNslogNorm(String nslogNorm) {
        this.nslogNorm = nslogNorm;
    }

    /**
     * @return The semesterCode
     */
    public String getSemesterCode() {
        return semesterCode;
    }

    /**
     * @param semesterCode The semester_code
     */
    public void setSemesterCode(String semesterCode) {
        this.semesterCode = semesterCode;
    }

    /**
     * @return The semesterNum
     */
    public String getSemesterNum() {
        return semesterNum;
    }

    /**
     * @param semesterNum The semester_num
     */
    public void setSemesterNum(String semesterNum) {
        this.semesterNum = semesterNum;
    }

    /**
     * @return The achieved
     */
    public Integer getAchieved() {
        return achieved;
    }

    /**
     * @param achieved The achieved
     */
    public void setAchieved(Integer achieved) {
        this.achieved = achieved;
    }

    /**
     * @return The failed
     */
    public Integer getFailed() {
        return failed;
    }

    /**
     * @param failed The failed
     */
    public void setFailed(Integer failed) {
        this.failed = failed;
    }

    /**
     * @return The inprogress
     */
    public Integer getInprogress() {
        return inprogress;
    }

    /**
     * @param inprogress The inprogress
     */
    public void setInprogress(Integer inprogress) {
        this.inprogress = inprogress;
    }

}
