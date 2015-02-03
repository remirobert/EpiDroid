package me.zirko.epidroid.event;

import me.zirko.epidroid.model.Dashboard;

public class DashboardEvent {
    private final Dashboard mData;
    private String mToken;

    public DashboardEvent(String token, Dashboard dashboard) {
        mToken = token;
        mData = dashboard;
    }

    public Dashboard getData() {
        return mData;
    }

    public String getToken() {
        return mToken;
    }
}
