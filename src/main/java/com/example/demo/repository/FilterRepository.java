package com.example.demo.repository;

import com.example.demo.domain.Filter;
import com.example.demo.domain.FilterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilterRepository extends JpaRepository<Filter, Integer> {

    Optional<Filter> findByTypeAndValue(FilterType type, String value);
}
