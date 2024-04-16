package exo1;

import org.example.exo1.User;
import org.example.exo1.UserRepository;
import org.example.exo1.UserService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    public void testGetUserById() {
        // Création d'un mock pour le UserRepository
        UserRepository mockRepository = mock(UserRepository.class);

        // Création d'un utilisateur fictif pour les tests
        User user_test = new User(1, "John Doe");

        // Définition du comportement attendu du mock lors de l'appel à findUserById
        when(mockRepository.findUserById(1)).thenReturn(user_test);

        // Création de UserService en lui passant le mockRepository
        UserService userService = new UserService(mockRepository);

        // Appel de la méthode getUserById avec l'ID de l'utilisateur
        User retrievedUser = userService.getUserById(1);

        // Vérification que la méthode findUserById du mockRepository a bien été appelée avec l'argument attendu
        verify(mockRepository).findUserById(1);


    }
}
