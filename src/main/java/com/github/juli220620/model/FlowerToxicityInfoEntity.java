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
@Table(schema = "flowers", name = "flower_toxicity")
public class FlowerToxicityInfoEntity {
    private String toxicityStatus;
    private String explanation;

    @Id
    @OneToOne
    @JoinColumn(name = "flower_id", referencedColumnName = "id")
    private FlowerInfoEntity flower;
}
