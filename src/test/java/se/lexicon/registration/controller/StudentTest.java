package se.lexicon.registration.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.registration.entity.Student;

import java.time.LocalDateTime;



@SpringBootTest
public class StudentTest {

    Student studentTest;

    @BeforeEach
    public void setup(){
        studentTest = new Student();
        studentTest.setFirstName("Mikael");
        studentTest.setLastName("Aurell");
        studentTest.setAge(42);
        studentTest.setGender("Male");
        studentTest.setEmail("aurell.mikael@gmail.com");
        studentTest.setPhoneNumber("076-3173768");
        studentTest.setRegisterDate(LocalDateTime.of(1978,04,30,15,03));
        studentTest.setStatus(true);
    }

    @Test
    @DisplayName("Test1 Created Object")
    public void create_student(){
        Assertions.assertEquals(42, studentTest.getAge());
        Assertions.assertEquals("Mikael", studentTest.getFirstName());
        Assertions.assertEquals("aurell.mikael@gmail.com", studentTest.getEmail());
        Assertions.assertEquals(04, studentTest.getRegisterDate().getMonthValue());
    }

    @Test
    @DisplayName("Test2 Equal")
    public void test_equal(){
        Student expected = new Student();
        expected.setFirstName("Mikael");
        expected.setLastName("Aurell");
        expected.setAge(42);
        expected.setGender("Male");
        expected.setEmail("aurell.mikael@gmail.com");
        expected.setPhoneNumber("076-3173768");
        expected.setRegisterDate(LocalDateTime.of(1978,04,30,15,03));
        expected.setStatus(true);

        Assertions.assertTrue(studentTest.equals(expected));
    }

    @Test
    @DisplayName("Test3 HashCode")
    public void test_hashcode(){
        Student expected = new Student();
        expected.setFirstName("Mikael");
        expected.setLastName("Aurell");
        expected.setAge(42);
        expected.setGender("Male");
        expected.setEmail("aurell.mikael@gmail.com");
        expected.setPhoneNumber("076-3173768");
        expected.setRegisterDate(LocalDateTime.of(1978,04,30,15,03));
        expected.setStatus(true);
        Assertions.assertEquals(expected.hashCode(), studentTest.hashCode());
    }

}
