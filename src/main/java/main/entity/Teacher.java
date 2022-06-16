package main.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import main.notification.Notification;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "Teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int salary;
    private int age;

    @Setter(AccessLevel.NONE)
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "teachers")
    private List<Course> courseList;

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public void removeCourse(Course course) {
        courseList.remove(course);

    }
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Notification> notifications;

    @Override
    public String toString() {
        return "name= '" + name + '\'' +
                ", salary= " + salary +
                ", age= " + age +
                '}';
    }
}
