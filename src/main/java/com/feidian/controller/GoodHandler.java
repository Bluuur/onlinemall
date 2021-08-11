package com.feidian.controller;

import com.feidian.mapper.CartMapper;
import com.feidian.mapper.GoodMapper;
import com.feidian.pojo.Cart;
import com.feidian.pojo.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/good")
public class GoodHandler {
    @Autowired
    private GoodMapper goodRepository;

    @Autowired
    private CartMapper cartRepository;

    /**
     * 分页查询所有商品
     *
     * @return 商品
     */


    /**
     * 添加到购物车
     *
     * @param good 传入商品对象
     * @param amount 购买数量
     * @param uid 用户uid
     * @return  执行结果
     */
    @PostMapping("/addToCart/{uid}/{amount}")
    public String addToCart(@RequestBody Good good ,@PathVariable("amount") Integer amount, @PathVariable("uid") Long uid){
        Good rest = goodRepository.getGoodById(good.getId());
        if(rest.getNumber() < amount){
            return "1";//库存不足
        }
        List<Cart> srcCarts = cartRepository.getCartByUidAndId(uid, good.getId());
        for(Cart srcCart : srcCarts) {//购物车中存在同样商品，只更改该商品的数量和总价
            if (srcCart.getUid() == uid && srcCart.getId() == good.getId()) {
                srcCart.setAmount(srcCart.getAmount() + amount);
                srcCart.setTotalPrice(srcCart.getPrice() * srcCart.getAmount());
                cartRepository.save(srcCart);
                return "0";//添加成功
            }
        }
        //购物车中不存在同样商品
        Cart cart = new Cart();
        cart.setCid((long)(cartRepository.count() + 1));
        cart.setUid(uid);
        cart.setId(good.getId());
        cart.setName(good.getName());
        cart.setAmount(amount);
        cart.setPrice(good.getPrice());
        cart.setImageUrl(good.getImageUrl());
        cart.setTotalPrice(cart.getPrice() * cart.getAmount());
        cartRepository.save(cart);
        return "0";//添加成功

    }

    /**
     * 通过关键字查找商品
     *
     * @param name 关键字
     * @return 查询结果
     */
    @GetMapping("/findByName/{name}")
    public List<Good> findByName(@PathVariable("name") String name){
        return goodRepository.getGoodByNameContains(name);
    }


    /**
     * 通过商品id查询商品信息
     *
     * @param id 商品id
     * @return 商品详情
     */
    @GetMapping("/goodInfo/{id}")
    public Good goodInfo(@PathVariable("id") Long id){
        return goodRepository.getGoodById(id);
    }

    /**
     * 通过价格区间查找商品
     *
     * @param min 价格最小值
     * @param max 价格最大值
     * @return 符合条件的商品
     */
    @GetMapping("/findByPrice/{min}/{max}")
    public List<Good> findByPrice(@PathVariable("min") Double min, @PathVariable("max") Double max){
        return goodRepository.getGoodByPriceBetween(min, max);
    }

    /**
     * 直接在商品页购买的方法
     *
     * @param good 购买的商品信息
     * @param amount 购买数量
     * @return 执行结果
     */
    @PostMapping("/buy/{amount}")
    public String buy(@RequestBody Good good, @PathVariable("amount") Integer amount){
        Good rest = goodRepository.getGoodById(good.getId());
        if (rest.getNumber() >= amount){
            good.setNumber(good.getNumber() - amount);
            goodRepository.save(good);
            return "0";//购买成功
        }else {
            return "1";//库存不足
        }
    }
}
