package api.forum_hub.domain.topic;

import api.forum_hub.domain.author.AuthorDto;
import api.forum_hub.domain.course.CourseDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicCreationRequest(
    @NotBlank
    String title,

    @NotBlank
    String message,

    @NotNull
    @Valid AuthorDto author,

    @NotNull
    @Valid CourseDto course
) {
}
