package tp0;

import org.example.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PersonTest {
    @Test
    void testGetFullName() {
        Person person1 = new Person("khaled", "bo", 25);
        assertEquals("khaled bo", person1.getFullName());

        Person person2 = new Person("l'ah", "amar", 30);
        assertEquals("l'ah amar", person2.getFullName());
    }
    @Test
    void testIsAdult() {
        // Test case 1: Person is an adult
        Person person1 = new Person("khaled", "bousselidj", -1);
        assertFalse(person1.isAdult());

        // Test case 2: Person is exactly 18 years old
        Person person2 = new Person("moumen", "nouasria", 18);
        assertTrue(person2.isAdult());

        // Test case 3: Person is younger than 18 years old
        Person person3 = new Person("seif", "gharbi", 17);
        assertFalse(person3.isAdult());
    }
}
