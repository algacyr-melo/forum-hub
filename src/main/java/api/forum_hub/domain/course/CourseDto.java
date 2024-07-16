package api.forum_hub.domain.course;

import jakarta.validation.constraints.NotBlank;

public record CourseDto(
    @NotBlank
    String courseId,

    @NotBlank
    String courseName
) {
    public CourseDto(CourseDto courseDto) {
        this(courseDto.courseId(), courseDto.courseName());
    }
}
