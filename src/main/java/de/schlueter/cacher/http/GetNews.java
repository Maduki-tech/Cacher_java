package de.schlueter.cacher.http;

import de.schlueter.cacher.Config;
import de.schlueter.cacher.cache.CacheImpl;
import de.schlueter.cacher.utils.HTTPRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GetNews {
    CacheImpl cache = new CacheImpl();
    private static final String index = "news";

    @GetMapping("/news")
    public String getNews() {
        long start = System.currentTimeMillis();
        String url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=" + Config.GetAPIKey();
        if (cache.get(index) != null) {
            log.info("Cache hit");
            log.info("Time: " + (System.currentTimeMillis() - start) + "ms");
            return cache.get(index);
        } else {
            String response = HTTPRequest.requestToNewsAPI(url);
            log.info("Cache miss");
            log.info("Time: " + (System.currentTimeMillis() - start) + "ms");
            cache.put(index, response);
            return response;
        }
    }

    @GetMapping("/clearCache")
    public void clearCache() {
        cache.remove(index);
    }
}
