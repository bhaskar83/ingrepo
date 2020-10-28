package com.ing.login.loan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ing.login.loan.model.User;


@Repository
public interface UserDao  extends CrudRepository<User, Integer>{
	

}
  