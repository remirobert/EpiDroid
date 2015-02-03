package me.zirko.epidroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Infos {

    @Expose
    private String id;
    @Expose
    private String login;
    @Expose
    private String title;
    @Expose
    private String email;
    @SerializedName("internal_email")
    @Expose
    private String internalEmail;
    @Expose
    private String lastname;
    @Expose
    private String firstname;
    @Expose
    private String userinfo;
    @SerializedName("referent_used")
    @Expose
    private Boolean referentUsed;
    @Expose
    private String picture;
    @SerializedName("picture_fun")
    @Expose
    private Object pictureFun;
    @SerializedName("email_referent")
    @Expose
    private Object emailReferent;
    @SerializedName("pass_referent")
    @Expose
    private String passReferent;
    @Expose
    private Integer promo;
    @Expose
    private Integer semester;
    @Expose
    private Integer uid;
    @Expose
    private Integer gid;
    @Expose
    private String location;
    @Expose
    private String documents;
    @Expose
    private String userdocs;
    @Expose
    private String shell;
    @Expose
    private Object netsoul;
    @Expose
    private Boolean close;
    @SerializedName("close_reason")
    @Expose
    private Object closeReason;
    @Expose
    private String ctime;
    @Expose
    private String mtime;
    @Expose
    private Object comment;
    @SerializedName("id_promo")
    @Expose
    private String idPromo;
    @SerializedName("id_history")
    @Expose
    private String idHistory;
    @SerializedName("course_code")
    @Expose
    private String courseCode;
    @SerializedName("school_code")
    @Expose
    private String schoolCode;
    @SerializedName("school_title")
    @Expose
    private String schoolTitle;
    @SerializedName("old_id_promo")
    @Expose
    private String oldIdPromo;
    @SerializedName("old_id_location")
    @Expose
    private String oldIdLocation;
    @Expose
    private Rights rights;
    @Expose
    private Boolean invited;
    @Expose
    private Integer studentyear;
    @Expose
    private Boolean admin;
    @Expose
    private Integer decoded;

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login The login
     */
    public void setLogin(String login) {
        this.login = login;
    }

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
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return The internalEmail
     */
    public String getInternalEmail() {
        return internalEmail;
    }

    /**
     * @param internalEmail The internal_email
     */
    public void setInternalEmail(String internalEmail) {
        this.internalEmail = internalEmail;
    }

    /**
     * @return The lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname The lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return The firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname The firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return The userinfo
     */
    public String getUserinfo() {
        return userinfo;
    }

    /**
     * @param userinfo The userinfo
     */
    public void setUserinfo(String userinfo) {
        this.userinfo = userinfo;
    }

    /**
     * @return The referentUsed
     */
    public Boolean getReferentUsed() {
        return referentUsed;
    }

    /**
     * @param referentUsed The referent_used
     */
    public void setReferentUsed(Boolean referentUsed) {
        this.referentUsed = referentUsed;
    }

    /**
     * @return The picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @param picture The picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * @return The pictureFun
     */
    public Object getPictureFun() {
        return pictureFun;
    }

    /**
     * @param pictureFun The picture_fun
     */
    public void setPictureFun(Object pictureFun) {
        this.pictureFun = pictureFun;
    }

    /**
     * @return The emailReferent
     */
    public Object getEmailReferent() {
        return emailReferent;
    }

    /**
     * @param emailReferent The email_referent
     */
    public void setEmailReferent(Object emailReferent) {
        this.emailReferent = emailReferent;
    }

    /**
     * @return The passReferent
     */
    public String getPassReferent() {
        return passReferent;
    }

    /**
     * @param passReferent The pass_referent
     */
    public void setPassReferent(String passReferent) {
        this.passReferent = passReferent;
    }

    /**
     * @return The promo
     */
    public Integer getPromo() {
        return promo;
    }

    /**
     * @param promo The promo
     */
    public void setPromo(Integer promo) {
        this.promo = promo;
    }

    /**
     * @return The semester
     */
    public Integer getSemester() {
        return semester;
    }

    /**
     * @param semester The semester
     */
    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    /**
     * @return The uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * @param uid The uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * @return The gid
     */
    public Integer getGid() {
        return gid;
    }

    /**
     * @param gid The gid
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * @return The location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location The location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return The documents
     */
    public String getDocuments() {
        return documents;
    }

    /**
     * @param documents The documents
     */
    public void setDocuments(String documents) {
        this.documents = documents;
    }

    /**
     * @return The userdocs
     */
    public String getUserdocs() {
        return userdocs;
    }

    /**
     * @param userdocs The userdocs
     */
    public void setUserdocs(String userdocs) {
        this.userdocs = userdocs;
    }

    /**
     * @return The shell
     */
    public String getShell() {
        return shell;
    }

    /**
     * @param shell The shell
     */
    public void setShell(String shell) {
        this.shell = shell;
    }

    /**
     * @return The netsoul
     */
    public Object getNetsoul() {
        return netsoul;
    }

    /**
     * @param netsoul The netsoul
     */
    public void setNetsoul(Object netsoul) {
        this.netsoul = netsoul;
    }

    /**
     * @return The close
     */
    public Boolean getClose() {
        return close;
    }

    /**
     * @param close The close
     */
    public void setClose(Boolean close) {
        this.close = close;
    }

    /**
     * @return The closeReason
     */
    public Object getCloseReason() {
        return closeReason;
    }

    /**
     * @param closeReason The close_reason
     */
    public void setCloseReason(Object closeReason) {
        this.closeReason = closeReason;
    }

    /**
     * @return The ctime
     */
    public String getCtime() {
        return ctime;
    }

    /**
     * @param ctime The ctime
     */
    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    /**
     * @return The mtime
     */
    public String getMtime() {
        return mtime;
    }

    /**
     * @param mtime The mtime
     */
    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    /**
     * @return The comment
     */
    public Object getComment() {
        return comment;
    }

    /**
     * @param comment The comment
     */
    public void setComment(Object comment) {
        this.comment = comment;
    }

    /**
     * @return The idPromo
     */
    public String getIdPromo() {
        return idPromo;
    }

    /**
     * @param idPromo The id_promo
     */
    public void setIdPromo(String idPromo) {
        this.idPromo = idPromo;
    }

    /**
     * @return The idHistory
     */
    public String getIdHistory() {
        return idHistory;
    }

    /**
     * @param idHistory The id_history
     */
    public void setIdHistory(String idHistory) {
        this.idHistory = idHistory;
    }

    /**
     * @return The courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * @param courseCode The course_code
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * @return The schoolCode
     */
    public String getSchoolCode() {
        return schoolCode;
    }

    /**
     * @param schoolCode The school_code
     */
    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    /**
     * @return The schoolTitle
     */
    public String getSchoolTitle() {
        return schoolTitle;
    }

    /**
     * @param schoolTitle The school_title
     */
    public void setSchoolTitle(String schoolTitle) {
        this.schoolTitle = schoolTitle;
    }

    /**
     * @return The oldIdPromo
     */
    public String getOldIdPromo() {
        return oldIdPromo;
    }

    /**
     * @param oldIdPromo The old_id_promo
     */
    public void setOldIdPromo(String oldIdPromo) {
        this.oldIdPromo = oldIdPromo;
    }

    /**
     * @return The oldIdLocation
     */
    public String getOldIdLocation() {
        return oldIdLocation;
    }

    /**
     * @param oldIdLocation The old_id_location
     */
    public void setOldIdLocation(String oldIdLocation) {
        this.oldIdLocation = oldIdLocation;
    }

    /**
     * @return The rights
     */
    public Rights getRights() {
        return rights;
    }

    /**
     * @param rights The rights
     */
    public void setRights(Rights rights) {
        this.rights = rights;
    }

    /**
     * @return The invited
     */
    public Boolean getInvited() {
        return invited;
    }

    /**
     * @param invited The invited
     */
    public void setInvited(Boolean invited) {
        this.invited = invited;
    }

    /**
     * @return The studentyear
     */
    public Integer getStudentyear() {
        return studentyear;
    }

    /**
     * @param studentyear The studentyear
     */
    public void setStudentyear(Integer studentyear) {
        this.studentyear = studentyear;
    }

    /**
     * @return The admin
     */
    public Boolean getAdmin() {
        return admin;
    }

    /**
     * @param admin The admin
     */
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    /**
     * @return The decoded
     */
    public Integer getDecoded() {
        return decoded;
    }

    /**
     * @param decoded The decoded
     */
    public void setDecoded(Integer decoded) {
        this.decoded = decoded;
    }

}
