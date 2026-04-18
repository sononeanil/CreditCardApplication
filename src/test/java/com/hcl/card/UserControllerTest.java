package com.hcl.card;

import com.hcl.card.controller.UserController;
import com.hcl.card.entity.User;
import com.hcl.card.exception.InvalidUserDataException;
import com.hcl.card.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        user = new User();
        user.setId(1L);
        user.setUserId("U123");
        user.setFirstName("John");
        user.setEmail("john@example.com");
    }

    // ✅ Test GET /users
    @Test
    void testGetAllUsers() {
        List<User> users = Arrays.asList(user);
        when(userService.getAllUsers()).thenReturn(users);

        List<User> result = userController.getAllUsers();

        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getFirstName());
        verify(userService, times(1)).getAllUsers();
    }

    // ✅ Test POST /users (valid input)
    @Test
    void testAddUser_Success() {
        when(userService.addUser(any(User.class))).thenReturn(user);

        User result = userController.addUser(user);

        assertNotNull(result);
        assertEquals("john@example.com", result.getEmail());
        verify(userService, times(1)).addUser(user);
    }

    // ✅ Test POST /users (invalid email)
    @Test
    void testAddUser_InvalidEmail() {
        user.setEmail(null);

        InvalidUserDataException exception = assertThrows(
                InvalidUserDataException.class,
                () -> userController.addUser(user)
        );

        assertEquals("Email is required", exception.getMessage());
        verify(userService, never()).addUser(any());
    }

    // ✅ Test GET /users/{id}
    @Test
    void testGetUserById() {
        when(userService.getUserById(1L)).thenReturn(user);

        User result = userController.getUserById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(userService, times(1)).getUserById(1L);
    }

    // ✅ Test PUT /users/{id}
    @Test
    void testUpdateUser() {
        when(userService.updateUser(eq(1L), any(User.class))).thenReturn(user);

        User result = userController.updateUser(1L, user);

        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        verify(userService, times(1)).updateUser(eq(1L), any(User.class));
    }

    // ✅ Test DELETE /users/{id}
    @Test
    void testDeleteUser() {
        doNothing().when(userService).deleteUser(1L);

        userController.deleteUser(1L);

        verify(userService, times(1)).deleteUser(1L);
    }
}