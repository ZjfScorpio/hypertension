# 项目说明

## 说明

此项目为微信h5页面的测试问卷，通过选择后得出患高血压的概率，且实现了自定义好友分享，朋友圈分享功能。可通过后台页面导出数据到excel。

## 截图

![image-20200527104010350](README.assets/image-20200527104010350.png)

![image-20200527104025200](README.assets/image-20200527104025200.png)

![image-20200527104112431](README.assets/image-20200527104112431.png)

## 分享

![image-20200530154221742](README.assets/image-20200530154221742.png)

![image-20200530154232206](README.assets/image-20200530154232206.png)

## 后台一键导出excel数据

访问地址：localhost:8081/back，用户名：admin，密码：123qwe

![image-20200527104647191](README.assets/image-20200527104647191.png)

![image-20200527104757299](README.assets/image-20200527104757299.png)



# 如何开始

> 1.创建hypertension数据库
>
> 2.导入resources下的hypertension.sql的表结构和数据
>
> 3.修改application.properties下的数据库信息为自己的数据库信息，修改appid和appsecret
>
> 4.微信公众号后台添加ip白名单，js-sdk域名
>
> 5.前台访问:localhost:8081/tets
>
> 6.后台访问:localhost:8081/back

# 技术框架

```
后端：
java,springboot,mybatis
前端：
jq,zui，微信js-sdk
```

