package com.show.series.httpnetwork.model;

/**
 * Created by cici on 16/3/13.
 */
public class MsgModel {

    /**
     * id : 16576
     * message : {"logo":"http://dev.warmler.com//mobile/static/logo.png","name":"路人甲","text":"您有优惠券已过期","isPic":"0","type":"2","click":{"id":"20","text":"立即查看","params":{"itemIdStr":"23,22,21,20,19,17,16,15,14,13,11,10,9,30,41,57,12,58,48,42,33,24,55,54,39,61,53,52,36,35,63,38,60,43,40,34,64,65,59,75,78,70,56,72,73,74,71,67,37,62,79,66,76,80,81,83,44,87,89,90,77,93,92,88,94,95,96,98,100,102,103,101,107,82,111,99,112,113"}}}
     * isShow : 0
     * postion : 0
     * addtime : 2016-03-13 14:00:04
     */

    public java.util.List<Item> list;

    public static class Item {
        public String id;
        /**
         * logo : http://dev.warmler.com//mobile/static/logo.png
         * name : 路人甲
         * text : 您有优惠券已过期
         * isPic : 0
         * type : 2
         * click : {"id":"20","text":"立即查看","params":{"itemIdStr":"23,22,21,20,19,17,16,15,14,13,11,10,9,30,41,57,12,58,48,42,33,24,55,54,39,61,53,52,36,35,63,38,60,43,40,34,64,65,59,75,78,70,56,72,73,74,71,67,37,62,79,66,76,80,81,83,44,87,89,90,77,93,92,88,94,95,96,98,100,102,103,101,107,82,111,99,112,113"}}
         */

        public Message message;
        public String isShow;
        public String postion;
        public String addtime;

        public static class Message {
            public String logo;
            public String name;
            public String text;
            public String isPic;
            public String type;
            public String pic;
            /**
             * id : 20
             * text : 立即查看
             * params : {"itemIdStr":"23,22,21,20,19,17,16,15,14,13,11,10,9,30,41,57,12,58,48,42,33,24,55,54,39,61,53,52,36,35,63,38,60,43,40,34,64,65,59,75,78,70,56,72,73,74,71,67,37,62,79,66,76,80,81,83,44,87,89,90,77,93,92,88,94,95,96,98,100,102,103,101,107,82,111,99,112,113"}
             */

            public Click click;
            public PicParams picParams;

            public static class PicParams{
                public int width;
                public int height;
            }

            public static class Click {
                public int id;
                public String text;
                /**
                 * itemIdStr : 23,22,21,20,19,17,16,15,14,13,11,10,9,30,41,57,12,58,48,42,33,24,55,54,39,61,53,52,36,35,63,38,60,43,40,34,64,65,59,75,78,70,56,72,73,74,71,67,37,62,79,66,76,80,81,83,44,87,89,90,77,93,92,88,94,95,96,98,100,102,103,101,107,82,111,99,112,113
                 */

                public Params params;

                public static class Params {
                    public String orderid;
                    public String pid;
                    public String togetherId;
                    public String recordId;
                    public String activityId;
                    public String localeId;
                    public String eventid;
                    public String plcace;
                    public String itemIdStr;
                    public String jumptype;
                    public String jumpto;
                    public String jumpcate;
                }
            }
        }
    }
}
