package me.zirko.epidroid.model.Mark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Notes {

    private List<Note> notes = new ArrayList<Note>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The notes
     */
    public List<Note> getNotes() {
        return notes;
    }

    /**
     *
     * @param notes
     * The notes
     */
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
