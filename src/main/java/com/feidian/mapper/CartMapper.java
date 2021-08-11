package com.feidian.mapper;


import com.feidian.pojo.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    List<Cart> getCartByUid(Long uid);

    List<Cart> getCartByUidAndId(Long uid, Long id);

    int count();

    int save(Cart cart);
}
