package com.ubosque.apicuatropatas.constant;

public class Constante {

    public static class ResponseCode{
        private ResponseCode(){}
        public static final String SUCCESS = "200";
        public static final String NOT_FOUND = "404";
        public static final String ERROR = "500";
    }

    public static class ResponseMesg{
        private ResponseMesg(){}
        public static final String SUCCESS = "Success";
        public static final String NOT_FOUND = "Not found";
        public static final String ERROR = "Error";
    }

    public static class Id{
        private Id(){}
        public static final String PET_ID = "MAS";
    }

    public static class DbInfo{
        private DbInfo(){}
        public static final String DB_SERVER = "localhost";
        public static final int DB_PORT = 27017;
        public static final String DB_NAME = "PPDBYBA";
        public static final String DB_COLLECTION = "microchips";
    }

    public static class RedisInfo{
        private RedisInfo(){}
        public static final String DB_SERVER = "localhost";
        public static final int DB_PORT = 6379;
        public static final int DB_EXPIRE_TIME = 3600;
    }

    public static class GeoInfo{
        private GeoInfo(){}
        public static final String FEATURE_TYPE = "Feature";
        public static final String GEOMETRY_TYPE = "Polygon";
        public static final String GEO_TYPE = "FeatureCollection";
    }
}
