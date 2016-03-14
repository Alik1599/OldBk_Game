package org.dev.mictim.oldbkorg.helper;

import org.dev.mictim.oldbkorg.pers.Goods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by elena on 3/11/16.
 */
public class Helper {

    public static void waitingMethod (Object value, int delay){
        for (int i = 0 ; i < delay; i++){
            if (value != null){
                break;
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<Goods> getGoods(String response){
        List<Goods> goods = new ArrayList<>();
        String[] tempStr = response.split("\\}");
        for (String temp : tempStr) {
            temp = temp.substring(0,temp.length()-1) + "}";
            Map<String, String> map = JSONParser.getValue(temp);
            Goods good = new Goods(map);
            goods.add(good.getValuesFromMap());
        }

        return goods;

    }

    public static List<Goods> dressedGoods (List<Goods> goods){
        List<Goods> newGoods = new ArrayList<>();
        for (Goods good: goods) {
            if(good.getDressed().equals("1")){
                newGoods.add(good);
            }
        }
        return newGoods;
    }
}
