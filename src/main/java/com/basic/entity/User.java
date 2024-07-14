package com.basic.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name="user_name")
    private String userName;

    @Column(name="user_city")
    private String userCity;

    @Column(name="user_marks")
    private Float userMarks;
}
