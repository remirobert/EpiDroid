
package me.zirko.epidroid.model.DetailModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailModule {

    private String scolaryear;
    private String codemodule;
    private String codeinstance;
    private Integer semester;
    private String title;
    private String begin;
    private String endRegister;
    private String end;
    private String past;
    private String closed;
    private String opened;
    private Object userCredits;
    private Integer credits;
    private String description;
    private String competence;
    private String flags;
    private String instanceFlags;
    private Object maxIns;
    private String instanceLocation;
    private String hidden;
    private Object oldAclBackup;
    private List<Resp> resp = new ArrayList<Resp>();
    private List<Assistant> assistant = new ArrayList<Assistant>();
    private Object rights;
    private List<TemplateResp> templateResp = new ArrayList<TemplateResp>();
    private String allowRegister;
    private Integer studentRegistered;
    private Object studentGrade;
    private Integer studentCredits;
    private Object color;
    private Object studentFlags;
    private Boolean currentResp;
    private List<Activite> activites = new ArrayList<Activite>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The begin
     */
    public String getBegin() {
        return begin;
    }

    /**
     * 
     * @param begin
     *     The begin
     */
    public void setBegin(String begin) {
        this.begin = begin;
    }

    /**
     * 
     * @return
     *     The endRegister
     */
    public String getEndRegister() {
        return endRegister;
    }

    /**
     * 
     * @param endRegister
     *     The end_register
     */
    public void setEndRegister(String endRegister) {
        this.endRegister = endRegister;
    }

    /**
     * 
     * @return
     *     The end
     */
    public String getEnd() {
        return end;
    }

    /**
     * 
     * @param end
     *     The end
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * 
     * @return
     *     The past
     */
    public String getPast() {
        return past;
    }

    /**
     * 
     * @param past
     *     The past
     */
    public void setPast(String past) {
        this.past = past;
    }

    /**
     * 
     * @return
     *     The closed
     */
    public String getClosed() {
        return closed;
    }

    /**
     * 
     * @param closed
     *     The closed
     */
    public void setClosed(String closed) {
        this.closed = closed;
    }

    /**
     * 
     * @return
     *     The opened
     */
    public String getOpened() {
        return opened;
    }

    /**
     * 
     * @param opened
     *     The opened
     */
    public void setOpened(String opened) {
        this.opened = opened;
    }

    /**
     * 
     * @return
     *     The userCredits
     */
    public Object getUserCredits() {
        return userCredits;
    }

    /**
     * 
     * @param userCredits
     *     The user_credits
     */
    public void setUserCredits(Object userCredits) {
        this.userCredits = userCredits;
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
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The competence
     */
    public String getCompetence() {
        return competence;
    }

    /**
     * 
     * @param competence
     *     The competence
     */
    public void setCompetence(String competence) {
        this.competence = competence;
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
     *     The instanceFlags
     */
    public String getInstanceFlags() {
        return instanceFlags;
    }

    /**
     * 
     * @param instanceFlags
     *     The instance_flags
     */
    public void setInstanceFlags(String instanceFlags) {
        this.instanceFlags = instanceFlags;
    }

    /**
     * 
     * @return
     *     The maxIns
     */
    public Object getMaxIns() {
        return maxIns;
    }

    /**
     * 
     * @param maxIns
     *     The max_ins
     */
    public void setMaxIns(Object maxIns) {
        this.maxIns = maxIns;
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
     *     The hidden
     */
    public String getHidden() {
        return hidden;
    }

    /**
     * 
     * @param hidden
     *     The hidden
     */
    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    /**
     * 
     * @return
     *     The oldAclBackup
     */
    public Object getOldAclBackup() {
        return oldAclBackup;
    }

    /**
     * 
     * @param oldAclBackup
     *     The old_acl_backup
     */
    public void setOldAclBackup(Object oldAclBackup) {
        this.oldAclBackup = oldAclBackup;
    }

    /**
     * 
     * @return
     *     The resp
     */
    public List<Resp> getResp() {
        return resp;
    }

    /**
     * 
     * @param resp
     *     The resp
     */
    public void setResp(List<Resp> resp) {
        this.resp = resp;
    }

    /**
     * 
     * @return
     *     The assistant
     */
    public List<Assistant> getAssistant() {
        return assistant;
    }

    /**
     * 
     * @param assistant
     *     The assistant
     */
    public void setAssistant(List<Assistant> assistant) {
        this.assistant = assistant;
    }

    /**
     * 
     * @return
     *     The rights
     */
    public Object getRights() {
        return rights;
    }

    /**
     * 
     * @param rights
     *     The rights
     */
    public void setRights(Object rights) {
        this.rights = rights;
    }

    /**
     * 
     * @return
     *     The templateResp
     */
    public List<TemplateResp> getTemplateResp() {
        return templateResp;
    }

    /**
     * 
     * @param templateResp
     *     The template_resp
     */
    public void setTemplateResp(List<TemplateResp> templateResp) {
        this.templateResp = templateResp;
    }

    /**
     * 
     * @return
     *     The allowRegister
     */
    public String getAllowRegister() {
        return allowRegister;
    }

    /**
     * 
     * @param allowRegister
     *     The allow_register
     */
    public void setAllowRegister(String allowRegister) {
        this.allowRegister = allowRegister;
    }

    /**
     * 
     * @return
     *     The studentRegistered
     */
    public Integer getStudentRegistered() {
        return studentRegistered;
    }

    /**
     * 
     * @param studentRegistered
     *     The student_registered
     */
    public void setStudentRegistered(Integer studentRegistered) {
        this.studentRegistered = studentRegistered;
    }

    /**
     * 
     * @return
     *     The studentGrade
     */
    public Object getStudentGrade() {
        return studentGrade;
    }

    /**
     * 
     * @param studentGrade
     *     The student_grade
     */
    public void setStudentGrade(Object studentGrade) {
        this.studentGrade = studentGrade;
    }

    /**
     * 
     * @return
     *     The studentCredits
     */
    public Integer getStudentCredits() {
        return studentCredits;
    }

    /**
     * 
     * @param studentCredits
     *     The student_credits
     */
    public void setStudentCredits(Integer studentCredits) {
        this.studentCredits = studentCredits;
    }

    /**
     * 
     * @return
     *     The color
     */
    public Object getColor() {
        return color;
    }

    /**
     * 
     * @param color
     *     The color
     */
    public void setColor(Object color) {
        this.color = color;
    }

    /**
     * 
     * @return
     *     The studentFlags
     */
    public Object getStudentFlags() {
        return studentFlags;
    }

    /**
     * 
     * @param studentFlags
     *     The student_flags
     */
    public void setStudentFlags(Object studentFlags) {
        this.studentFlags = studentFlags;
    }

    /**
     * 
     * @return
     *     The currentResp
     */
    public Boolean getCurrentResp() {
        return currentResp;
    }

    /**
     * 
     * @param currentResp
     *     The current_resp
     */
    public void setCurrentResp(Boolean currentResp) {
        this.currentResp = currentResp;
    }

    /**
     * 
     * @return
     *     The activites
     */
    public List<Activite> getActivites() {
        return activites;
    }

    /**
     * 
     * @param activites
     *     The activites
     */
    public void setActivites(List<Activite> activites) {
        this.activites = activites;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
