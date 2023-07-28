package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "presidents")
public class President {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "president_gen")
    @SequenceGenerator(name = "president_gen", sequenceName = "president_seq", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    @OneToOne(mappedBy = "president", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})

    private Country country;

    public President(String firstName, String lastName, int age, Country country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
    }

    public President(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "President{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName + "'}";
    }

}
