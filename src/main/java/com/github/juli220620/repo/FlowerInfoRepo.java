package com.github.juli220620.repo;

import com.github.juli220620.model.FlowerInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerInfoRepo extends JpaRepository<FlowerInfoEntity, String>, FlowerInfoParametrizedSearchRepo {
}
