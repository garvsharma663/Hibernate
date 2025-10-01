package org.example.Reationships_Basics.ManyToMany;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "learners")
public class Student {
    @Column(nullable = false)
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    // As Relational DB can't directly store Many-To-Many, they make a separate JOIN table to do so.
    // @JoinTable ---> In this example we're providing a name to the new JoinTable, and also
    // using joinColumns =, inverseJoinColumns=,  we're making Foreign Keys for the owning side and the other side.

    @JoinTable(name = "students_and_courses",

    joinColumns = @JoinColumn(name = "student_id"),

    inverseJoinColumns = @JoinColumn(name = "course_id"))

    // Using a Set here is the best practice as we don't want duplicates to be added in our DB.
    // and also for average O(1) time.
    private Set<Course> courses = new HashSet<>();


    // Some helper Methods

    public void addCourse(Course course){
        courses.add(course);
        course.getStudents().remove(this);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
        course.getStudents().remove(this);
    }

    // Getters and Setters


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

}
