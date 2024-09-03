package com.github.juli220620.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "flowers", name = "alternative_name")
public class AlternativeNameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String alternativeName;

    @ManyToOne
    @JoinColumn(name = "flower_id", referencedColumnName = "id")
    private FlowerInfoEntity flower;
}
