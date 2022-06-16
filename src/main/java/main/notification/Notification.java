package main.notification;

import main.entity.Teacher;

import javax.persistence.*;

@Entity
@Table(name = "main.entity.notification.Notification")
@Inheritance(strategy = InheritanceType.JOINED)
public class Notification {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @Column(name = "text_notification")
    private String textNotification;
    @Column(name = "title_notification")
    private String titleNotification;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getTextNotification() {
        return textNotification;
    }















    public void setTextNotification(String textNotification) {
        this.textNotification = textNotification;
    }

    public String getTitleNotification() {
        return titleNotification;
    }

    public void setTitleNotification(String titleNotification) {
        this.titleNotification = titleNotification;
    }
}
