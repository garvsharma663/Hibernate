package org.example.Reationships_Basics.ManyToMany;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name =  "courses")
public class Course {
    @Column(nullable = false)
    private String course_name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_id;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();


    public int getCourse_id() {
        return course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

}
