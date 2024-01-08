package com.dev.ExerciseHibernate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;

    // relazione uno a molti con enrollment
    @OneToMany(mappedBy = "classes", cascade = CascadeType.ALL)
    private ArrayList<Enrollment> enrollment;

}
