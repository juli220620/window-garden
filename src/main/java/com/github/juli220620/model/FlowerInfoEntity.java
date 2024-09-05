package com.github.juli220620.model;

import com.github.juli220620.model.param.HumidityPreference;
import com.github.juli220620.model.param.LightPreference;
import com.github.juli220620.model.param.TemperaturePreference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(schema = "flowers", name = "flower_dict")
public class FlowerInfoEntity {

    public FlowerInfoEntity() {
        toxicity = new FlowerToxicityInfoEntity();
    }

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    private String name;
    private boolean canBloom;

    @Enumerated(EnumType.STRING)
    private LightPreference light;

    @Enumerated(EnumType.STRING)
    private HumidityPreference humidity;

    @Enumerated(EnumType.STRING)
    private TemperaturePreference temperature;

    @OneToOne(cascade = ALL, orphanRemoval = true, mappedBy = "flower")
    private FlowerToxicityInfoEntity toxicity;

    @OneToMany(cascade = ALL, orphanRemoval = true, mappedBy = "flower")
    private List<AlternativeNameEntity> alternativeNames;

}
