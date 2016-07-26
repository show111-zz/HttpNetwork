package com.show.series.httpnetwork.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihf on 16/7/26.
 */
public class EventItem {

    public String id;
    public String content;
    public static List<EventItem> ITEMS = new ArrayList<>();
    static {
        ITEMS.add(new EventItem("1","Item 1"));
        ITEMS.add(new EventItem("2","Item 2"));
        ITEMS.add(new EventItem("3","Item 3"));
        ITEMS.add(new EventItem("4","Item 4"));
        ITEMS.add(new EventItem("5","Item 5"));
        ITEMS.add(new EventItem("6","Item 6"));

    }


    private static void addItem(EventItem item){
        ITEMS.add(item);
    }

    public EventItem(String id,String content){
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
