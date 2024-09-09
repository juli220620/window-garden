package com.github.juli220620.repo.impl;

import com.github.juli220620.model.FlowerInfoEntity;
import com.github.juli220620.repo.FlowerInfoParametrizedSearchRepo;
import com.github.juli220620.web.rq.SearchParamsRq;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

            List<Predicate> searchParams = new ArrayList<>();

            if (rq.canBloom() != null) {
                var blooming = rq.canBloom()
                        ? builder.equal(root.get("canBloom"), true)
                        : builder.equal(root.get("canBloom"), false);
                searchParams.add(blooming);
            }


            if (rq.name() != null && !rq.name().isEmpty()) {
                searchParams.add(builder.like(root.get("name"), rq.name()));
            }

            if (rq.light() != null && !rq.light().isEmpty()) {
                searchParams.add(builder.equal(root.get("light"), rq.light()));
            }

            if (rq.temperature() != null && !rq.temperature().isEmpty()) {
                searchParams.add(builder.equal(root.get("temperature"), rq.temperature()));
            }

            if (rq.humidity() != null && !rq.humidity().isEmpty()) {
                searchParams.add(builder.equal(root.get("humidity"), rq.humidity()));
            }

            if (rq.toxicityStatus() != null && !rq.toxicityStatus().isEmpty()) {
                searchParams.add(builder.equal(root.get("toxicity").get("toxicityStatus"), rq.toxicityStatus()));
            }

            criteriaQuery.select(root).where(searchParams.toArray(new Predicate[]{}));
            return session.createQuery(criteriaQuery).getResultList();
        }
    }
}
