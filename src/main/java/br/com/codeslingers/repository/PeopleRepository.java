package br.com.codeslingers.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.codeslingers.beans.PeopleBean;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PeopleRepository extends PagingAndSortingRepository<PeopleBean, Integer> {
	
	 public Page<PeopleBean> findAll(Pageable pageable);

}
