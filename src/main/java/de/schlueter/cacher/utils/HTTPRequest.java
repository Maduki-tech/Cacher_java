package de.schlueter.cacher.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HTTPRequest {
    /**
     * Requesting the news api and returning the response
     *
     * @return response from the news api
     */
    public static String requestToNewsAPI(String url) {
        // start performance monitoring
        StringBuilder response = new StringBuilder();
        try {
            URL urlObj = new URL(url);
            HttpURLConnection con = (HttpURLConnection)urlObj.openConnection();
            con.setRequestMethod("GET");

            con.connect();

            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Reading response from input Stream
                byte[] buffer = new byte[1024];
                int bytesRead = -1;
                while ((bytesRead = con.getInputStream().read(buffer)) != -1) {
                    response.append(new String(buffer, 0, bytesRead));
                }
            } else {
                System.out.println("Error: " + responseCode);
            }
        } catch (IOException e) {
            log.error("Error while requesting the news api: " + e.getMessage());
        }

        return response.toString();
    }
}
