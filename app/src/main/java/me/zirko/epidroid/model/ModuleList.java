
package me.zirko.epidroid.model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class ModuleList {

    @Expose
    private List<ListModuleItem> modules = new ArrayList<ListModuleItem>();

    /**
     * 
     * @return
     *     The modules
     */
    public List<ListModuleItem> getModules() {
        return modules;
    }

    /**
     * 
     * @param modules
     *     The modules
     */
    public void setModules(List<ListModuleItem> modules) {
        this.modules = modules;
    }

}
