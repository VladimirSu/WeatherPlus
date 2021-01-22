package com.example.weatherplus.bean;

import java.util.List;

public class analysisJson {


    private List<HeWeather6DTO> HeWeather6;

    public static class HeWeather6DTO {
        /**
         * basic : {"cid":"CN101280601","location":"深圳","parent_city":"深圳","admin_area":"广东","cnty":"中国","lat":"22.54700089","lon":"114.08594513","tz":"+8.00"}
         * update : {"loc":"2020-04-01 15:45","utc":"2020-04-01 07:45"}
         * status : ok
         * now : {"cloud":"100","cond_code":"104","cond_txt":"阴","fl":"18","hum":"82","pcpn":"0.0","pres":"1006","tmp":"18","vis":"16","wind_deg":"79","wind_dir":"东北风","wind_sc":"2","wind_spd":"9"}
         */


        private HeWeather6DTO.BasicDTO basic;

        private HeWeather6DTO.UpdateDTO update;

        private String status;

        private HeWeather6DTO.NowDTO now;

        public static class BasicDTO {
            /**
             * cid : CN101280601
             * location : 深圳
             * parent_city : 深圳
             * admin_area : 广东
             * cnty : 中国
             * lat : 22.54700089
             * lon : 114.08594513
             * tz : +8.00
             */


            private String cid;

            private String location;

            private String parentCity;

            private String adminArea;

            private String cnty;

            private String lat;

            private String lon;

            public String getCid() {
                return cid;
            }

            public String getLocation() {
                return location;
            }

            public String getParentCity() {
                return parentCity;
            }

            public String getAdminArea() {
                return adminArea;
            }

            public String getCnty() {
                return cnty;
            }

            public String getLat() {
                return lat;
            }

            public String getLon() {
                return lon;
            }

            public String getTz() {
                return tz;
            }

            private String tz;
        }


        public static class UpdateDTO {
            /**
             * loc : 2020-04-01 15:45
             * utc : 2020-04-01 07:45
             */


            private String loc;

            private String utc;

            public String getLoc() {
                return loc;
            }

            public String getUtc() {
                return utc;
            }
        }


        public static class NowDTO {
            /**
             * cloud : 100
             * cond_code : 104
             * cond_txt : 阴
             * fl : 18
             * hum : 82
             * pcpn : 0.0
             * pres : 1006
             * tmp : 18
             * vis : 16
             * wind_deg : 79
             * wind_dir : 东北风
             * wind_sc : 2
             * wind_spd : 9
             */


            private String cloud;

            private String condCode;

            private String condTxt;

            private String fl;

            private String hum;

            private String pcpn;

            private String pres;

            private String tmp;

            private String vis;

            private String windDeg;

            private String windDir;

            private String windSc;

            public String getCloud() {
                return cloud;
            }

            public String getCondCode() {
                return condCode;
            }

            public String getCondTxt() {
                return condTxt;
            }

            public String getFl() {
                return fl;
            }

            public String getHum() {
                return hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public String getPres() {
                return pres;
            }

            public String getTmp() {
                return tmp;
            }

            public String getVis() {
                return vis;
            }

            public String getWindDeg() {
                return windDeg;
            }

            public String getWindDir() {
                return windDir;
            }

            public String getWindSc() {
                return windSc;
            }

            public String getWindSpd() {
                return windSpd;
            }

            private String windSpd;
        }
    }
}
