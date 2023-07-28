package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "countries")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Country {
    public Country(String name, String language) {
        this.name = name;
        this.language = language;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_gen")
    @SequenceGenerator(name = "country_gen", sequenceName = "country_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String language;
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
    @JoinColumn(name = "president_id")
    private President president;

    public Country(String name, String language, President president) {
        this.name = name;
        this.language = language;
        this.president = president;
    }

    @Override
    public String toString() {
        return "Country{id=" + id + ", name='" + name + "', language='" + language + "'}";
    }
}
