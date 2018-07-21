package com.smona.app.guaika.main.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TabData implements Serializable {
    private int type;
    private int tabId;
    private String tabName;

    public TabData(int tabId, String tabName, int type) {
        this.tabId = tabId;
        this.tabName = tabName;
        this.type = type;
    }

    public static List<TabData> createTabDatas() {
        List<TabData> tabs = new ArrayList<TabData>();
        TabData tabData = new TabData(20, "首页", 20);
        tabs.add(tabData);
        tabData = new TabData(26, "分类", 26);
        tabs.add(tabData);
        return tabs;
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
