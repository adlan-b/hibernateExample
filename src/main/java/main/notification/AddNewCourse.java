package main.notification;

import main.entity.Course;

import javax.persistence.*;

@Entity
@Table(name = "main.entity.notification.AddNewCourse")
public class AddNewCourse extends Notification {
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
