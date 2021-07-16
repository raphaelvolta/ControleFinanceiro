package com.example.demo.controller;

import com.example.demo.domain.Filter;
import com.example.demo.jsonDto.FilterDto;
import com.example.demo.service.FilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/filters")
@RequiredArgsConstructor
public class FilterController {

    private final FilterService filterService;

    @GetMapping
    public ResponseEntity<List<Filter>> getFilters(){
        return ResponseEntity.ok(filterService.getFilters());
    }

    @GetMapping("/{filterId}")
    public ResponseEntity<Filter> getFilterById(
            @PathVariable("filterId") Integer filterId){
        return ResponseEntity.ok(filterService.getFilter(filterId));
    }

    @PostMapping
    public ResponseEntity<Filter> postFilter(
            @RequestBody FilterDto filterDto){
        return ResponseEntity.ok(filterService.postFilter(filterDto.toDomain()));
    }

    @PutMapping("/{filterId}")
    public ResponseEntity<Filter> putFilter(
            @PathVariable("filterId") Integer filterId,
            @RequestBody Filter filter){
        return ResponseEntity.ok(filterService.putFilter(filter, filterId));
    }

    @DeleteMapping("/{filterId}")
    public ResponseEntity<Filter> deleteFilter(
            @PathVariable("filterId") Integer filterId){
        filterService.deleteFilter(filterId);
        return ResponseEntity.noContent().build();
    }
}
