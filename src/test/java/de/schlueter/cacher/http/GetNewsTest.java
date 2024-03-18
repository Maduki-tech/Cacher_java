package de.schlueter.cacher.http;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class GetNewsTest {
    @Test
    void getNews() {
        GetNews getNews = new GetNews();
        String news = getNews.getNews();
        assertNotNull(news);
    }

}
