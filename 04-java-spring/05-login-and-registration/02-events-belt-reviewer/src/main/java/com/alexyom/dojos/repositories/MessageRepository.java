package com.alexyom.dojos.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alexyom.dojos.models.Message;

public interface MessageRepository extends CrudRepository<Message, Long>{

}
