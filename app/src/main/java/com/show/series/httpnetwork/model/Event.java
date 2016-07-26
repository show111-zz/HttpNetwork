package com.show.series.httpnetwork.model;


import java.util.List;

/**
 * Created by lihf on 16/7/26.
 */
public class Event {

    public static class ItemListEvent{
        private List<EventItem> itemList;

        public ItemListEvent(List<EventItem> itemList){
            this.itemList = itemList;
        }

        public List<EventItem> getItems(){
            return itemList;
        }

    }

}
