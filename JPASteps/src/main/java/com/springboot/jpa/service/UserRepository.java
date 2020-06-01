package com.springboot.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
