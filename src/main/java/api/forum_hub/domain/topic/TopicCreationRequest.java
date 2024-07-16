package api.forum_hub.domain.topic;

import api.forum_hub.domain.course.CourseDto;
import api.forum_hub.domain.user.UserDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicCreationRequest(
    @NotBlank
    String title,

    @NotBlank
    String message,

    @NotNull
    @Valid UserDto author,

    @NotNull
    @Valid CourseDto course
) {
}
