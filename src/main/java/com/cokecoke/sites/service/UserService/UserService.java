package com.cokecoke.sites.service.UserService;

import com.cokecoke.sites.dao.UserDao.UserRepository;
import com.cokecoke.sites.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService{

    //添加用户
    public void save(User u);

    //根据条件查询所有
    public Page<User> findAll(String kw, Pageable pageable);

    //根据 ID 查询
    public User findById(Integer uid);

    //单个删除
    public void delete(User u);

    //根据 ID 删除
    public void deleteById(Integer uid);

    //删除所有
    public void deletes(List<User> users);


}
