package main.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import main.notification.AddNewCourse;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int duration;

    @Enumerated(EnumType.STRING)
//    @Column(columnDefinition = "enum('DESIGN','PROGRAMMING','MARKETING','MANAGEMENT','BUSINESS')")
    @Column(name = "type", columnDefinition = "enum")
    private CourseType type;
    private String description;

    @Setter(AccessLevel.NONE)
    @ManyToMany
    @JoinTable(name = "CourseTeacher",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private List<Teacher> teachers ;

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        teacher.addCourse(this);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
        teacher.removeCourse(this);

    }
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<AddNewCourse> addNewCourses;



    @Column(name = "students_count", nullable = true)
    private Integer studentsCount;
    @Column(name = "price", nullable = true)
    private Integer price;
    @Column(name = "price_per_hour")
    private float pricePerHour;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id.course")
    private List<Subscription> subscriptions;

    @OneToMany(mappedBy = "key.courseId")
    private List<LinkedPurchaseList> linkedPurchaseLists;

    @Setter(AccessLevel.NONE)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Subscriptions", joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private List<Student> students;

    @Override
    public String toString() {
        return "main.java.entity.Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                ", pricePerHour=" + pricePerHour +
                '}';
    }
}
