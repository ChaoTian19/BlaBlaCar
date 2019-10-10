package com.jrteamtech.clonebla.utility;

public class Global {


    Global(){}

    static  String result_time="";
    static String selected_time;


    public static String getSelected_time() {
        return selected_time;
    }

    public static String setSelected_time(String selected_time) {
        Global.selected_time = selected_time;

        if(result_time.length() >= 0 && result_time.length() < 16){
            result_time = result_time  + Global.selected_time;

        }else {

            result_time ="";
            result_time = result_time  + Global.selected_time;
        }
        return result_time;

    }
}


//solution