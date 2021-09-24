package com.example.weatherapp;

import org.json.JSONException;
import org.json.JSONObject;

public class weatherData {

    private String mTemperature, mIcon, mCity, mWeatherType;
    private int  mCondition;

    public static weatherData fromJson(JSONObject jsonObject){

        try {
            weatherData weatherD= new weatherData();
            weatherD.mCity=jsonObject.getString("name");
            weatherD.mCondition=jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.mWeatherType=jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            weatherD.mIcon=updateweatherIcon(weatherD.mCondition);
            double tempResult = jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedValue = (int)Math.rint(tempResult);
            weatherD.mTemperature = Integer.toString(roundedValue);
            return weatherD;


        }


        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


    private static String updateweatherIcon(int condition)
    {
        if(condition>=0 && condition<=300){
            return "thunderstorm";
        }
        else if(condition>=300 && condition<=500){
            return "lightrain";
        }
        else if(condition>=501 && condition<=600){
            return "shower";
        }
        else if(condition>=601 && condition<=700){
            return "cloudy";
        }
        else if(condition>=701 && condition<=771){
            return "overcast";
        }

        return "sunny";



    }

    public String getmTemperature() {
        return mTemperature+ "°C";
    }

    public String getmIcon() {
        return mIcon;
    }

    public String getmCity() {
        return mCity;
    }

    public String getmWeatherType() {
        return mWeatherType;
    }
}
