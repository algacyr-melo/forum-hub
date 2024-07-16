package api.forum_hub.domain.topic;

import java.time.LocalDateTime;

import api.forum_hub.domain.course.Course;
import api.forum_hub.domain.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@Getter
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    @Column(unique = true)
    private String message;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Enumerated(EnumType.STRING)
    private TopicStatus status;

    @Embedded
    private User author;

    @Embedded
    private Course course;

    public Topic(TopicCreationRequest creationData) {
        this.title = creationData.title();
        this.message = creationData.message();
        this.author = new User(creationData.author());
        this.course = new Course(creationData.course());

        this.creationDate = LocalDateTime.now();
        this.status = TopicStatus.OPEN;
    }

    public void update(TopicUpdateRequest updateData) {
        if (updateData.title() != null) {
            this.title = updateData.title();
        }
        if (updateData.message() != null) {
            this.message = updateData.message();
        }
        if (updateData.author() != null) {
            this.author.update(updateData.author());
        }
        if (updateData.course() != null) {
            this.course.update(updateData.course());
        }
    }
}
