package com.example.demo.controller;

import com.example.demo.domain.Rule;
import com.example.demo.jsonDto.RuleDto;
import com.example.demo.service.RuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rules")
@RequiredArgsConstructor
public class RuleController {

    private final RuleService ruleService;

    @GetMapping
    public ResponseEntity<List<Rule>> getRules(){
        return ResponseEntity.ok(ruleService.getRules());
    }

    @GetMapping("/{ruleId}")
    public ResponseEntity<Rule> getRuleById(
            @PathVariable("ruleId") Integer ruleId){
        return ResponseEntity.ok(ruleService.getRule(ruleId));
    }

    @PostMapping
    public ResponseEntity<Rule> postRule(){
        return ResponseEntity.ok(ruleService.postRule(new RuleDto().toDomain()));
    }

    @DeleteMapping("/{ruleId}")
    public ResponseEntity<Rule> deleteRule(
            @PathVariable("ruleId") Integer ruleId){
        ruleService.deleteRule(ruleId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{ruleId}/tags/{tagId}")
    public ResponseEntity<Rule> addTagToRule(
            @PathVariable("ruleId") Integer ruleId,
            @PathVariable("tagId") Integer tagId){
        return ResponseEntity.ok(ruleService.addTagToRule(ruleId, tagId));
    }

    @DeleteMapping("/{ruleId}/tags/{tagId}")
    public ResponseEntity<Rule> removeTagFromRule(
            @PathVariable("ruleId") Integer ruleId,
            @PathVariable("tagId") Integer tagId) {
        return ResponseEntity.ok(ruleService.removeTagFromRule(ruleId, tagId));
    }

    @PostMapping("/{ruleId}/filters/{filterId}")
    public ResponseEntity<Rule> addFilterToRule(
            @PathVariable("ruleId") Integer ruleId,
            @PathVariable("filterId") Integer filterId){
        return ResponseEntity.ok(ruleService.addFilterToRule(ruleId, filterId));
    }

    @DeleteMapping("/{ruleId}/filters/{filterId}")
    public ResponseEntity<Rule> removeFilterFromRule(
            @PathVariable("ruleId") Integer ruleId,
            @PathVariable("filterId") Integer filterId) {
        return ResponseEntity.ok(ruleService.removeFilterFromRule(ruleId, filterId));
    }
}
