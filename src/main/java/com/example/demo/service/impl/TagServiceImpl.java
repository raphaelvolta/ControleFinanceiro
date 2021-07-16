package com.example.demo.service.impl;

import com.example.demo.domain.Tag;
import com.example.demo.exception.EntityAlreadyExistsException;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.repository.TagRepository;
import com.example.demo.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag getTag(Integer tagId) {
        return tagRepository.findById(tagId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Tag postTag(Tag tag) {
        Optional<Tag> exists = tagRepository.findByDescription(tag.getDescription());
        if(exists.isPresent()){
            throw new EntityAlreadyExistsException("Tag with this description already exists");
        } else {
            return tagRepository.save(tag);
        }
    }

    @Override
    public Tag putTag(Tag tag, Integer tagId) {
        tagRepository.findById(tagId).orElseThrow(EntityNotFoundException::new);
        tag.setTagId(tagId);
        return tagRepository.save(tag);
    }

    @Override
    public void deleteTag(Integer tagId) {
        Tag tag = tagRepository.findById(tagId).orElseThrow(EntityNotFoundException::new);
        tagRepository.delete(tag);
    }
}
