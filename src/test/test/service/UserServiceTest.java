package service;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository);
    }

    @Test
    public void testGetAllUsers() {
        // Arrange
        List<User> userList = new ArrayList<>();
        User user1 = createUser(1, "User1", "Last1", "user1@example.com", "123-456-7890");
        User user2 = createUser(2, "User2", "Last2", "user2@example.com", "987-654-3210");
        userList.add(user1);
        userList.add(user2);

        when(userRepository.findAll()).thenReturn(userList);

        // Act
        List<User> result = userService.getAllUsers();

        // Assert
        assertEquals(2, result.size());
        assertEquals(user1, result.get(0));
        assertEquals(user2, result.get(1));
    }

    @Test
    public void testCreateNewUser() {
        // Arrange
        User newUser = createUser(null, "NewUser", "LastNew", "newuser@example.com", "111-222-3333");

        // Act
        userService.createNewUser(newUser);

        // Assert
        verify(userRepository, times(1)).save(newUser);
    }

    @Test
    public void testGetUserFound() {
        // Arrange
        int userId = 1;
        User user = createUser(userId, "User1", "Last1", "user1@example.com", "123-456-7890");

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Act
        User result = userService.getUser(userId);

        // Assert
        assertEquals(user, result);
    }

    @Test
    public void testGetUserNotFound() {
        // Arrange
        int userId = 999;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> userService.getUser(userId));
    }

    // Helper method to create a User object
    private User createUser(Integer id, String firstName, String lastName, String email, String phone) {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhone(phone);
        return user;
    }
}
