package com.example.clashroyale;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;


public class CardsAPI extends SecondFragment{

    public ArrayList<Cards> getCards(){

        String apiurl = "https://rllqifusycyuiflbbkcb.supabase.co/rest/v1/Cards?apikey=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InJsbHFpZnVzeWN5dWlmbGJia2NiIiwicm9sZSI6ImFub24iLCJpYXQiOjE2NjY2OTQ4MTMsImV4cCI6MTk4MjI3MDgxM30.W54iCzRe16iysbQXt3EtmJOYcFmPaYr_M6QpJxUvvjY";

    try {
        String mostrar = HttpUtils.get(apiurl);
        JSONArray jsonResult = new JSONArray(mostrar);
        ArrayList<Cards> arrayCards = new ArrayList<>();


       for(int i = 0; i < jsonResult.length(); i++){

            JSONObject cardJson = jsonResult.getJSONObject(i);
            Cards card = new Cards();

            card.setDamage(cardJson.getInt("Damage"));
            card.setName(cardJson.getString("Name"));
            card.setHp(cardJson.getInt("Hp"));
            card.setSpeed(cardJson.getString("Speed"));
            card.setImg(cardJson.getString("Img"));
            card.setImgD(cardJson.getString("ImgE"));
            card.setData(cardJson.getString("Datos"));
            arrayCards.add(card);
        }

      /* if(ordenar().equals("hp")){
           Collections.sort(arrayCards);
       }*/
        return arrayCards;

    }catch(IOException e) {
        e.printStackTrace();
    } catch (JSONException e) {
        e.printStackTrace();
    }
        return null;
    }
}
