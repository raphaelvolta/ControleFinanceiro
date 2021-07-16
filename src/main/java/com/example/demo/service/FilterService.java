package com.example.demo.service;

import com.example.demo.domain.Filter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FilterService {
    List<Filter> getFilters();
    Filter getFilter(Integer filterId);
    Filter postFilter(Filter filter);
    Filter putFilter(Filter filter, Integer filterId);
    void deleteFilter(Integer filterId);
}
