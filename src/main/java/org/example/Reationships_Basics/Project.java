package org.example.Reationships_Basics;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee; // The field that owns the relationship ManyToOne (used in mappedBy="").

    public Long getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

}
