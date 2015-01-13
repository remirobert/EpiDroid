package me.zirko.epidroid.model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Board {

    @Expose
    private List<Projet> projets = new ArrayList<Projet>();
    @Expose
    private List<Note> notes = new ArrayList<Note>();
    @Expose
    private List<Susy> susies = new ArrayList<Susy>();
    @Expose
    private List<Activite> activites = new ArrayList<Activite>();
    @Expose
    private List<Module> modules = new ArrayList<Module>();
    @Expose
    private List<Stage> stages = new ArrayList<Stage>();
    @Expose
    private List<Object> tickets = new ArrayList<Object>();

    /**
     * @return The projets
     */
    public List<Projet> getProjets() {
        return projets;
    }

    /**
     * @param projets The projets
     */
    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

    /**
     * @return The notes
     */
    public List<Note> getNotes() {
        return notes;
    }

    /**
     * @param notes The notes
     */
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    /**
     * @return The susies
     */
    public List<Susy> getSusies() {
        return susies;
    }

    /**
     * @param susies The susies
     */
    public void setSusies(List<Susy> susies) {
        this.susies = susies;
    }

    /**
     * @return The activites
     */
    public List<Activite> getActivites() {
        return activites;
    }

    /**
     * @param activites The activites
     */
    public void setActivites(List<Activite> activites) {
        this.activites = activites;
    }

    /**
     * @return The modules
     */
    public List<Module> getModules() {
        return modules;
    }

    /**
     * @param modules The modules
     */
    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    /**
     * @return The stages
     */
    public List<Stage> getStages() {
        return stages;
    }

    /**
     * @param stages The stages
     */
    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }

    /**
     * @return The tickets
     */
    public List<Object> getTickets() {
        return tickets;
    }

    /**
     * @param tickets The tickets
     */
    public void setTickets(List<Object> tickets) {
        this.tickets = tickets;
    }

}
