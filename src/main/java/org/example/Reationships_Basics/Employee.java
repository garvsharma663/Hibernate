package org.example.Reationships_Basics;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Column(nullable = false)
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private Long phone_One;

    @Column(unique = true)
    private Long phone_Two;

    @OneToMany(mappedBy = "employee")
    private List<Project> projects;

    // Getters & Setters
    public String getName(){return name;}
    public void setName(String name) {this.name=name;}

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public Long getPhone_One(){return phone_One;}
    public void setPhone_One(Long phone_One){this.phone_One=phone_One;}

    public Long getPhone_Two(){return phone_Two;}
    public void setPhone_Two(Long phone_Two){this.phone_Two=phone_Two;}
}
