package main.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PurchaseListTest {
    private String studentName;
    private String courseName;
    private int price;
    private LocalDateTime subscriptionDate;

}
