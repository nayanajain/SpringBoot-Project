package com.example.demo.Repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.User;

public interface UserRepo extends CrudRepository<User, Integer>{

}
