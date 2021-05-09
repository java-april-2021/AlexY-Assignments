package com.alexyom.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.alexyom.relationships.models.License;

public class LicenseRepository extends CrudRepository<License, Long>{
	public List<License> findAll();
	public License findTopByOrderByNumberDesc();
}
