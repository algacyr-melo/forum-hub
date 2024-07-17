package api.forum_hub.domain.topic;

import api.forum_hub.domain.author.AuthorDto;
import api.forum_hub.domain.course.CourseDto;
import jakarta.validation.constraints.NotNull;

public record TopicUpdateRequest
(
    @NotNull
    Long id,

    String title,
    String message,
    AuthorDto author,
    CourseDto course
) {
}
