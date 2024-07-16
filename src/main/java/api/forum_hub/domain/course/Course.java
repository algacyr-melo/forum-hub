package api.forum_hub.domain.course;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

@Embeddable
public class Course {

    @Column(name = "course_id")
    private String courseId;

    @Column(name = "course_name")
    private String courseName;

    public Course(CourseDto courseDto) {
        this.courseId = courseDto.courseId();
        this.courseName = courseDto.courseName();
    }

    public void update(CourseDto courseDto) {
        if (courseDto.courseId() != null) {
            this.courseId = courseDto.courseId();
        }
        if (courseDto.courseName() != null) {
            this.courseName = courseDto.courseName();
        }
    }
}
