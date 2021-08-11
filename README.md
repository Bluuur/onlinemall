
# 用户注册

#### 简要描述

+ 用户注册接口

#### 请求URL

+ `http://localhost:8080/user/register`

#### 请求方式

+ POST

#### 参数

|参数名|必选|类型|说明|
|---|---|---|---|
|`bithday`|N|`String`|生日|
|`password`|Y|`String`|密码|
| `gender`   |N|`String`|性别|
|`uid`|N|`Number`|uid|
|`userName`|Y|`String`|用户名|

#### 参数样例

```json
{
    "userName": "xiaoming",
    "birthday": "2002 06 09",
    "password": "123123",
    "pwdagain": "123123",
    "sex": "m"
}
```

#### 返回样例

```
0 # 注册失败
1 # 注册成功
```



---

# 用户登录

#### 简要描述

+  用户登录接口

#### 请求URL

+  `http://localhost:8080/user/login`

#### 请求方式

+  POST

#### 参数

| 参数名   | 必选 | 类型   | 说明   |
| -------- | ---- | ------ | ------ |
| `userName` | Y    | `String` | 用户名 |
| `password` | Y    | `String` | 密码   |

#### 参数实例

```json
{
    "usename": "xiaoming",
    "password":"123456"
}
```

#### 状态码

```
# 成功登录,返回uid
error:1 # 用户未注册
error:2 # 用户已注册,但密码错误 
```



---

# 查看个人信息

#### 简要描述

+  获取个人信息

#### 请求URL

+  `http://121.4.100.93:8081/user/userInfo/{uid}`

#### 请求方式

+  GET

#### 参数

| 参数名 | 必选 | 类型  | 说明    |
| ------ | ---- | ----- | ------- |
| `uid`  | Y    | `Number` | 用户uid |

---

# 更改个人信息

#### 简要描述

+  修改个人信息接口

#### 请求URL

+  `http://localhost:8080/user/changeInfo/{uid}`

#### 请求方式

+  POST

#### 参数

| 参数名        | 必选 | 类型     | 说明     |
| ------------- | ---- | -------- | -------- |
| `userName`    | Y    | `String` | 用户名   |
| `gender`      | Y    | `String` | 性别     |
| `birthday`    | Y    | `String` | 生日     |
| `password`    | N    | `String` | 密码     |
| `consignee`   | N    | `String` | 收货人   |
| `phoneNumber` | Y    | `Numebr`   | 电话号码 |
| `address`     | Y    | `String` | 收货地址 |

#### 参数样例

+  请求URL:`http://localhost:8080/user/changeInfo/1`

```json
{
    "userName": "zhangsan",
    "gender": "f",
    "birthday": "2001 05 01",
    "password": "123456",
    "consignee": "lisi",
    "phoneNumber": "18712346789",
    "address": "狮子山街道1号"
}
```

#### 返回样例

```
1 # 修改成功
0 # 修改失败
```



---

# 查询所有商品

#### 简要描述

+  查询所有商品接口

#### 请求URL

+  `http://localhost:8080/good/findAll/{page}/{size}`

#### 请求方式

+  GET

#### 参数

| 参数名 | 必选 | 类型 | 说明 |
| ------ | ---- | ---- | ---- |
| `page`      | Y    | `Number`    | 显示第几页    |
|`size`|Y|`Numebr`|当页显示条数|

#### 返回样例

```json
[
    {
        "id": 1,
        "name": "索尼(sony)a1微单相机全画幅专业体育 运动 打鸟8k视频机alpha 1 ilce-1 索尼A1单机身(不含镜头)",
        "number": 78,
        "price": 48999.0,
        "imageUrl": "https://img14.360buyimg.com/n0/jfs/t1/196175/1/5784/352827/60b4c41cE372f875b/545979c01e73b7ed.jpg"
    },
    {
        "id": 2,
        "name": "小米11Ultra",
        "number": 45,
        "price": 1999.0,
        "imageUrl": "https://mi.com"
    }
]
```



---

# 添加商品到购物车

#### 简要描述

+  添加商品到购物车

#### 请求URL

+  `http://localhost:8080/good/addToCart/{uid}/{amount}`

#### 请求方式

+  POST

#### 参数

| 参数名     | 必选 | 类型     | 说明         |
| ---------- | ---- | -------- | ------------ |
| `uid`      | Y    | `Number`   | 用户uid      |
| `amount`   | Y    | `Number`    | 商品数量     |
|`good`|Y|`Object`|商品|

#### 参数样例

```json
{
    "id": 1,
    "name": "索尼(sony)a1微单相机全画幅专业体育 运动 打鸟8k视频机alpha 1 ilce-1 索尼A1单机身(不含镜头)",
    "number": 78,
    "price": 48999.00,
    "imageUrl": "https://img14.360buyimg.com/n0/jfs/t1/196175/1/5784/352827/60b4c41cE372f875b/545979c01e73b7ed.jpg"
}
```

#### 状态码
+ 1 : 添加成功
+ 0 : 库存不足



---

# 显示购物车中商品

#### 简要描述

+  查询用户购物车中商品

#### 请求URL

+  `http://localhost:8080/cart/showGood/{uid}`

#### 请求方式

+  GET

#### 参数

| 参数名 | 必选 | 类型   | 说明    |
| ------ | ---- | ------ | ------- |
| `uid`  | Y    | `Number` | 用户uid |

---

# 关键字查询商品

#### 简要描述

+  关键字查询商品

#### 请求URL

+  `http://localhost:8080/good/findByName/{name}`

#### 请求方式

+  GET

#### 参数

| 参数名 | 必选 | 类型   | 说明   |
| ------ | ---- | ------ | ------ |
| `name`   | Y    | `String` | 关键字 |


---

# 价格区间查询商品

#### 简要描述

+  通过价格区间查询商品

#### 请求URL

+  `http://localhost:8080/good/findByPrice/{min}/{max}`

#### 请求类型

+  GET

#### 参数

| 参数名 | 必选 | 类型     | 说明       |
| ------ | ---- | -------- | ---------- |
| `min`  | Y    | `Number` | 价格最小值 |
| `max`  | Y    | `Number` | 价格最大值 |



---

# id查询商品

#### 简要描述
+ 通过商品id查询商品
#### 请求URL
+ `http://localhost:8080/good/goodInfo/{id}`
#### 请求类型
+ GET
#### 参数
|参数名|必选|类型|说明|
|---|----|---|---|
|`id`|Y|`Number`|商品id|
---
# 在商品页购买
#### 简要描述
+ 直接在商品页提交购买
#### 请求URL
+ `http://localhost:8080/good/buy/{amount}`
#### 请求类型
+ POST

#### 参数

|参数名|必选|类型|说明|
|---|----|---|---|
|`amount`|Y|`Number`|购买数量|
|`good`|Y|`Object`|商品|
#### 状态码
+ 1 : 购买成功
+ 0 : 库存不足
---
# 购物车结算

#### 简要描述
+ 购物车结算功能
#### 请求URL
+ `http://localhost:8080/cart/buy`

#### 请求类型

+ POST
#### 参数
|参数名|必选|类型|说明|
|---|----|---|---|
|`carts`|Y|`Object`|购买商品信息(List<Cart>)|
#### 状态码
+ 1 : 购买成功

