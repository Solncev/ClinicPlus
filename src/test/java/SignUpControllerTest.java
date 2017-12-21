import com.solncev.controller.SignUpController;
import com.solncev.service.CommentService;
import com.solncev.service.ContactService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by Марат on 30.05.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class SignUpControllerTest {
    @Mock
    private ContactService contactService;
    @Mock
    private CommentService commentService;
    @Mock
    private SecurityContextHolder securityContextHolder;
    @InjectMocks
    private SignUpController signUpController;

    ;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        when(commentService.getAll()).thenReturn(new ArrayList<>());
        when(contactService.getAll()).thenReturn(new ArrayList<>());
        mockMvc = MockMvcBuilders.standaloneSetup(signUpController).build();
    }

    @Test
    public void testGetCommentController() throws Exception {
        mockMvc.perform(get("/registration"))
                .andExpect(view().name("registrationpage"));
    }
}
