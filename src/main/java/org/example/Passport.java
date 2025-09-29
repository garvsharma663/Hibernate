package org.example;
import jakarta.persistence.*;
@Entity
@Table(name = "passports")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String passport_type;

    @OneToOne(mappedBy = "passport") // mappedBy ----> tells Hibernate which table owns the foreign key.
    private Annotation_Basics_Student_Class_Example student;

    // Getters & Setters.
    public Long getId(){return id;}
    public void setId(Long id) { this.id = id; }
    public String getPassport_type() { return passport_type; }
    public void setPassport_type(String passport_type) { this.passport_type = passport_type; }
    public Annotation_Basics_Student_Class_Example getStudent() { return student; }
    public void setStudent(Annotation_Basics_Student_Class_Example student) { this.student = student; }

}
