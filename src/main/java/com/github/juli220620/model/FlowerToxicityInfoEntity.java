package com.github.juli220620.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    @Id
    private String flowerId;

    private String toxicityStatus;
    private String explanation;
}
