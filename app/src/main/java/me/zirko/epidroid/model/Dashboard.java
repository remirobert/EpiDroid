package me.zirko.epidroid.model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Dashboard {

    @Expose
    private String ip;
    @Expose
    private Board board;
    @Expose
    private List<History> history = new ArrayList<History>();
    @Expose
    private Infos infos;
    @Expose
    private Current current;

    /**
     * @return The ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip The ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return The board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @param board The board
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * @return The history
     */
    public List<History> getHistory() {
        return history;
    }

    /**
     * @param history The history
     */
    public void setHistory(List<History> history) {
        this.history = history;
    }

    /**
     * @return The infos
     */
    public Infos getInfos() {
        return infos;
    }

    /**
     * @param infos The infos
     */
    public void setInfos(Infos infos) {
        this.infos = infos;
    }

    /**
     * @return The current
     */
    public Current getCurrent() {
        return current;
    }

    /**
     * @param current The current
     */
    public void setCurrent(Current current) {
        this.current = current;
    }

}
