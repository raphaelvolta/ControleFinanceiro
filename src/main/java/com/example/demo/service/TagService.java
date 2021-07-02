package com.example.demo.service;

import com.example.demo.domain.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TagService {
    List<Tag> getTags();
    Tag getTag(Long tagId);
    Tag postTag(Tag tag);
    Tag putTag(Tag tag, Long id);
    void deleteTag(Long id);
}
