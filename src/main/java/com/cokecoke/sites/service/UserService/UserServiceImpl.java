package com.cokecoke.sites.service.UserService;

import com.cokecoke.sites.dao.UserDao.UserRepository;
import com.cokecoke.sites.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepositoryl;

    @Override
    public void save(User u) {
        userRepositoryl.save(u);
    }

    @Override
    public Page<User> findAll(String kw, Pageable pageable) {
        return userRepositoryl.findByKeyword(kw,pageable);
    }

    @Override
    public User findById(Integer uid) {
        return userRepositoryl.findById(uid).get();
    }

    @Override
    public void delete(User u) {
        userRepositoryl.delete(u);
    }

    @Override
    public void deleteById(Integer uid) {
        userRepositoryl.deleteById(uid);
    }

    @Override
    @Transactional
    public void deletes(List<User> users) {
        for (User u : users){
            userRepositoryl.delete(u);
        }
    }
}
