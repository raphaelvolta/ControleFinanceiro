package com.example.demo.service.impl;

import com.example.demo.domain.Tag;
import com.example.demo.exception.EntityAlreadyExistsException;
import com.example.demo.exception.EntityBeingUsedException;
import com.example.demo.exception.EntityNotFoundException;
import static com.example.demo.exception.Messages.INFO_BEING_USED;
import static com.example.demo.exception.Messages.TAG_ALREADY_EXISTS;
import com.example.demo.repository.TagRepository;
import com.example.demo.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
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
            throw new EntityAlreadyExistsException(TAG_ALREADY_EXISTS);
        } else {
            return tagRepository.save(tag);
        }
    }

    @Override
    public Tag putTag(Tag tag, Integer tagId) {
        getTag(tagId);
        tag.setTagId(tagId);
        return tagRepository.save(tag);
    }

    @Override
    public void deleteTag(Integer tagId) {
        Tag tag = getTag(tagId);
        tag.disable();
        tagRepository.save(tag);
    }
}
