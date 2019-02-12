package org.json;

public class Create {




    public static void main (String[]args){
        //1st top level-{}
        JSONObject jsonObject=new JSONObject();

        //person level-> top level may contain several person
        JSONArray personAarray=new JSONArray();

        //creating 1st person
        JSONObject personObject=new JSONObject();

        personObject.put("name", "John");
        personObject.put("age", 31);
        personObject.put("city", "New York");

        // array for cars of the person->this array is a string array
        JSONArray carsJsonArray=new JSONArray();
        carsJsonArray.put("ford");
        carsJsonArray.put("chevy");
        carsJsonArray.put("dodge");
        //put the array in person
        personObject.put("cars",carsJsonArray);

        // array for hobbies of the person->this array is an object array
        JSONArray hobbiesJsonArray=new JSONArray();
        for(int i=0;i<3;i++){
            JSONObject hobbyJsonObject=new JSONObject();
            switch (i) {
                case 0:
                    hobbyJsonObject.put("hobby", "running");
                    break;
                case 1:
                    hobbyJsonObject.put("hobby", "hiking");
                    break;
                case 2:
                    hobbyJsonObject.put("hobby", "biking");
                    break;
            }
            hobbiesJsonArray.put(hobbyJsonObject);
        }
        //put the array in person
        personObject.put("hobbies",hobbiesJsonArray);

        //put person in the person array
        personAarray.put(personObject);


        //creating 2nd person
        JSONObject personObject2=new JSONObject();

        personObject2.put("name", "Mike");
        personObject2.put("age", 28);
        personObject2.put("city", "Atlanta");

        // array for cars of the person->this array is a string array
        JSONArray carsJsonArray2=new JSONArray();
        carsJsonArray2.put("audi");
        carsJsonArray2.put("bmw");
        carsJsonArray2.put("porche");
        //put the array in person
        personObject2.put("cars",carsJsonArray2);

        // array for hobbies of the person->this array is an object array
        JSONArray hobbiesJsonArray2=new JSONArray();
        for(int i=0;i<3;i++){
            JSONObject hobbyJsonObject=new JSONObject();
            switch (i) {
                case 0:
                    hobbyJsonObject.put("hobby", "eating");
                    break;
                case 1:
                    hobbyJsonObject.put("hobby", "drinking");
                    break;
                case 2:
                    hobbyJsonObject.put("hobby", "sleeping");
                    break;
            }
            hobbiesJsonArray2.put(hobbyJsonObject);
        }
        //put the array in person
        personObject2.put("hobbies",hobbiesJsonArray2);

        //put person in the person array
        personAarray.put(personObject2);

        //put person array in top level
        jsonObject.put("person", personAarray);

        System.out.println(jsonObject.toString());
    }
}
