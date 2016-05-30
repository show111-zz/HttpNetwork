package com.show.series.httpnetwork.model;

import java.util.List;

/**
 * Created by lihf on 16/5/30.
 */
public class LoadMoreModel {


    /**
     * status : 1
     * markid : 49b2c5f7682001799817ed987024b31e
     */

    public HeaderBean header;
    /**
     * status : 1
     * list : [{"id":"FqYvlUw6Im30=","nickName":"晓晓cfg","headPath":{"Winit":"http://123.206.27.51/upload/34/2/18/init_340218.jpg?t=5102611271357178","W180":"http://123.206.27.51/upload/34/2/18/180_340218.jpg?t=1142910286596197"},"userCount":"0","amount":"200.00","payTotal":"0","gap":"0","ratio":"0"},{"id":"DQtm23vIOm1LI=","nickName":"晓晓cfg","headPath":{"Winit":"http://123.206.27.51/upload/34/2/18/init_340218.jpg?t=5102611271357178","W180":"http://123.206.27.51/upload/34/2/18/180_340218.jpg?t=1142910286596197"},"userCount":"0","amount":"100.00","payTotal":"0","gap":"0","ratio":"0"},{"id":"NS5pKlDO3aA=","nickName":"晓晓cfg","headPath":{"Winit":"http://123.206.27.51/upload/34/2/18/init_340218.jpg?t=5102611271357178","W180":"http://123.206.27.51/upload/34/2/18/180_340218.jpg?t=1142910286596197"},"userCount":"0","amount":"200.00","payTotal":"0","gap":"0","ratio":"0"},{"id":"PMxv6PDlwBE=","nickName":"晓晓cfg","headPath":{"Winit":"http://123.206.27.51/upload/34/2/18/init_340218.jpg?t=5102611271357178","W180":"http://123.206.27.51/upload/34/2/18/180_340218.jpg?t=1142910286596197"},"userCount":"0","amount":"300.00","payTotal":"0","gap":"0","ratio":"0"},{"id":"wqfVZej00Sc=","nickName":"晓晓cfg","headPath":{"Winit":"http://123.206.27.51/upload/34/2/18/init_340218.jpg?t=5102611271357178","W180":"http://123.206.27.51/upload/34/2/18/180_340218.jpg?t=1142910286596197"},"userCount":"0","amount":"500.00","payTotal":"0","gap":"0","ratio":"0"},{"id":"Q90QW53uV6M=","nickName":"晓晓cfg","headPath":{"Winit":"http://123.206.27.51/upload/34/2/18/init_340218.jpg?t=5102611271357178","W180":"http://123.206.27.51/upload/34/2/18/180_340218.jpg?t=1142910286596197"},"userCount":"0","amount":"100.00","payTotal":"0","gap":"0","ratio":"0"},{"id":"ltJvsh9r3Kk=","nickName":"晓晓cfg","headPath":{"Winit":"http://123.206.27.51/upload/34/2/18/init_340218.jpg?t=5102611271357178","W180":"http://123.206.27.51/upload/34/2/18/180_340218.jpg?t=1142910286596197"},"userCount":"0","amount":"0.00","payTotal":"0","gap":"0","ratio":""},{"id":"d2kRFfBT21Q=","nickName":"晓晓cfg","headPath":{"Winit":"http://123.206.27.51/upload/34/2/18/init_340218.jpg?t=5102611271357178","W180":"http://123.206.27.51/upload/34/2/18/180_340218.jpg?t=1142910286596197"},"userCount":"0","amount":"0.00","payTotal":"0","gap":"0","ratio":""},{"id":"b7Tcktm2yCDA=","nickName":"晓晓cfg","headPath":{"Winit":"http://123.206.27.51/upload/34/2/18/init_340218.jpg?t=5102611271357178","W180":"http://123.206.27.51/upload/34/2/18/180_340218.jpg?t=1142910286596197"},"userCount":"0","amount":"0.00","payTotal":"0","gap":"0","ratio":""},{"id":"w3JaEF44J2E=","nickName":"晓晓cfg","headPath":{"Winit":"http://123.206.27.51/upload/34/2/18/init_340218.jpg?t=5102611271357178","W180":"http://123.206.27.51/upload/34/2/18/180_340218.jpg?t=1142910286596197"},"userCount":"0","amount":"0.00","payTotal":"0","gap":"0","ratio":""}]
     */

    public BodyBean body;


    public static class HeaderBean {
        public String status;
        public String markid;

    }

    public static class BodyBean {
        public String status;
        /**
         * id : FqYvlUw6Im30=
         * nickName : 晓晓cfg
         * headPath : {"Winit":"http://123.206.27.51/upload/34/2/18/init_340218.jpg?t=5102611271357178","W180":"http://123.206.27.51/upload/34/2/18/180_340218.jpg?t=1142910286596197"}
         * userCount : 0
         * amount : 200.00
         * payTotal : 0
         * gap : 0
         * ratio : 0
         */

        public List<ListBean> list;
        

        public static class ListBean {
            public String id;
            public String nickName;
            /**
             * Winit : http://123.206.27.51/upload/34/2/18/init_340218.jpg?t=5102611271357178
             * W180 : http://123.206.27.51/upload/34/2/18/180_340218.jpg?t=1142910286596197
             */

            public HeadPathBean headPath;
            public String userCount;
            public String amount;
            public String payTotal;
            public String gap;
            public String ratio;
            

            public static class HeadPathBean {
                public String Winit;
                public String W180;
            }
        }
    }
}
