package org.json;

import java.util.ArrayList;

public class Parse {





    public static void main(String [] args){
        //----------------case 1 --------------------
        String jsonStr1="{name: \"John\", age: 31, city: \"New York\"}";
        //System.out.println(jsonStr1);
        //convertJsonStringToJsonObject(jsonStr1);

        //----------------case 2 --------------------
        //String jsonStr2="{\"name\": \"John\", \"age\": 31, \"city\": \"New York\", \"cars\":[ \"Ford\", \"BMW\", \"Fiat\" ]}";
        //System.out.println(jsonStr2);
        //parseJsonStringWithStringArray(jsonStr2);

        //----------------case 3 --------------------
        //String jsonStr3="{\"name\": \"John\", \"age\": 31, \"city\": \"New York\", \"cars\":[ \"Ford\", \"BMW\", \"Fiat\" ],\"hobbies\":[{\"hobby\": \"eating\"},{\"hobby\": \"sleeping\"},{\"hobby\": \"drinking\"}]}";
        //System.out.println(jsonStr3);
        //parseJsonStringWithObjectArray(jsonStr3);

        //----------------case 4 --------------------
        String jsonStr4="{  \n" +
                "   \"person\":[  \n" +
                "      {  \n" +
                "         \"name\":\"John\",\n" +
                "         \"age\":31,\n" +
                "         \"city\":\"New York\",\n" +
                "         \"cars\":[  \n" +
                "            \"Ford\",\n" +
                "            \"BMW\",\n" +
                "            \"Fiat\"\n" +
                "         ],\n" +
                "         \"hobbies\":[  \n" +
                "            {  \n" +
                "               \"hobby\":\"running\"\n" +
                "            },\n" +
                "            {  \n" +
                "               \"hobby\":\"hiking\"\n" +
                "            },\n" +
                "            {  \n" +
                "               \"hobby\":\"biking\"\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "      {  \n" +
                "         \"name\":\"Mike\",\n" +
                "         \"age\":28,\n" +
                "         \"city\":\"Atlanta\",\n" +
                "         \"cars\":[  \n" +
                "            \"Audi\",\n" +
                "            \"Benz\",\n" +
                "            \"Porche\"\n" +
                "         ],\n" +
                "         \"hobbies\":[  \n" +
                "            {  \n" +
                "               \"hobby\":\"drinking\"\n" +
                "            },\n" +
                "            {  \n" +
                "               \"hobby\":\"eating\"\n" +
                "            },\n" +
                "            {  \n" +
                "               \"hobby\":\"sleeping\"\n" +
                "            }\n" +
                "         ]\n" +
                "      }\n" +
                "   ]\n" +
                "}";
        System.out.println(jsonStr4);
        parseJsonStringWithCompliated(jsonStr4);
    }


    public static void convertJsonStringToJsonObject(String jsonStr){
        //convert json string to json object
        JSONObject jsonObject = new JSONObject(jsonStr);
        String name=(String)jsonObject.get("name");
        int age=(Integer)jsonObject.get("age");
        String city=(String)jsonObject.get("city");
        System.out.println(name);
        System.out.println(age);
        System.out.println(city);
    }

    public static void parseJsonStringWithStringArray(String jsonStr){
        JSONObject jsonObject = new JSONObject(jsonStr);
        String name=(String)jsonObject.get("name");
        int age=(Integer)jsonObject.get("age");
        String city=(String)jsonObject.get("city");
        //you cannot do String cars=(String)jsonObject.get("cars"); because cars is not a String it is an array
        //Exception in thread "main" java.lang.ClassCastException: org.json.JSONArray cannot be cast to java.lang.String
        //instead, you have to convert it to json array
        JSONArray carsJsonArray=jsonObject.getJSONArray("cars");

        //you can convert the whole string array to a string
        String carsArray=carsJsonArray.toString();

        System.out.println(name);
        System.out.println(age);
        System.out.println(city);
        System.out.println(carsArray);

        //or you can get and convert each element in the JsonArray to a string one by one
        for(int i=0;i<carsJsonArray.length();i++){

            String car=(String)carsJsonArray.get(i);
            System.out.println(car);
        }



    }


    public static void parseJsonStringWithObjectArray(String jsonStr){
        JSONObject jsonObject = new JSONObject(jsonStr);
        String name=(String)jsonObject.get("name");
        int age=(Integer)jsonObject.get("age");
        String city=(String)jsonObject.get("city");
        //you cannot do String cars=(String)jsonObject.get("cars"); because cars is not a String it is an array
        //Exception in thread "main" java.lang.ClassCastException: org.json.JSONArray cannot be cast to java.lang.String
        //instead, you have to convert it to json array
        JSONArray carsJsonArray=jsonObject.getJSONArray("cars");

        //you can convert the whole string array to a string
        String carsArray=carsJsonArray.toString();

        System.out.println(name);
        System.out.println(age);
        System.out.println(city);
        System.out.println(carsArray);

        //or you can get and convert each element in the JsonArray to a string one by one
        for(int i=0;i<carsJsonArray.length();i++){

            String car=(String)carsJsonArray.get(i);
            System.out.println(car);
        }

        JSONArray hobbiesAJsonArray=jsonObject.getJSONArray("hobbies");
        for(int i=0;i< hobbiesAJsonArray.length();i++){
            JSONObject hobbyObject=hobbiesAJsonArray.getJSONObject(i);
            String hobby=(String)hobbyObject.get("hobby");
            System.out.println(hobby);

        }

    }

    public static void parseJsonStringWithCompliated(String jsonStr){
        System.out.println("----------------------------------");

        JSONObject jsonObject = new JSONObject(jsonStr);//this is everything
        JSONArray personArray=jsonObject.getJSONArray("person");
        for(int i=0;i< personArray.length();i++){
            JSONObject personObject=personArray.getJSONObject(i);//this is element of everything
            //String personString=personObject.toString();
            String name=(String)personObject.get("name");
            int age=(Integer)personObject.get("age");
            String city=(String)personObject.get("city");
            JSONArray carsJsonArray=personObject.getJSONArray("cars");

            System.out.println(name);
            System.out.println(age);
            System.out.println(city);
            System.out.println(carsJsonArray.toString());

            JSONArray hobbiesAJsonArray=personObject.getJSONArray("hobbies");
            for(int j=0;j< hobbiesAJsonArray.length();j++){
                JSONObject hobbyObject=hobbiesAJsonArray.getJSONObject(j);
                String hobby=(String)hobbyObject.get("hobby");
                System.out.println(hobby);

            }

            System.out.println("----------------------------------");
        }


    }
}