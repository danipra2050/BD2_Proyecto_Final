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
}
