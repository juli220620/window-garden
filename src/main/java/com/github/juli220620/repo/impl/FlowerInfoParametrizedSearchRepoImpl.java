package com.github.juli220620.repo.impl;

import com.github.juli220620.model.FlowerInfoEntity;
import com.github.juli220620.repo.FlowerInfoParametrizedSearchRepo;
import com.github.juli220620.web.rq.SearchParamsRq;
import com.github.juli220620.web.rq.SearchRangedParamsRq;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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
                searchParams.add(builder.equal(root.get("canBloom"), rq.canBloom()));
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

    @Override
    public List<FlowerInfoEntity> findByRangedParams(SearchRangedParamsRq rq) {
        try (var session = sessionFactory.openSession()) {
            var builder = session.getCriteriaBuilder();
            var criteriaQuery = builder.createQuery(FlowerInfoEntity.class);
            var root = criteriaQuery.from(FlowerInfoEntity.class);

            root.fetch("alternativeNames");

            List<Predicate> searchParams = new ArrayList<>();

            if (rq.canBloom() != null && !rq.canBloom().isEmpty()) {
                var bloomingParams = rq.canBloom().stream()
                        .map(it -> builder.equal(root.get("canBloom"), it))
                        .toList();
                searchParams.add(builder.and(bloomingParams.toArray(new Predicate[]{})));
            }

            if (rq.name() != null && !rq.name().isEmpty()) {
                searchParams.add(builder.like(root.get("name"), rq.name()));
            }

            if (rq.light() != null && !rq.light().isEmpty()) {
                var lightParams = rq.light().stream()
                        .map(it -> builder.equal(root.get("light"), it))
                        .toList();
                searchParams.add(builder.and(lightParams.toArray(new Predicate[]{})));
            }

            if (rq.temperature() != null && !rq.temperature().isEmpty()) {
                var tempParams = rq.temperature().stream()
                        .map(it -> builder.equal(root.get("temperature"), it))
                        .toList();
                searchParams.add(builder.and(tempParams.toArray(new Predicate[]{})));
            }

            if (rq.humidity() != null && !rq.humidity().isEmpty()) {
                var humidityParams = rq.humidity().stream()
                        .map(it -> builder.equal(root.get("humidity"), it))
                        .toList();
                searchParams.add(builder.and(humidityParams.toArray(new Predicate[]{})));
            }

            if (rq.toxicityStatus() != null && !rq.toxicityStatus().isEmpty()) {
                var toxParams = rq.toxicityStatus().stream()
                        .map(it -> builder.equal(root.get("toxicity").get("toxicityStatus"), it))
                        .toList();
                searchParams.add(builder.and(toxParams.toArray(new Predicate[]{})));
            }

            if (searchParams.isEmpty()) return Collections.emptyList();

            criteriaQuery.select(root).where(searchParams.toArray(new Predicate[]{}));
            return session.createQuery(criteriaQuery).getResultList();
        }
    }
}
