package com.spring.in.action.part2.repository;

import com.spring.in.action.part2.model.Taco;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface TacoRepository extends PagingAndSortingRepository<Taco, Long> {

}

