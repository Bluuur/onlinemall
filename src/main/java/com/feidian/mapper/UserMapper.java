package com.feidian.mapper;


import com.feidian.pojo.Cart;
import com.feidian.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User getUserByUid(Long uid);

    User getUserByUserName(String userName);

    List<User> findAll();

    int count();

    int save(Cart cart);

    int save(User user);

}
