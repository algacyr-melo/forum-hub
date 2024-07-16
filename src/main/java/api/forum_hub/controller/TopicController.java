package api.forum_hub.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import api.forum_hub.domain.topic.Topic;
import api.forum_hub.domain.topic.TopicCreationRequest;
import api.forum_hub.domain.topic.TopicDetailResponse;
import api.forum_hub.domain.topic.TopicRepository;
import api.forum_hub.domain.topic.TopicUpdateRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topic")
public class TopicController {

    private TopicRepository topicRepository;

    @Autowired
    public TopicController(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicDetailResponse> createTopic(
        @Valid @RequestBody
        TopicCreationRequest creationData, UriComponentsBuilder uriComponentsBuilder
    ) {
        Topic topic = new Topic(creationData);
        topicRepository.save(topic);

        var location = uriComponentsBuilder
            .path("/medicos/{id}")
            .buildAndExpand(topic.getId())
            .toUri();

        return ResponseEntity.created(location).body(new TopicDetailResponse(topic));
    }

    @GetMapping
    public ResponseEntity<Page<TopicDetailResponse>> getTopics(
        @PageableDefault(size = 10, sort = {"creationDate"})
        Pageable pagination
    ) {
        var page = topicRepository.findAll(pagination).map(TopicDetailResponse::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDetailResponse> getTopicDetail(@PathVariable Long id) {
        Topic topic = topicRepository.getReferenceById(id);

        return ResponseEntity.ok(new TopicDetailResponse(topic));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<TopicDetailResponse> updateTopic(
        @Valid @RequestBody
        TopicUpdateRequest updateData
    ) {
        Topic topic = topicRepository.getReferenceById(updateData.id());
        topic.update(updateData);

        return ResponseEntity.ok(new TopicDetailResponse(topic));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        topicRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
