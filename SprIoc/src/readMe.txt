配置文件
    spring --》mybatis--》UserDao

    spring 配置 数据库信息，“集成mybatis对象” 自定义对象
    mybatis  mybatis 类的对象别名，下层资源路径 UserDao
    UserDao 编写数据库执行结构 ，并对应其同名接口 namespace


        spring  mybatis 对象 自动加载 UserDao 对象，即 接口 UserDao 不需要创建实现类

