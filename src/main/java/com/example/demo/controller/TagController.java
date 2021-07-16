package com.example.demo.controller;

import com.example.demo.domain.Tag;
import com.example.demo.jsonDto.TagDto;
import com.example.demo.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping
    public ResponseEntity<List<Tag>> getTags(){
        return ResponseEntity.ok(tagService.getTags());
    }

    @GetMapping("/{tagId}")
    public ResponseEntity<Tag> getTagById(@PathVariable("tagId") Integer tagId){
        return ResponseEntity.ok(tagService.getTag(tagId));
    }

    @PostMapping
    public ResponseEntity<Tag> postTag(@RequestBody TagDto tagDto){
        return ResponseEntity.ok(tagService.postTag(tagDto.toDomain()));
    }

    @PutMapping("/{tagId}")
    public ResponseEntity<Tag> putTag(
            @PathVariable("tagId") Integer tagId,
            @RequestBody Tag tag){
        return ResponseEntity.ok(tagService.putTag(tag, tagId));
    }

    @DeleteMapping("/{tagId}")
    public ResponseEntity<Tag> deleteTag(@PathVariable("tagId") Integer tagId){
        tagService.deleteTag(tagId);
        return ResponseEntity.noContent().build();
    }
}
