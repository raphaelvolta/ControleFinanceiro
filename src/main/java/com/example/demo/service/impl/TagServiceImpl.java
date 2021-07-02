package com.example.demo.service.impl;

import com.example.demo.domain.Tag;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.repository.TagRepository;
import com.example.demo.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag getTag(Long tagId) {
        return tagRepository.getById(tagId);
    }

    @Override
    public Tag postTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag putTag(Tag tag, Long id) {
        tagRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        tag.setId(id);
        return tagRepository.save(tag);
    }

    @Override
    public void deleteTag(Long id) {
        Tag tag = tagRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        tagRepository.delete(tag);
    }
}
