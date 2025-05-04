package tp3;



import org.example.tp3.Task;
import org.example.tp3.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

@SpringBootTest
@Testcontainers
@ExtendWith(SpringExtension.class)
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:mysql://localhost:${MYSQL_PORT}/testdb",
        "spring.datasource.username=root",
        "spring.datasource.password=password"
})
public class Part2 {

    @Container
    static MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("testdb")
            .withUsername("root")
            .withPassword("password");

    @Autowired
    private TaskService taskService;

    @Test
    public void testCreateTask() {
        // Créer une nouvelle tâche
        Task task = new Task("Tâche 1", "Description de la tâche 1");

        // Enregistrer la tâche
        taskService.saveTask(task);

        // Vérifier que la tâche a été enregistrée dans la base de données
        Long taskId = task.getId();
        Optional<Task> retrievedTask = taskService.findTaskById(taskId);

        assertTrue(retrievedTask.isPresent());
        assertEquals(task.getName(), retrievedTask.get().getName());
        assertEquals(task.getDescription(), retrievedTask.get().getDescription());
    }

    @Test
    public void testGetTask() {
        Task task = createAndSaveTask();
        Long taskId = task.getId();
        Optional<Task> retrievedTask = taskService.findTaskById(taskId);

        assertTrue(retrievedTask.isPresent());
        assertEquals(task.getName(), retrievedTask.get().getName());
        assertEquals(task.getDescription(), retrievedTask.get().getDescription());
    }

    @Test
    public void testDeleteTask() {
        Task task = createAndSaveTask();
        Long taskId = task.getId();

        taskService.deleteTaskById(taskId);

        Optional<Task> retrievedTask = taskService.findTaskById(taskId);
        assertFalse(retrievedTask.isPresent());
    }

    private Task createAndSaveTask() {
        Task task = new Task("Tâche 2", "Description de la tâche 2");
        taskService.saveTask(task);
        return task;
    }
}

