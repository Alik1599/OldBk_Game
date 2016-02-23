package org.dev.mictim.oldbkorg.app;

/**
 * Created by mictim on 2/21/16.
 */
public class AppInv {
    private String id;
    private String name;
    private String cost;
    private String duration;
    private String maxdur;
    private String img;
    private String dressed;
    private static AppInv mySession;

    private AppInv(){
        id = null;
        name = null;
        cost = null;
        duration = null;
        maxdur = null;
        img = null;
        dressed = null;

    }

    public static AppInv getInstance(){
        if (mySession == null) {
            mySession = new AppInv();
        }
        return mySession;
    }

    public void resetSession() {
        mySession=null;
    }

    public String getMaxdur() {
        return maxdur;
    }

    public void setMaxdur(String maxdur) {
        this.maxdur = maxdur;
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

    public String getImg() {
        return "http://oldbk.org/i/sh/" + img;
    }

    public void setImg(String img) {
        this.img = "http://oldbk.org/i/sh/" + img;
    }

    public String getDressed() {
        return dressed;
    }

    public void setDressed(String dressed) {
        this.dressed = dressed;
    }
}
