package org.dev.mictim.oldbkorg.pers;

import android.util.Log;

import org.dev.mictim.oldbkorg.helper.JSONParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by elena on 3/5/16.
 */
public class Goods {
    private String id;
    private String name;
    private String cost;
    private String duration;
    private String maxdur;
    private String img;
    private String dressed;
    private Map<String, String> map;

    public Goods(String id,
                 String name,
                 String cost,
                 String duration,
                 String maxdur,
                 String img,
                 String dressed){
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.duration = duration;
        this.maxdur = maxdur;
        this.img = img;
        this.dressed = dressed;
    }

    public Goods (Map map){
        this.map = map;
    }

    public Goods getValuesFromMap(){
        if(map.size() > 0){
            this.setId(map.get("id"));
            this.setName(map.get("name"));
            this.setCost(map.get("cost"));
            this.setDuration(map.get("duration"));
            this.setMaxdur(map.get("maxdur"));
            this.setImg("http://oldbk.org/i/sh/" + (String) map.get("img"));
            Log.d("IMG: ", "http://oldbk.org/i/sh/" + (String) map.get("img"));
            this.setDressed(map.get("dressed"));
        } else {
            Log.e("Goods: ", "ERROR");

        }
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getMaxdur() {
        return maxdur;
    }

    public void setMaxdur(String maxdur) {
        this.maxdur = maxdur;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDressed() {
        return dressed;
    }

    public void setDressed(String dressed) {
        this.dressed = dressed;
    }


}
