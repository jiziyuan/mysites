package com.cokecoke.sites.dao.UserDao;

import com.cokecoke.sites.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {


    void saveAll(User user);

    Page<User> findAll(Pageable pageable);

    List<User> findAll();

    void delete(User user);

    void deleteById(Integer integer);

    void deleteAll(List list);
}
