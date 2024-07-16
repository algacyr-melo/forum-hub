package api.forum_hub.domain.topic;

import api.forum_hub.domain.course.CourseDto;
import api.forum_hub.domain.user.UserDto;
import jakarta.validation.constraints.NotNull;

public record TopicUpdateRequest
(
    @NotNull
    Long id,

    String title,
    String message,
    UserDto author,
    CourseDto course
) {
}
