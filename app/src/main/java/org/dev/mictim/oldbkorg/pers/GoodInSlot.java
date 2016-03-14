package org.dev.mictim.oldbkorg.pers;

/**
 * Created by elena on 3/12/16.
 */
public class GoodInSlot {
    private String slot;
    private String id;

    public GoodInSlot(String slot, String id){
        this.slot = slot;
        this.id = id;
    }

    public GoodInSlot(){

    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
