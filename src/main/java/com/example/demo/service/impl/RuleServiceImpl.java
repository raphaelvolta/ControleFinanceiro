package com.example.demo.service.impl;

import com.example.demo.domain.Filter;
import com.example.demo.domain.Rule;
import com.example.demo.domain.Tag;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.IdNotFoundException;
import com.example.demo.repository.RuleRepository;
import com.example.demo.service.FilterService;
import com.example.demo.service.RuleService;
import com.example.demo.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        return ruleRepository.findById(ruleId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Rule postRule(Rule rule) {
        Tag tag = null;
        Filter filter = null;
        try{
            if(!Objects.isNull(rule.getTag().getTagId())) {
                tag = tagService.getTag(rule.getTag().getTagId());
            }

            if(!Objects.isNull(rule.getFilter().getFilterId())) {
                filter = filterService.getFilter(rule.getFilter().getFilterId());
            }
        } catch(EntityNotFoundException e){
            throw new IdNotFoundException();
        }

        rule.setFilter(filter);
        rule.setTag(tag);
        return ruleRepository.save(rule);
    }

    @Override
    public void deleteRule(Integer ruleId) {
        Rule rule =  ruleRepository.findById(ruleId).orElseThrow(EntityNotFoundException::new);
        ruleRepository.delete(rule);
    }

    @Override
    public Rule addTagToRule(Integer ruleId, Integer tagId) {
        Rule rule = ruleRepository.findById(ruleId).orElseThrow(EntityNotFoundException::new);
        return rule;
    }

    @Override
    public Rule removeTagFromRule(Integer ruleId, Integer tagId) {
        return null;
    }

    @Override
    public Rule addFilterToRule(Integer ruleId, Integer filterId) {
        return null;
    }

    @Override
    public Rule removeFilterFromRule(Integer ruleId, Integer filterId) {
        return null;
    }


}
