package org.dev.mictim.oldbkorg.app;

/**
 * Created by mictim on 2/24/16.
 */
public class AppResponse {
    private static AppResponse mySession;
    private String response;

    private AppResponse() {
        response = null;
    }

    public static AppResponse getInstance() {
        if (mySession == null) {
            mySession = new AppResponse();
        }
        return mySession;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
