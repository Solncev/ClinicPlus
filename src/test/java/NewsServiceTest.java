import com.solncev.model.News;
import com.solncev.repository.NewsRepository;
import com.solncev.service.NewsService;
import com.solncev.service.impl.NewsServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Марат on 19.04.2017.
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration
public class NewsServiceTest {
    @Mock
    private NewsService newsService;

    @Before
    public void setup() {
        ArrayList<News> news = new ArrayList<News>();
        News first = new News();
        News second = new News();
        first.setText("1");
        first.setId(1L);
        second.setText("2");
        news.add(first);
        news.add(second);
        Mockito.when(newsService.getAll()).thenReturn(news);
        Mockito.when(newsService.getOne(1L)).thenReturn(first);
    }

    @Test
    public void testGetNewsSuccess() throws Exception {
        News news = newsService.getOne(1L);
        assertEquals("1", news.getText());
    }

    @Test
    public void testGetAllNewsSuccess() throws Exception {
        List<News> news = newsService.getAll();
        assertEquals(news.toArray().length, 2);
    }

    @Configuration
    static class NewsServiceTestContextConfiguration {
        @Bean
        public NewsService newsService() {
            return new NewsServiceImpl(newsRepository());
        }

        @Bean
        public NewsRepository newsRepository() {
            return Mockito.mock(NewsRepository.class);
        }
    }

}
