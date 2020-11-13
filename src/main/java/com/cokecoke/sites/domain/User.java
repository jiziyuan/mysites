package com.cokecoke.sites.domain;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column(length = 30)
    @NotNull
    private String account;

    @Column(length = 30)
    @NotNull
    private String password;

    @Column(length = 30)
    private String name;

    public  enum Sex{
        男,女
    };
    private Sex grander;

    private LocalDateTime birthday;

    @Column(length = 11)
    private String mobile;

    @Column(length = 100)
    private String email;

    private Integer lasttime; //最后登录时间

    private Integer logincount;//登录次数

    private Integer validstae;//用户是否有效


}
