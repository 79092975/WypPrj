1、项目概述：
1.1、项目实现了对用户信息的新增、删除、修改、查询功能。
1.2、用户信息包含：id，姓名，年龄，邮箱，状态（0-无效，1-有效）。

2、数据库信息：
2.1、项目使用了H2数据库。
2.2、数据库url：jdbc:h2:~/data/user
2.3、表：user_info
2.4、项目启动时加载了两条数据（启动后可以立即查询）：
    1，'zhangsan',10,'79092975@qq.com',1
    2，'lisi',11,'79092975@qq.com',1
2.5、数据库用户名：root，密码：root

3、项目运行：
3.1、直接运行com.wypprj.WypPrjApplication后通过浏览器访问如下url即可使用相关功能。

4、REST API文档：
4.1、查询所有用户信息：
功能说明：查询所有有效的用户（state=1）
url：http://localhost:8089/user/list
示例：http://localhost:8089/user/list

4.2、根据id查询用户信息：
功能说明：根据用户id查询用户信息，如果用户不存在，返回错误提示
url：http://localhost:8089/user/query/{id}
示例：http://localhost:8089/user/query/1

4.3、新增用户信息：
功能说明：新增用户信息，新增用户id自动生成，state默认有效（state=1）
url：http://localhost:8089/user/add/{name}/{age}/{email}
示例：http://localhost:8089/user/add/wangwu/3/1058432514@qq.com

4.4、修改用户信息：
功能说明：根据用户id修改用户的姓名、年龄、邮箱、状态。如果id不存在则返回错误信息。
url：http://localhost:8089/user/put/{id}/{name}/{age}/{email}/{state}
示例：http://localhost:8089/user/put/3/wangwu/30/1058432514@qq.com/1

4.5、删除用户信息：
功能说明：根据id删除用户信息（软删除，将用户state置为0。删除后查询所有用户信息看不到已删除用户信息，但是可以通过id查询用户信息）
url：http://localhost:8089/user/del/{id}
示例：http://localhost:8089/user/del/3