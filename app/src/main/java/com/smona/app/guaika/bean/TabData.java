package com.smona.app.guaika.bean;

public class TabData {
    private int type;
    private int tabId;
    private String tabName;

    public TabData(int tabId, String tabName, int type) {
        this.tabId = tabId;
        this.tabName = tabName;
        this.type = type;
    }

    public int getTabId() {
        return tabId;
    }

    public String getTabName() {
        return tabName;
    }

    public int getType() {
        return type;
    }
}
