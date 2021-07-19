package com.example.demo.service.impl;

import com.example.demo.domain.Filter;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.repository.FilterRepository;
import com.example.demo.service.FilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService {

    private final FilterRepository filterRepository;

    @Override
    public List<Filter> getFilters() {
        return filterRepository.findAll();
    }

    @Override
    public Filter getFilter(Integer filterId) {
        return filterRepository.findById(filterId).orElseThrow(() -> new EntityNotFoundException("Filter {0} not found.", filterId));
    }

    @Override
    public Filter postFilter(Filter filter) {
        Optional<Filter> exists =  filterRepository.findByTypeAndValue(filter.getType(), filter.getValue());
        return exists.orElseGet(() -> filterRepository.save(filter));
    }

    @Override
    public Filter putFilter(Filter filter, Integer filterId) {
        getFilter(filterId);
        filter.setFilterId(filterId);
        return filterRepository.save(filter);
    }

    @Override
    public void deleteFilter(Integer filterId) {
        Filter filter = getFilter(filterId);
        filterRepository.delete(filter);
    }
}
