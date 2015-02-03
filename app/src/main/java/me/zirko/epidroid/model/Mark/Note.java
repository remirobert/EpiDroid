package me.zirko.epidroid.model.Mark;

import java.util.HashMap;
import java.util.Map;

public class Note {
    private Integer scolaryear;
    private String codemodule;
    private String titlemodule;
    private String codeinstance;
    private String codeacti;
    private String title;
    private String date;
    private String correcteur;
    private Double finalNote;
    private String comment;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The scolaryear
     */
    public Integer getScolaryear() {
        return scolaryear;
    }

    /**
     *
     * @param scolaryear
     * The scolaryear
     */
    public void setScolaryear(Integer scolaryear) {
        this.scolaryear = scolaryear;
    }

    /**
     *
     * @return
     * The codemodule
     */
    public String getCodemodule() {
        return codemodule;
    }

    /**
     *
     * @param codemodule
     * The codemodule
     */
    public void setCodemodule(String codemodule) {
        this.codemodule = codemodule;
    }

    /**
     *
     * @return
     * The titlemodule
     */
    public String getTitlemodule() {
        return titlemodule;
    }

    /**
     *
     * @param titlemodule
     * The titlemodule
     */
    public void setTitlemodule(String titlemodule) {
        this.titlemodule = titlemodule;
    }

    /**
     *
     * @return
     * The codeinstance
     */
    public String getCodeinstance() {
        return codeinstance;
    }

    /**
     *
     * @param codeinstance
     * The codeinstance
     */
    public void setCodeinstance(String codeinstance) {
        this.codeinstance = codeinstance;
    }

    /**
     *
     * @return
     * The codeacti
     */
    public String getCodeacti() {
        return codeacti;
    }

    /**
     *
     * @param codeacti
     * The codeacti
     */
    public void setCodeacti(String codeacti) {
        this.codeacti = codeacti;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     * The correcteur
     */
    public String getCorrecteur() {
        return correcteur;
    }

    /**
     *
     * @param correcteur
     * The correcteur
     */
    public void setCorrecteur(String correcteur) {
        this.correcteur = correcteur;
    }

    /**
     *
     * @return
     * The finalNote
     */
    public Double getFinalNote() {
        return finalNote;
    }

    /**
     *
     * @param finalNote
     * The final_note
     */
    public void setFinalNote(Double finalNote) {
        this.finalNote = finalNote;
    }

    /**
     *
     * @return
     * The comment
     */
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment
     * The comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
