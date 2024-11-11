package com.github.juli220620.model;

import com.github.juli220620.model.param.ToxicityStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Getter
@Setter
@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "flowers", name = "flower_toxicity")
public class FlowerToxicityInfoEntity {

    @Enumerated(EnumType.STRING)
    private ToxicityStatus toxicityStatus;
    private String explanation;

    @Id
    @OneToOne
    @JoinColumn(name = "flower_id", referencedColumnName = "id")
    private FlowerInfoEntity flower;
}
