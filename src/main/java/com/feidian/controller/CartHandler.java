package com.feidian.controller;

import com.feidian.mapper.CartMapper;
import com.feidian.mapper.GoodMapper;
import com.feidian.pojo.Cart;
import com.feidian.pojo.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartHandler {

    @Autowired
    private CartMapper cartRepository;

    @Autowired
    private GoodMapper goodRepository;

    /**
     * 查询购物车
     *
     * @param uid 用户uid
     * @return 购物车内商品
     */
    @GetMapping("/showGood/{uid}")
    public List<Cart> showGood(@PathVariable("uid") Long uid){
        return cartRepository.getCartByUid(uid);
    }

    /**
     * 购物车结算
     *
     * @param carts 购物车信息
     * @return 执行结果
     */
    @PostMapping("/buy")
    public String buy(@RequestBody List<Cart> carts){
        for (Cart cart : carts){
            Good good = goodRepository.getGoodById(cart.getId());
            good.setNumber(good.getNumber() - cart.getAmount());//因为加入购物车时进行了库存判断,所以这里不再进行判断
            cart.setCid(-cart.getCid());
            cart.setUid(-cart.getUid());
            cartRepository.save(cart);
            goodRepository.save(good);
        }
        return "0";//购买成功
    }


}
