package tp3;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.tp3.User;
import org.example.tp3.UserRepository;
import org.example.tp3.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Exo1 {

    @Test
    void testGetUserById_CallsFindUserById() {
        // Arrange
        UserRepository mockRepository = mock(UserRepository.class);
        UserService userService = new UserService(mockRepository);

        User fakeUser = new User(1L, "John Doe");

        // Stubbing : on définit le comportement attendu du mock
        when(mockRepository.findUserById(1L)).thenReturn(fakeUser);

        // Act
        User result = userService.getUserById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("John Doe", result.getName());

        // Verify that findUserById was called exactly once with argument 1L
        verify(mockRepository, times(1)).findUserById(1L);
    }
}
