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
@Table(schema = "flowers", name = "flower_dict")
public class FlowerInfoEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    private String name;
    private boolean canBloom;
    private String light;
    private String humidity;
    private String temperature;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id", referencedColumnName = "flower_id")
    private FlowerToxicityInfoEntity toxicity;

}
