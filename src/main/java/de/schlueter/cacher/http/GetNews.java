package de.schlueter.cacher.http;

import de.schlueter.cacher.Config;
import de.schlueter.cacher.utils.HTTPRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetNews {

    @GetMapping("/news")
    public String getNews() {
        String url = "https://newsapi.org/v2/top-headlines?country=us&apiKey="
                + Config.GetAPIKey();
        return HTTPRequest.requestToNewsAPI(url);
    }

}
