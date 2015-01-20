
package me.zirko.epidroid.model.DetailModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Activite {

    private String codeacti;
    private String callIhk;
    private String slug;
    private String instanceLocation;
    private String moduleTitle;
    private String title;
    private String description;
    private String typeTitle;
    private String typeCode;
    private String begin;
    private String start;
    private String endRegister;
    private String deadline;
    private String end;
    private Object nbHours;
    private Integer nbGroup;
    private Integer num;
    private String register;
    private String registerByBloc;
    private String registerProf;
    private Object titleLocationType;
    private Boolean isProjet;
    private String idProjet;
    private String projectTitle;
    private Boolean isNote;
    private Object nbNotes;
    private Boolean isBlocins;
    private String rdvStatus;
    private Object idBareme;
    private Object titleBareme;
    private String archive;
    private Object hashElearning;
    private Object gedNodeAdm;
    private Object nbPlanified;
    private Object note;
    private Object project;
    private List<Object> events = new ArrayList<Object>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The callIhk
     */
    public String getCallIhk() {
        return callIhk;
    }

    /**
     * 
     * @param callIhk
     *     The call_ihk
     */
    public void setCallIhk(String callIhk) {
        this.callIhk = callIhk;
    }

    /**
     * 
     * @return
     *     The slug
     */
    public String getSlug() {
        return slug;
    }

    /**
     * 
     * @param slug
     *     The slug
     */
    public void setSlug(String slug) {
        this.slug = slug;
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
     *     The moduleTitle
     */
    public String getModuleTitle() {
        return moduleTitle;
    }

    /**
     * 
     * @param moduleTitle
     *     The module_title
     */
    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
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
     *     The start
     */
    public String getStart() {
        return start;
    }

    /**
     * 
     * @param start
     *     The start
     */
    public void setStart(String start) {
        this.start = start;
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
     *     The deadline
     */
    public String getDeadline() {
        return deadline;
    }

    /**
     * 
     * @param deadline
     *     The deadline
     */
    public void setDeadline(String deadline) {
        this.deadline = deadline;
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
     *     The nbHours
     */
    public Object getNbHours() {
        return nbHours;
    }

    /**
     * 
     * @param nbHours
     *     The nb_hours
     */
    public void setNbHours(Object nbHours) {
        this.nbHours = nbHours;
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
     *     The num
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 
     * @param num
     *     The num
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 
     * @return
     *     The register
     */
    public String getRegister() {
        return register;
    }

    /**
     * 
     * @param register
     *     The register
     */
    public void setRegister(String register) {
        this.register = register;
    }

    /**
     * 
     * @return
     *     The registerByBloc
     */
    public String getRegisterByBloc() {
        return registerByBloc;
    }

    /**
     * 
     * @param registerByBloc
     *     The register_by_bloc
     */
    public void setRegisterByBloc(String registerByBloc) {
        this.registerByBloc = registerByBloc;
    }

    /**
     * 
     * @return
     *     The registerProf
     */
    public String getRegisterProf() {
        return registerProf;
    }

    /**
     * 
     * @param registerProf
     *     The register_prof
     */
    public void setRegisterProf(String registerProf) {
        this.registerProf = registerProf;
    }

    /**
     * 
     * @return
     *     The titleLocationType
     */
    public Object getTitleLocationType() {
        return titleLocationType;
    }

    /**
     * 
     * @param titleLocationType
     *     The title_location_type
     */
    public void setTitleLocationType(Object titleLocationType) {
        this.titleLocationType = titleLocationType;
    }

    /**
     * 
     * @return
     *     The isProjet
     */
    public Boolean getIsProjet() {
        return isProjet;
    }

    /**
     * 
     * @param isProjet
     *     The is_projet
     */
    public void setIsProjet(Boolean isProjet) {
        this.isProjet = isProjet;
    }

    /**
     * 
     * @return
     *     The idProjet
     */
    public String getIdProjet() {
        return idProjet;
    }

    /**
     * 
     * @param idProjet
     *     The id_projet
     */
    public void setIdProjet(String idProjet) {
        this.idProjet = idProjet;
    }

    /**
     * 
     * @return
     *     The projectTitle
     */
    public String getProjectTitle() {
        return projectTitle;
    }

    /**
     * 
     * @param projectTitle
     *     The project_title
     */
    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    /**
     * 
     * @return
     *     The isNote
     */
    public Boolean getIsNote() {
        return isNote;
    }

    /**
     * 
     * @param isNote
     *     The is_note
     */
    public void setIsNote(Boolean isNote) {
        this.isNote = isNote;
    }

    /**
     * 
     * @return
     *     The nbNotes
     */
    public Object getNbNotes() {
        return nbNotes;
    }

    /**
     * 
     * @param nbNotes
     *     The nb_notes
     */
    public void setNbNotes(Object nbNotes) {
        this.nbNotes = nbNotes;
    }

    /**
     * 
     * @return
     *     The isBlocins
     */
    public Boolean getIsBlocins() {
        return isBlocins;
    }

    /**
     * 
     * @param isBlocins
     *     The is_blocins
     */
    public void setIsBlocins(Boolean isBlocins) {
        this.isBlocins = isBlocins;
    }

    /**
     * 
     * @return
     *     The rdvStatus
     */
    public String getRdvStatus() {
        return rdvStatus;
    }

    /**
     * 
     * @param rdvStatus
     *     The rdv_status
     */
    public void setRdvStatus(String rdvStatus) {
        this.rdvStatus = rdvStatus;
    }

    /**
     * 
     * @return
     *     The idBareme
     */
    public Object getIdBareme() {
        return idBareme;
    }

    /**
     * 
     * @param idBareme
     *     The id_bareme
     */
    public void setIdBareme(Object idBareme) {
        this.idBareme = idBareme;
    }

    /**
     * 
     * @return
     *     The titleBareme
     */
    public Object getTitleBareme() {
        return titleBareme;
    }

    /**
     * 
     * @param titleBareme
     *     The title_bareme
     */
    public void setTitleBareme(Object titleBareme) {
        this.titleBareme = titleBareme;
    }

    /**
     * 
     * @return
     *     The archive
     */
    public String getArchive() {
        return archive;
    }

    /**
     * 
     * @param archive
     *     The archive
     */
    public void setArchive(String archive) {
        this.archive = archive;
    }

    /**
     * 
     * @return
     *     The hashElearning
     */
    public Object getHashElearning() {
        return hashElearning;
    }

    /**
     * 
     * @param hashElearning
     *     The hash_elearning
     */
    public void setHashElearning(Object hashElearning) {
        this.hashElearning = hashElearning;
    }

    /**
     * 
     * @return
     *     The gedNodeAdm
     */
    public Object getGedNodeAdm() {
        return gedNodeAdm;
    }

    /**
     * 
     * @param gedNodeAdm
     *     The ged_node_adm
     */
    public void setGedNodeAdm(Object gedNodeAdm) {
        this.gedNodeAdm = gedNodeAdm;
    }

    /**
     * 
     * @return
     *     The nbPlanified
     */
    public Object getNbPlanified() {
        return nbPlanified;
    }

    /**
     * 
     * @param nbPlanified
     *     The nb_planified
     */
    public void setNbPlanified(Object nbPlanified) {
        this.nbPlanified = nbPlanified;
    }

    /**
     * 
     * @return
     *     The note
     */
    public Object getNote() {
        return note;
    }

    /**
     * 
     * @param note
     *     The note
     */
    public void setNote(Object note) {
        this.note = note;
    }

    /**
     * 
     * @return
     *     The project
     */
    public Object getProject() {
        return project;
    }

    /**
     * 
     * @param project
     *     The project
     */
    public void setProject(Object project) {
        this.project = project;
    }

    /**
     * 
     * @return
     *     The events
     */
    public List<Object> getEvents() {
        return events;
    }

    /**
     * 
     * @param events
     *     The events
     */
    public void setEvents(List<Object> events) {
        this.events = events;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
