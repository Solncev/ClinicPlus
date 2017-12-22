import com.solncev.controller.MainController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by Марат on 30.05.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainControllerTest {
    @InjectMocks
    private MainController mainController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    public void testGetPageController() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(view().name("slider"));
    }

    @Test

    public void testGetLoginController() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(view().name("loginpage"));
    }
}
