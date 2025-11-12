package com.tudai.arquitecturasweb.microservicioadmin.repository;

import com.tudai.arquitecturasweb.microservicioadmin.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface adminRepository extends JpaRepository<Admin,Integer> {
}
