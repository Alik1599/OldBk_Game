package org.dev.mictim.oldbkorg.app;

import java.util.HashMap;
import java.util.Map;

public class AppConfig {
    // Server user login url
    public static String URL_LOGIN = "http://oldbk.org/api/index.php";

    // Server user register url
    public static String URL_REGISTER = "http://oldbk.org/register.php";

    //Post Parameters to search
    public static String[] JSON_LOGIN_SUCCESS = {"sid"};
    public static String[] JSON_LOGIN_FAIL ={"error"};

    public static String[] JSON_PLAYER_INFO = {"login", "level","align","klan","sila","lovk","inta","vinos","money"};

    public static String sid;

    public static Map<String, String> responseMap = new HashMap<String,String>();
    public static String responseStr;

    //
    public static String[] align = {"нет","Светлая","Нейтральная","Темная"};
}

