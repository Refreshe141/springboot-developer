package com.kmh.Spring01;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Member,Long> {
    Long id(Long id);

    public List<Member>findByName(String name);
}
