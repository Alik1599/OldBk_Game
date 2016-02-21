package org.dev.mictim.oldbkorg.helper;


import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by elena on 2/5/16.
 */
public class JSONParser {


    public static Map<String, String> getValue(String strJson) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            JSONObject jsonObj = new JSONObject(strJson);
            Iterator<String> keys = jsonObj.keys();
            while (keys.hasNext()) {
                //based on you key types
                String key = (String)keys.next();
                String value = (String) jsonObj.get(key);
                map.put(key, value);
            }

//                for (int i = 0; i < params.length; i++){
            //Get the instance of JSONArray that contains JSONObjects



//            data += "Node"+i+" : \n id= "+ id +" \n Name= "+ name +" \n Salary= "+ salary +" \n ";
//            }
            //output.setText(data);
        } catch (JSONException e) {
            e.printStackTrace();
            map.put("error", "Exception");
            return map;
        }
        return map;
    }
}

