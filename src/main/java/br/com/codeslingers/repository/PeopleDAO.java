package br.com.codeslingers.repository;

import java.util.List;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;

import br.com.codeslingers.beans.PeopleBean;

public interface PeopleDAO{
	
//	public Page<PeopleBean> findAll(Pageable pageable);

	public List<PeopleBean> list();

	public void save(PeopleBean p);

}
