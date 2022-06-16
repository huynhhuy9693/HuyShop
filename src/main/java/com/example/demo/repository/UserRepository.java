package com.example.demo.repository;

import com.example.demo.entity.UserTb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface UserRepository extends JpaRepository<UserTb,Long> {
}
