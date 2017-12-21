import com.solncev.model.User;
import com.solncev.repository.UserRepository;
import com.solncev.repository.UserRoleRepository;
import com.solncev.service.UserService;
import com.solncev.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;

/**
 * Created by Марат on 19.04.2017.
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration
public class UserServiceTest {
    @Mock
    private UserService userService;

    @Before
    public void setup() {
        User user = new User();
        user.setLogin("sagit");
        user.setId(1);
        Mockito.when(userService.getUser("sagit")).thenReturn(user);
        Mockito.when(userService.getOne(1L)).thenReturn(user);
    }

    @Test
    public void testGetByLoginSuccess() throws Exception {
        User user = userService.getUser("sagit");
        assertEquals("sagit", user.getLogin());
    }

    @Test
    public void testAddUserSuccess() throws Exception {
        User user = userService.getOne(1L);
        assertEquals("sagit", user.getLogin());
    }

    @Configuration
    static class UserServiceTestContextConfiguration {
        @Bean
        public UserService userService() {
            return new UserServiceImpl(userRepository(), userRoleRepository());
        }

        @Bean
        private UserRoleRepository userRoleRepository() {
            return Mockito.mock(UserRoleRepository.class);
        }

        @Bean
        public UserRepository userRepository() {
            return Mockito.mock(UserRepository.class);
        }
    }
}
