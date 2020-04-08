拿来做练习，各种功能测试
1.RestTemplate  http请求

2.整合mybatis  
   第一步 @MapperScan("com.cyzs.springbootentirey.mapper")这个包下的接口都会生成一个现实类，
          这样就不用在每个接口上面添加@Mapper注解了。
   第二步 创建UserMapper，并且在resource下创建和UserMapper包名一致的文件夹，并且编写UserMapper.xml
   第三步 创建mybatis的配置文件类，创建Druid数据源
   第四步 创建UserController，启动应用

3.分页
  `<dependency>
       <groupId>com.github.pagehelper</groupId>
       <artifactId>pagehelper-spring-boot-starter</artifactId>
       <version>1.2.10</version>
   </dependency>`
     配置
    `pagehelper:
       helper-dialect: mysql
       reasonable: true
       support-methods-arguments: true
       params: count=countSql`
      用法
     `PageHelper.startPage(pageNum, pageSize);
      List<User> page = userMapper.findPage();
      PageInfo<User> userPageInfo = new PageInfo<>(page);
      return userPageInfo;`  
     
4.