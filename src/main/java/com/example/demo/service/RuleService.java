package com.example.demo.service;

import com.example.demo.domain.Rule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RuleService {
    List<Rule> getRules();
    Rule getRule(Integer ruleId);
    Rule postRule(Rule rule);
    void deleteRule(Integer ruleId);

    Rule addTagToRule(Integer ruleId, Integer tagId);
    Rule removeTagFromRule(Integer ruleId, Integer tagId);

    Rule addFilterToRule(Integer ruleId, Integer filterId);
    Rule removeFilterFromRule(Integer ruleId, Integer filterId);
}
