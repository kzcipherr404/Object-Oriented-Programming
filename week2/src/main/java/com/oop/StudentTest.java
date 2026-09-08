package com.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {
    @Test
    void testUpdateGrade() {
        // Arrange
        Student student = new Student();
        // Act
        student.updateGrade(85);
        // Assert
        assertEquals(85, student.grade);
    }
}

