package org.example.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnit4.class)
public class TeacherTest {

@Before
public void setup() {

}

@Test
    public void shouldBeEqual() {
    Teacher teacher1 = new Teacher("michal", "kowalski", "michal@gmail.com", 40, "Economy");
    Teacher teacher2 = new Teacher("michal", "kowalski", "michal@gmail.com", 40, "Economy");
    assertTrue(teacher1.equals(teacher2));
}

@Test
    public void shouldNotBeEqual() {
    Teacher teacher1 = new Teacher("michal", "kowalski", "michal@gmail.com", 40, "Economy");
    Teacher teacher3 = new Teacher("karol", "magiczny", "magik@gmail.com", 30, "Data Science");
    assertFalse(teacher1.equals(teacher3));
}

}