package me.zirko.epidroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListModuleItem {

    @Expose
    private Integer scolaryear;
    @SerializedName("id_user_history")
    @Expose
    private String idUserHistory;
    @Expose
    private String codemodule;
    @Expose
    private String codeinstance;
    @Expose
    private String title;
    @SerializedName("id_instance")
    @Expose
    private String idInstance;
    @SerializedName("date_ins")
    @Expose
    private String dateIns;
    @Expose
    private String cycle;
    @Expose
    private String grade;
    @Expose
    private Integer credits;
    @Expose
    private String flags;
    @Expose
    private Integer barrage;
    @SerializedName("instance_id")
    @Expose
    private String instanceId;
    @SerializedName("module_rating")
    @Expose
    private String moduleRating;
    @Expose
    private Integer semester;

    /**
     * 
     * @return
     *     The scolaryear
     */
    public Integer getScolaryear() {
        return scolaryear;
    }

    /**
     * 
     * @param scolaryear
     *     The scolaryear
     */
    public void setScolaryear(Integer scolaryear) {
        this.scolaryear = scolaryear;
    }

    /**
     * 
     * @return
     *     The idUserHistory
     */
    public String getIdUserHistory() {
        return idUserHistory;
    }

    /**
     * 
     * @param idUserHistory
     *     The id_user_history
     */
    public void setIdUserHistory(String idUserHistory) {
        this.idUserHistory = idUserHistory;
    }

    /**
     * 
     * @return
     *     The codemodule
     */
    public String getCodemodule() {
        return codemodule;
    }

    /**
     * 
     * @param codemodule
     *     The codemodule
     */
    public void setCodemodule(String codemodule) {
        this.codemodule = codemodule;
    }

    /**
     * 
     * @return
     *     The codeinstance
     */
    public String getCodeinstance() {
        return codeinstance;
    }

    /**
     * 
     * @param codeinstance
     *     The codeinstance
     */
    public void setCodeinstance(String codeinstance) {
        this.codeinstance = codeinstance;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The idInstance
     */
    public String getIdInstance() {
        return idInstance;
    }

    /**
     * 
     * @param idInstance
     *     The id_instance
     */
    public void setIdInstance(String idInstance) {
        this.idInstance = idInstance;
    }

    /**
     * 
     * @return
     *     The dateIns
     */
    public String getDateIns() {
        return dateIns;
    }

    /**
     * 
     * @param dateIns
     *     The date_ins
     */
    public void setDateIns(String dateIns) {
        this.dateIns = dateIns;
    }

    /**
     * 
     * @return
     *     The cycle
     */
    public String getCycle() {
        return cycle;
    }

    /**
     * 
     * @param cycle
     *     The cycle
     */
    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    /**
     * 
     * @return
     *     The grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 
     * @param grade
     *     The grade
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * 
     * @return
     *     The credits
     */
    public Integer getCredits() {
        return credits;
    }

    /**
     * 
     * @param credits
     *     The credits
     */
    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    /**
     * 
     * @return
     *     The flags
     */
    public String getFlags() {
        return flags;
    }

    /**
     * 
     * @param flags
     *     The flags
     */
    public void setFlags(String flags) {
        this.flags = flags;
    }

    /**
     * 
     * @return
     *     The barrage
     */
    public Integer getBarrage() {
        return barrage;
    }

    /**
     * 
     * @param barrage
     *     The barrage
     */
    public void setBarrage(Integer barrage) {
        this.barrage = barrage;
    }

    /**
     * 
     * @return
     *     The instanceId
     */
    public String getInstanceId() {
        return instanceId;
    }

    /**
     * 
     * @param instanceId
     *     The instance_id
     */
    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    /**
     * 
     * @return
     *     The moduleRating
     */
    public String getModuleRating() {
        return moduleRating;
    }

    /**
     * 
     * @param moduleRating
     *     The module_rating
     */
    public void setModuleRating(String moduleRating) {
        this.moduleRating = moduleRating;
    }

    /**
     * 
     * @return
     *     The semester
     */
    public Integer getSemester() {
        return semester;
    }

    /**
     * 
     * @param semester
     *     The semester
     */
    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return title;
    }
}
