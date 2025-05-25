package tp3;

import org.example.tp3.Task;
import org.example.tp3.TaskService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.MySQLContainer;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.wait.strategy.Wait;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Task.class)
public class TaskServiceIntegrationTest {

    // L'instance MySQLContainer fournie par TestContainers
    private static MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0.30")
            .withDatabaseName("testdb")
            .withUsername("root")
            .withPassword("password")
            .waitingFor(Wait.forListeningPort());

    @Autowired
    private TaskService taskService;

    // Démarre le conteneur MySQL avant tous les tests
    @BeforeAll
    public static void setUp() {
        mysqlContainer.start();
    }

    // Arrête le conteneur après tous les tests
    @AfterAll
    public static void tearDown() {
        mysqlContainer.stop();
    }

    // Méthode pour configurer dynamiquement les propriétés de la base de données
    @DynamicPropertySource
    public static void dynamicProperties(org.springframework.test.context.DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysqlContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mysqlContainer::getUsername);
        registry.add("spring.datasource.password", mysqlContainer::getPassword);
    }

    @Test
    public void testCreateTask() {
        Task task = new Task("Tâche 1", "Description de la tâche 1");
        taskService.saveTask(task);

        // Vérifie que la tâche est bien enregistrée dans la base de données
        Optional<Task> retrievedTask = taskService.findTaskById(task.getId());
        assertTrue(retrievedTask.isPresent());
        assertEquals(task.getTitle(), retrievedTask.get().getTitle());
        assertEquals(task.getDescription(), retrievedTask.get().getDescription());
    }

    @Test
    public void testGetTask() {
        Task task = new Task("Tâche 2", "Description de la tâche 2");
        taskService.saveTask(task);

        // Récupère la tâche et vérifie qu'elle existe
        Optional<Task> retrievedTask = taskService.findTaskById(task.getId());
        assertTrue(retrievedTask.isPresent());
        assertEquals(task.getTitle(), retrievedTask.get().getTitle());
        assertEquals(task.getDescription(), retrievedTask.get().getDescription());
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("Tâche 3", "Description de la tâche 3");
        taskService.saveTask(task);

        // Supprime la tâche
        taskService.deleteTaskById(task.getId());

        // Vérifie que la tâche est supprimée
        Optional<Task> retrievedTask = taskService.findTaskById(task.getId());
        assertFalse(retrievedTask.isPresent());
    }
}
