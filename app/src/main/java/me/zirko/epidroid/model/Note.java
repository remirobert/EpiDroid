package me.zirko.epidroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Note {

    @Expose
    private String title;
    @SerializedName("title_link")
    @Expose
    private String titleLink;
    @Expose
    private String note;
    @Expose
    private String noteur;

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
     * @return The note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note The note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return The noteur
     */
    public String getNoteur() {
        return noteur;
    }

    /**
     * @param noteur The noteur
     */
    public void setNoteur(String noteur) {
        this.noteur = noteur;
    }

}
