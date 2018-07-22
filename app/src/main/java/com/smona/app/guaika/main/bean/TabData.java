package com.smona.app.guaika.main.bean;

import com.smona.app.guaika.main.http.DataType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TabData implements Serializable {
    private DataType dataType;
    private int tabId;
    private String tabName;

    public TabData(int tabId, String tabName, DataType type) {
        this.tabId = tabId;
        this.tabName = tabName;
        this.dataType = type;
    }

    public static List<TabData> createTabDatas() {
        List<TabData> tabs = new ArrayList<TabData>();
        TabData tabData = new TabData(26, "首页", DataType.HOME);
        tabs.add(tabData);
        tabData = new TabData(2, "分类", DataType.CATEGORY);
        tabs.add(tabData);
        return tabs;
    }

    public int getTabId() {
        return tabId;
    }

    public String getTabName() {
        return tabName;
    }

    public DataType getType(){
        return dataType;
    }
}
