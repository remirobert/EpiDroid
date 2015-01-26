
package me.zirko.epidroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Schedule {

    @SerializedName("acti_title")
    @Expose
    private String actiTitle;
    @SerializedName("allow_register")
    @Expose
    private Boolean allowRegister;
    @SerializedName("allow_token")
    @Expose
    private Boolean allowToken;
    @SerializedName("allowed_planning_end")
    @Expose
    private String allowedPlanningEnd;
    @SerializedName("allowed_planning_start")
    @Expose
    private String allowedPlanningStart;
    @Expose
    private String codeacti;
    @Expose
    private String codeevent;
    @Expose
    private String codeinstance;
    @Expose
    private String codemodule;
    @Expose
    private Object dates;
    @Expose
    private Date end;
    @SerializedName("event_registered")
    @Expose
    private String eventRegistered;
    @SerializedName("in_more_than_one_month")
    @Expose
    private Boolean inMoreThanOneMonth;
    @SerializedName("instance_location")
    @Expose
    private String instanceLocation;
    @SerializedName("is_rdv")
    @Expose
    private String isRdv;
    @SerializedName("module_available")
    @Expose
    private Boolean moduleAvailable;
    @SerializedName("module_registered")
    @Expose
    private Boolean moduleRegistered;
    @SerializedName("nb_group")
    @Expose
    private Integer nbGroup;
    @SerializedName("nb_hours")
    @Expose
    private String nbHours;
    @SerializedName("nb_max_students_projet")
    @Expose
    private Object nbMaxStudentsProjet;
    @SerializedName("num_event")
    @Expose
    private Integer numEvent;
    @Expose
    private Boolean past;
    @SerializedName("prof_inst")
    @Expose
    private List<ProfInst> profInst = new ArrayList<ProfInst>();
    @Expose
    private Boolean project;
    @SerializedName("rdv_group_registered")
    @Expose
    private Object rdvGroupRegistered;
    @SerializedName("rdv_indiv_registered")
    @Expose
    private Object rdvIndivRegistered;
    @SerializedName("register_month")
    @Expose
    private Boolean registerMonth;
    @SerializedName("register_prof")
    @Expose
    private Boolean registerProf;
    @SerializedName("register_student")
    @Expose
    private Boolean registerStudent;
    @Expose
    private Room room;
    @Expose
    private String scolaryear;
    @Expose
    private Integer semester;
    @Expose
    private Date start;
    @Expose
    private Object title;
    @Expose
    private String titlemodule;
    @SerializedName("total_students_registered")
    @Expose
    private Integer totalStudentsRegistered;
    @SerializedName("type_code")
    @Expose
    private String typeCode;
    @SerializedName("type_title")
    @Expose
    private String typeTitle;

    /**
     * 
     * @return
     *     The actiTitle
     */
    public String getActiTitle() {
        return actiTitle;
    }

    /**
     * 
     * @param actiTitle
     *     The acti_title
     */
    public void setActiTitle(String actiTitle) {
        this.actiTitle = actiTitle;
    }

    /**
     * 
     * @return
     *     The allowRegister
     */
    public Boolean getAllowRegister() {
        return allowRegister;
    }

    /**
     * 
     * @param allowRegister
     *     The allow_register
     */
    public void setAllowRegister(Boolean allowRegister) {
        this.allowRegister = allowRegister;
    }

    /**
     * 
     * @return
     *     The allowToken
     */
    public Boolean getAllowToken() {
        return allowToken;
    }

    /**
     * 
     * @param allowToken
     *     The allow_token
     */
    public void setAllowToken(Boolean allowToken) {
        this.allowToken = allowToken;
    }

    /**
     * 
     * @return
     *     The allowedPlanningEnd
     */
    public String getAllowedPlanningEnd() {
        return allowedPlanningEnd;
    }

    /**
     * 
     * @param allowedPlanningEnd
     *     The allowed_planning_end
     */
    public void setAllowedPlanningEnd(String allowedPlanningEnd) {
        this.allowedPlanningEnd = allowedPlanningEnd;
    }

    /**
     * 
     * @return
     *     The allowedPlanningStart
     */
    public String getAllowedPlanningStart() {
        return allowedPlanningStart;
    }

    /**
     * 
     * @param allowedPlanningStart
     *     The allowed_planning_start
     */
    public void setAllowedPlanningStart(String allowedPlanningStart) {
        this.allowedPlanningStart = allowedPlanningStart;
    }

    /**
     * 
     * @return
     *     The codeacti
     */
    public String getCodeacti() {
        return codeacti;
    }

    /**
     * 
     * @param codeacti
     *     The codeacti
     */
    public void setCodeacti(String codeacti) {
        this.codeacti = codeacti;
    }

    /**
     * 
     * @return
     *     The codeevent
     */
    public String getCodeevent() {
        return codeevent;
    }

    /**
     * 
     * @param codeevent
     *     The codeevent
     */
    public void setCodeevent(String codeevent) {
        this.codeevent = codeevent;
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
     *     The dates
     */
    public Object getDates() {
        return dates;
    }

    /**
     * 
     * @param dates
     *     The dates
     */
    public void setDates(Object dates) {
        this.dates = dates;
    }

    /**
     * 
     * @return
     *     The end
     */
    public Date getEnd() {
        return end;
    }

    /**
     * 
     * @param end
     *     The end
     */
    public void setEnd(Date end) {
        this.end = end;
    }

    /**
     * 
     * @return
     *     The eventRegistered
     */
    public String getEventRegistered() {
        return eventRegistered;
    }

    /**
     * 
     * @param eventRegistered
     *     The event_registered
     */
    public void setEventRegistered(String eventRegistered) {
        this.eventRegistered = eventRegistered;
    }

    /**
     * 
     * @return
     *     The inMoreThanOneMonth
     */
    public Boolean getInMoreThanOneMonth() {
        return inMoreThanOneMonth;
    }

    /**
     * 
     * @param inMoreThanOneMonth
     *     The in_more_than_one_month
     */
    public void setInMoreThanOneMonth(Boolean inMoreThanOneMonth) {
        this.inMoreThanOneMonth = inMoreThanOneMonth;
    }

    /**
     * 
     * @return
     *     The instanceLocation
     */
    public String getInstanceLocation() {
        return instanceLocation;
    }

    /**
     * 
     * @param instanceLocation
     *     The instance_location
     */
    public void setInstanceLocation(String instanceLocation) {
        this.instanceLocation = instanceLocation;
    }

    /**
     * 
     * @return
     *     The isRdv
     */
    public String getIsRdv() {
        return isRdv;
    }

    /**
     * 
     * @param isRdv
     *     The is_rdv
     */
    public void setIsRdv(String isRdv) {
        this.isRdv = isRdv;
    }

    /**
     * 
     * @return
     *     The moduleAvailable
     */
    public Boolean getModuleAvailable() {
        return moduleAvailable;
    }

    /**
     * 
     * @param moduleAvailable
     *     The module_available
     */
    public void setModuleAvailable(Boolean moduleAvailable) {
        this.moduleAvailable = moduleAvailable;
    }

    /**
     * 
     * @return
     *     The moduleRegistered
     */
    public Boolean getModuleRegistered() {
        return moduleRegistered;
    }

    /**
     * 
     * @param moduleRegistered
     *     The module_registered
     */
    public void setModuleRegistered(Boolean moduleRegistered) {
        this.moduleRegistered = moduleRegistered;
    }

    /**
     * 
     * @return
     *     The nbGroup
     */
    public Integer getNbGroup() {
        return nbGroup;
    }

    /**
     * 
     * @param nbGroup
     *     The nb_group
     */
    public void setNbGroup(Integer nbGroup) {
        this.nbGroup = nbGroup;
    }

    /**
     * 
     * @return
     *     The nbHours
     */
    public String getNbHours() {
        return nbHours;
    }

    /**
     * 
     * @param nbHours
     *     The nb_hours
     */
    public void setNbHours(String nbHours) {
        this.nbHours = nbHours;
    }

    /**
     * 
     * @return
     *     The nbMaxStudentsProjet
     */
    public Object getNbMaxStudentsProjet() {
        return nbMaxStudentsProjet;
    }

    /**
     * 
     * @param nbMaxStudentsProjet
     *     The nb_max_students_projet
     */
    public void setNbMaxStudentsProjet(Object nbMaxStudentsProjet) {
        this.nbMaxStudentsProjet = nbMaxStudentsProjet;
    }

    /**
     * 
     * @return
     *     The numEvent
     */
    public Integer getNumEvent() {
        return numEvent;
    }

    /**
     * 
     * @param numEvent
     *     The num_event
     */
    public void setNumEvent(Integer numEvent) {
        this.numEvent = numEvent;
    }

    /**
     * 
     * @return
     *     The past
     */
    public Boolean getPast() {
        return past;
    }

    /**
     * 
     * @param past
     *     The past
     */
    public void setPast(Boolean past) {
        this.past = past;
    }

    /**
     * 
     * @return
     *     The profInst
     */
    public List<ProfInst> getProfInst() {
        return profInst;
    }

    /**
     * 
     * @param profInst
     *     The prof_inst
     */
    public void setProfInst(List<ProfInst> profInst) {
        this.profInst = profInst;
    }

    /**
     * 
     * @return
     *     The project
     */
    public Boolean getProject() {
        return project;
    }

    /**
     * 
     * @param project
     *     The project
     */
    public void setProject(Boolean project) {
        this.project = project;
    }

    /**
     * 
     * @return
     *     The rdvGroupRegistered
     */
    public Object getRdvGroupRegistered() {
        return rdvGroupRegistered;
    }

    /**
     * 
     * @param rdvGroupRegistered
     *     The rdv_group_registered
     */
    public void setRdvGroupRegistered(Object rdvGroupRegistered) {
        this.rdvGroupRegistered = rdvGroupRegistered;
    }

    /**
     * 
     * @return
     *     The rdvIndivRegistered
     */
    public Object getRdvIndivRegistered() {
        return rdvIndivRegistered;
    }

    /**
     * 
     * @param rdvIndivRegistered
     *     The rdv_indiv_registered
     */
    public void setRdvIndivRegistered(Object rdvIndivRegistered) {
        this.rdvIndivRegistered = rdvIndivRegistered;
    }

    /**
     * 
     * @return
     *     The registerMonth
     */
    public Boolean getRegisterMonth() {
        return registerMonth;
    }

    /**
     * 
     * @param registerMonth
     *     The register_month
     */
    public void setRegisterMonth(Boolean registerMonth) {
        this.registerMonth = registerMonth;
    }

    /**
     * 
     * @return
     *     The registerProf
     */
    public Boolean getRegisterProf() {
        return registerProf;
    }

    /**
     * 
     * @param registerProf
     *     The register_prof
     */
    public void setRegisterProf(Boolean registerProf) {
        this.registerProf = registerProf;
    }

    /**
     * 
     * @return
     *     The registerStudent
     */
    public Boolean getRegisterStudent() {
        return registerStudent;
    }

    /**
     * 
     * @param registerStudent
     *     The register_student
     */
    public void setRegisterStudent(Boolean registerStudent) {
        this.registerStudent = registerStudent;
    }

    /**
     * 
     * @return
     *     The room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * 
     * @param room
     *     The room
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * 
     * @return
     *     The scolaryear
     */
    public String getScolaryear() {
        return scolaryear;
    }

    /**
     * 
     * @param scolaryear
     *     The scolaryear
     */
    public void setScolaryear(String scolaryear) {
        this.scolaryear = scolaryear;
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

    /**
     * 
     * @return
     *     The start
     */
    public Date getStart() {
        return start;
    }

    /**
     * 
     * @param start
     *     The start
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     * 
     * @return
     *     The title
     */
    public Object getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(Object title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The titlemodule
     */
    public String getTitlemodule() {
        return titlemodule;
    }

    /**
     * 
     * @param titlemodule
     *     The titlemodule
     */
    public void setTitlemodule(String titlemodule) {
        this.titlemodule = titlemodule;
    }

    /**
     * 
     * @return
     *     The totalStudentsRegistered
     */
    public Integer getTotalStudentsRegistered() {
        return totalStudentsRegistered;
    }

    /**
     * 
     * @param totalStudentsRegistered
     *     The total_students_registered
     */
    public void setTotalStudentsRegistered(Integer totalStudentsRegistered) {
        this.totalStudentsRegistered = totalStudentsRegistered;
    }

    /**
     * 
     * @return
     *     The typeCode
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * 
     * @param typeCode
     *     The type_code
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * 
     * @return
     *     The typeTitle
     */
    public String getTypeTitle() {
        return typeTitle;
    }

    /**
     * 
     * @param typeTitle
     *     The type_title
     */
    public void setTypeTitle(String typeTitle) {
        this.typeTitle = typeTitle;
    }

}
