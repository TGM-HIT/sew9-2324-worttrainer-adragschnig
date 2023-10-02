package at.ac.tgm.adragaschnig.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class WortEintrag {
    private String wort;
    private String url;

    public WortEintrag(String wort, String url) {
        setWort(wort);
        setUrl(url);
    }

    public String getWort() {
        return wort;
    }

    public boolean setWort(String wort) {
        if(wort.length() > 1) {
            this.wort = wort;
            return true;
        }
        return false;
    }

    public String getUrl() {
        return url;
    }

    public boolean setUrl(String url) {
        String urlString = url;
        try {
            URL checkedUrl = new URL(urlString);
            this.url = checkedUrl.toString();
        } catch (MalformedURLException e) {
            System.out.println("Die URL ist ungültig: " + urlString);
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
