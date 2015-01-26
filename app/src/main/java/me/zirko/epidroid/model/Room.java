
package me.zirko.epidroid.model;

import com.google.gson.annotations.Expose;

public class Room {

    @Expose
    private String code;
    @Expose
    private Integer seats;
    @Expose
    private String type;

    /**
     * 
     * @return
     *     The code
     */
    public String getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 
     * @return
     *     The seats
     */
    public Integer getSeats() {
        return seats;
    }

    /**
     * 
     * @param seats
     *     The seats
     */
    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

}
