package org.example;

import jakarta.persistence.*; // Has Classes, Entities and Enums for our use.

@Entity // This marks the Java class as a Table

// @Table -----> Optional (we can set custom table name if we don't want to use the table name same as the class name).

@Table(name = "students") // we can have other attributes here also like schema, catalog etc.

public class Annotation_Basics_Student_Class_Example {

    @Id // Marks Primary Key Column of the table.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tells Hibernate how to generate Primary Key values.

    private long id;

    @Column(nullable = false) // A column with a constraint of not being null.
    private String name;

    @Column // Can be null
    private int age;

    @Column(name = "mail",
    nullable = false,
    unique = true,
    updatable = false,
    length = 25)
    private String email;

    @Transient // This will not be stored in the DataBase.
    private String temp;


    // Passport example for representing One-to-One Relationship.
    @OneToOne // represents one object linked to only one other object.
    @JoinColumn(name = "passport_id", referencedColumnName = "id") // Foreign Key Column to be referenced in other table.
    // name = <the column in students table>, referencedColumnName = <the primary key of the referenced table>.
    private Passport passport;

    // Getters and Setters

    public Long getId(){return id;}
    public void setId(Long id) {this.id= id;}
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Passport getPassport() { return passport; }
    public void setPassport(Passport passport) { this.passport = passport; }


}
