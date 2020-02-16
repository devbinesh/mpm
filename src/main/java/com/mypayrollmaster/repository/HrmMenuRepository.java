package com.mypayrollmaster.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mypayrollmaster.model.HrmMenu;

@Repository
public interface HrmMenuRepository extends CrudRepository<HrmMenu, Long>{

	List<HrmMenu> findAllByActive(String active);
}
