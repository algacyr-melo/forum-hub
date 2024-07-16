package api.forum_hub.domain.topic;

import java.time.LocalDateTime;

import api.forum_hub.domain.course.Course;
import api.forum_hub.domain.course.CourseDto;
import api.forum_hub.domain.user.User;
import api.forum_hub.domain.user.UserDto;

public record TopicDetailResponse
(
    Long id,
    String title,
    String message,
    LocalDateTime creationDate,
    TopicStatus status,
    User author,
    Course course
) {
    public TopicDetailResponse(Topic topic) {
        this(
            topic.getId(),
            topic.getTitle(),
            topic.getMessage(),
            topic.getCreationDate(),
            topic.getStatus(),
            topic.getAuthor(),
            topic.getCourse()
        );
    }
}
