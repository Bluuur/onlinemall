package com.feidian.mapper;


import com.feidian.pojo.Good;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodMapper {
    List<Good> getGoodByNameContains(String str);

    Good getGoodById(Long id);

    List<Good> getGoodByPriceBetween(Double min, Double max);

    int save(Good good);
}
