package com.example.serverDevelopment.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.lang.reflect.Type;

@Entity
@Table
@Data
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Long age;

    @Column(name = "programmingLang")
    private String programmingLanguage;

}
