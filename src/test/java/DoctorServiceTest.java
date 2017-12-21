import com.solncev.model.Doctor;
import com.solncev.service.DoctorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;

/**
 * Created by Марат on 31.05.2017.
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration
public class DoctorServiceTest {
    @Mock
    private DoctorService doctorService;

    @Before
    public void setup() {
        Doctor doctor = new Doctor();
        doctor.setExperience(5);
        doctor.setId(1L);
        Mockito.when(doctorService.getOne(1L)).thenReturn(doctor);
    }

    @Test
    public void testExperienceCorrectness() throws Exception {
        Doctor doctor = doctorService.getOne(1L);
        assertEquals(5, doctor.getExperience());
    }
}
