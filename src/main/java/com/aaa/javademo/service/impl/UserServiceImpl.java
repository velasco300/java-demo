package com.aaa.javademo.service.impl;

import com.aaa.javademo.dao.UserDao;
import com.aaa.javademo.model.User;
import com.aaa.javademo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }

    @Override
    public List<User> listByUserName(String userName) {
        return userDao.findByUserNameOrderByIdDesc(userName);
    }

    @Override
    public void addMyUser(User entity) {
        Specification<User> spe = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                Integer age = entity.getAge();
                list.add(cb.equal(root.get("age"), age));
                if (age != null) {
                    list.add(cb.gt(root.get("id"), 2));
                }
                Predicate[] arr = new Predicate[list.size()];
                return cb.and(list.toArray(arr));
            }
        };
        PageRequest page = PageRequest.of(1, 10, Sort.Direction.DESC, "id");
        Page<User> all = userDao.findAll(spe, page);
        userDao.save(entity);
    }

    @Override
    public List<Map<String, Object>> listByparams(String userName, Integer age) {
        return userDao.listByparams(userName, age);
    }

}
