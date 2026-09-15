package com.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    @Test
    void testUpdateGradeValid() {
        // Arrange
        Student student = new Student();
        student.grade = 60;

        // Act
        student.updateGrade(85);

        // Assert
        assertEquals(85, student.grade);
    }

    @Test
    void testUpdateGradeBelowZeroRejected() {
        // Arrange
        Student student = new Student();
        student.grade = 70;

        // Act (negative grade rejected, original grade remains intact)
        student.updateGrade(-15);

        // Assert
        assertEquals(70, student.grade);
    }

    @Test
    void testUpdateGradeAboveHundredRejected() {
        // Arrange
        Student student = new Student();
        student.grade = 70;

        // Act (grade > 100 rejected, original grade remains intact)
        student.updateGrade(105);

        // Assert
        assertEquals(70, student.grade);
    }

    @Test
    void testUpdateGradeBoundaryZero() {
        // Arrange
        Student student = new Student();
        student.grade = 50;

        // Act (lower bound 0 is valid)
        student.updateGrade(0);

        // Assert
        assertEquals(0, student.grade);
    }

    @Test
    void testUpdateGradeBoundaryHundred() {
        // Arrange
        Student student = new Student();
        student.grade = 50;

        // Act (upper bound 100 is valid)
        student.updateGrade(100);

        // Assert
        assertEquals(100, student.grade);
    }
}
