package classroom;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    public int capacity;
    public List<Student> students;

    public Classroom(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (this.students.size() == this.capacity) {
            return "No seats in the classroom";
        } else if (this.students.contains(student)) {
            return "Student is already in the classroom";
        } else {
            this.students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        }
    }

    public String dismissStudent(Student student) {
        if (!this.students.contains(student)) {
            return "Student not found";
        } else {
            this.students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        }
    }

    public String getSubjectInfo(String subject) {
        int studentsEnrolled = 0;

        for (Student s : this.students) {
            if (subject.equals(s.getBestSubject()))
                studentsEnrolled++;
        }

        StringBuilder out = new StringBuilder();
        if (studentsEnrolled == 0) {
            return "No students enrolled for the subject";
        } else {
            out = new StringBuilder(String.format("Subject: %s%n", subject));
            out.append(String.format("Students:%n"));

            for (Student s : this.students) {
                if (subject.equals(s.getBestSubject()))
                    out.append(String.format("%s %s%n", s.getFirstName(), s.getLastName()));
            }
        }

        return out.toString().trim();
    }

    public String getStudent(String firstName, String lastName) {
        String out = "";
        for (Student s : this.students) {
            if (firstName.equals(s.getFirstName()) && lastName.equals(s.getLastName())) {
                out = s.toString();
            }
        }
        return out;
    }

    public String getStatistics() {
        StringBuilder out = new StringBuilder(String.format("Classroom size: %d%n", this.students.size()));

        for (Student s : this.students) {
            out.append(String.format("==%s%n", s.toString()));
        }

        return out.toString().trim();
    }
}
