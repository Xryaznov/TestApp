package main.java.test.app;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpChecker
{
    public static int check(String site)
    {
        int code = 0;

        try {
            URL url = new URL(site);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            code = connection.getResponseCode();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return code;
    }

    public static void main(String[] args)
    {
        System.out.println(HttpChecker.check("http://speedtest.net"));
    }
}
