package com.github.juli220620.repo;

import com.github.juli220620.model.FlowerInfoEntity;
import com.github.juli220620.web.rq.SearchParamsRq;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowerInfoParametrizedSearchRepo {

    List<FlowerInfoEntity> findNonToxic();

    List<FlowerInfoEntity> findByParams(SearchParamsRq rq);
}
