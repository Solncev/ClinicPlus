import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;

/**
 * Created by Марат on 19.04.2017.
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration
public class UserServiceTest {
    @Test
    public void testGetSuccess() throws Exception {
        assertEquals(2, 2);
    }
}
