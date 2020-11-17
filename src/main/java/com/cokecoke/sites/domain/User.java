package com.cokecoke.sites.domain;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(length = 30,name = "name")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uid, user.uid) &&
                Objects.equals(account, user.account) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                grander == user.grander &&
                Objects.equals(birthday, user.birthday) &&
                Objects.equals(mobile, user.mobile) &&
                Objects.equals(email, user.email) &&
                Objects.equals(lasttime, user.lasttime) &&
                Objects.equals(logincount, user.logincount) &&
                Objects.equals(validstae, user.validstae);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, account, password, name, grander, birthday, mobile, email, lasttime, logincount, validstae);
    }

}
