package org.dev.mictim.oldbkorg.app;

import java.util.HashMap;
import java.util.Map;

public class AppConfig {
    // Server user login url
    public static String URL_LOGIN = "http://oldbk.org/api/index.php";

    // Server user register url
    public static String URL_REGISTER = "http://oldbk.org/register.php";

    //MyInfo
    public static final String URL_MYINFO = URL_LOGIN + "?act=myinfo&sid=";

    //MyInv
    public static final String URL_MYINV = URL_LOGIN + "?act=myinv&sid=";

    //MyInfo Response;
    public static String myInfoResponse = null;

    //Post Parameters to search
    public static String[] JSON_LOGIN_SUCCESS = {"sid"};
    public static String[] JSON_LOGIN_FAIL ={"error"};

    public static String[] JSON_PLAYER_INFO = {"login", "level","align","klan","sila","lovk","inta","vinos","money"};

    public static String sid;

    public static Map<String, String> responseMap = new HashMap<String,String>();
    public static String responseStr;

    //
    public static String[] align = {"нет","Светлая","Нейтральная","Темная"};

    //
    public static String response;

    //Config params from request
    //login request
    public static String[] actAuth = {"act", "auth"};
    public static String[] authLogin = {"login", null};
    public static String[] authPass = {"pass", null};

    //myInfo request
    public static String[] myInfoAct = {"act", "myinfo"};
    public static String[] myInfoSid = {"sid", null};

    //my Inv request
    public static String[] myInvAct = {"act", "myinv"};
    public static String[] myInvSid = {"sid", null};
}

