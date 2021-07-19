package com.example.demo.service.impl;

import com.example.demo.domain.Filter;
import com.example.demo.domain.Rule;
import com.example.demo.domain.Tag;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.repository.RuleRepository;
import com.example.demo.service.FilterService;
import com.example.demo.service.RuleService;
import com.example.demo.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RuleServiceImpl implements RuleService {

    private final RuleRepository ruleRepository;

    private final TagService tagService;
    private final FilterService filterService;

    @Override
    public List<Rule> getRules() {
        return ruleRepository.findAll();
    }

    @Override
    public Rule getRule(Integer ruleId) {
        return ruleRepository.findById(ruleId).orElseThrow(() -> new EntityNotFoundException("Rule {0} not found.", ruleId));
    }

    @Override
    public Rule postRule(Rule rule) {
        return ruleRepository.save(rule);
    }

    @Override
    public void deleteRule(Integer ruleId) {
        ruleRepository.delete(getRule(ruleId));
    }

    @Override
    public Rule addTagToRule(Integer ruleId, Integer tagId) {
        Rule rule = getRule(ruleId);
        Tag tag = tagService.getTag(tagId);
        if(!rule.getTag().contains(tag)){
            rule.getTag().add(tag);
            rule = ruleRepository.save(rule);
        }
        return rule;
    }

    @Override
    public Rule removeTagFromRule(Integer ruleId, Integer tagId) {
        Rule rule = getRule(ruleId);
        rule.getTag().remove(tagService.getTag(tagId));
        return ruleRepository.save(rule);
    }

    @Override
    public Rule addFilterToRule(Integer ruleId, Integer filterId) {
        Rule rule = getRule(ruleId);
        Filter filter = filterService.getFilter(filterId);
        if(!rule.getFilter().contains(filter)){
            rule.getFilter().add(filter);
            rule = ruleRepository.save(rule);
        }
        return rule;
    }

    @Override
    public Rule removeFilterFromRule(Integer ruleId, Integer filterId) {
        Rule rule = getRule(ruleId);
        Filter filter = filterService.getFilter(filterId);
        rule.getFilter().remove(filter);
        return ruleRepository.save(rule);
    }
}
