package com.github.juli220620.repo.impl;

import com.github.juli220620.model.FlowerInfoEntity;
import com.github.juli220620.repo.FlowerInfoParametrizedSearchRepo;
import com.github.juli220620.web.rq.SearchParamsRq;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.juli220620.model.param.ToxicityStatus.NOT_POISONOUS;

@Service
@RequiredArgsConstructor
public class FlowerInfoParametrizedSearchRepoImpl implements FlowerInfoParametrizedSearchRepo {

    private final SessionFactory sessionFactory;

    @Override
    public List<FlowerInfoEntity> findNonToxic() {
        try (var session = sessionFactory.openSession()) {
            var builder = session.getCriteriaBuilder();
            var criteriaQuery = builder.createQuery(FlowerInfoEntity.class);
            var root = criteriaQuery.from(FlowerInfoEntity.class);

            root.fetch("alternativeNames");

            criteriaQuery.select(root)
                    .where(builder.equal(root.get("toxicity").get("toxicityStatus"), NOT_POISONOUS));
            return session.createQuery(criteriaQuery).getResultList();
        }
    }

    @Override
    public List<FlowerInfoEntity> findByParams(SearchParamsRq rq) {
        try (var session = sessionFactory.openSession()) {
            var builder = session.getCriteriaBuilder();
            var criteriaQuery = builder.createQuery(FlowerInfoEntity.class);
            var root = criteriaQuery.from(FlowerInfoEntity.class);

            root.fetch("alternativeNames");

            Predicate blooming;
            if (rq.canBloom() != null && rq.canBloom()) {
                blooming = builder.equal(root.get("canBloom"), true);
            } else {
                blooming = builder.equal(root.get("canBloom"), false);
            }

            Predicate byName = null;
            if (rq.name() != null) {
                byName = builder.like(root.get("name"), rq.name());
            }

            Predicate finalParams = builder.and(blooming, byName);
            criteriaQuery.select(root).where(finalParams);
            return session.createQuery(criteriaQuery).getResultList();
        }
    }
}
