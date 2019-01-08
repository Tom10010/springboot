package com.zht.pojo;

import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String username;
    private String sex;
    private String memo;
}
