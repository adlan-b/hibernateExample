package main.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "main.java.entity.LinkedPurchaseList")
public class LinkedPurchaseList {

    @EmbeddedId
    private PurchaseListKey key;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "price")
    private Integer price;

    @Column(name = "subscription_date")
    private LocalDateTime subDate;

    public LinkedPurchaseList() {
    }

    public LinkedPurchaseList(PurchaseListKey p) {
        this.key = p;
        this.studentName = key.getStudentId().getName();
        this.courseName = key.getCourseId().getName();
        this.price = key.getCourseId().getPrice();
        this.subDate = key.getStudentId().getDate();
    }


    public PurchaseListKey getKey() {
        return key;
    }

    public void setKey(PurchaseListKey key) {
        this.key = key;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDateTime getSubDate() {
        return subDate;
    }

    public void setSubDate(LocalDateTime subDate) {
        this.subDate = subDate;
    }
}
