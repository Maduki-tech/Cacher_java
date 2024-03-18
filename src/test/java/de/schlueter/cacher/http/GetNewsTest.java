package de.schlueter.cacher.http;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class GetNewsTest {

    @Test
    void getNews() {
        GetNews getNews = new GetNews();
        String news = getNews.getNews();
        log.info("News: {}", news);

        assertNotNull(news);
    }
}