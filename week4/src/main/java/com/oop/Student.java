package com.oop;

public class Student {
    public String name;
    public int grade;

    public Student() {
    }

    public Student(String name, int grade) {
        this.name = name;
        updateGrade(grade);
    }

    /**
     * Updates the student's grade.
     * Logic:
     * - Valid grades are between 0 and 100 (inclusive).
     * - If the grade is outside this range (< 0 or > 100), the update is rejected,
     *   a warning is printed, and the existing grade remains unchan*/
    public void updateGrade(int newGrade) {
        if (newGrade < 0 || newGrade > 100) {
            System.out.println("Invalid grade: " + newGrade + ". Grade must be between 0 and 100.");
            return;
        }
        this.grade = newGrade;
    }
}
