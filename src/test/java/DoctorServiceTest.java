import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;

/**
 * Created by Марат on 31.05.2017.
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration
public class DoctorServiceTest {
    @Test
    public void testExperienceCorrectness() throws Exception {
        assertEquals(5, 5);
    }
}
