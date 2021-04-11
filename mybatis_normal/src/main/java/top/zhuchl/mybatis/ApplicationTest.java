package top.zhuchl.mybatis;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.zhuchl.mybatis.dao.entity.UserInfo;
import top.zhuchl.mybatis.dao.mapper.UserInfoMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zclys
 * @date 2021/2/26 9:30
 */
public class ApplicationTest {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationTest.class);

    /**
     * 从xml构建SqlSessionFactory (SSF)
     * @return
     */
    public SqlSessionFactory getSSFByXml() {
        String resource = "conf/mybatis/mybatis_config.xml";
        //Mybatis的工具包Resources的getResourceAsStream方法从classpath加载资源文件
        SqlSessionFactory sqlSessionFactory = null;
        try(InputStream inputStream = Resources.getResourceAsStream(resource)){
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
        return  sqlSessionFactory;
    }

    /**
     * 不使用xml文件构建SqlSessionFactory (SSF)
     * @return
     */
    public SqlSessionFactory getSSF(){
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUsername("sqlroot");
        dataSource.setPassword("sqlroot_123");
        dataSource.setUrl("jdbc:mysql://rm-2zeu9983v3gzp1e1omo.mysql.rds.aliyuncs.com:3306/mysql_test");
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("dev",transactionFactory,dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(UserInfoMapper.class);
//        configuration
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }

    @Test
    public void testSql(){
        SqlSessionFactory sqlSessionFactory = getSSFByXml();
//        SqlSessionFactory sqlSessionFactory = getSSF();
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
            testSql1(userInfoMapper);
//            testGenK(userInfoMapper);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testSql02(){
        SqlSessionFactory sqlSessionFactory = getSSFByXml();
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
//            List<UserInfo> resList = userInfoMapper.findMore(Arrays.asList("test001","test002","test003","test004"));
//            Map<String,Object> paramMap = new HashMap<>();
//            paramMap.put("id",1);
//            paramMap.put("userAcco","test001");
//            List<UserInfo> resList = userInfoMapper.findMore2(paramMap);
//             resList.forEach(System.out::println);
             UserInfo userInfo = new UserInfo();
             userInfo.setUserAcco("test002");
             userInfo.setPhoneNo("12345678901");
             userInfo.setUserName("你爸爸");
             userInfoMapper.updateUser(userInfo);
             logger.info("更新完毕");
             sqlSession.commit();
        }catch (Exception e){
            logger.error(e.getMessage());
        }

    }

    private void testSql1(UserInfoMapper userInfoMapper) throws InterruptedException {
        logger.info("接口实现对象："+userInfoMapper.getClass().getName());
        UserInfo user = new UserInfo();
        user.setUserAcco("test001");
        UserInfo userInfo = userInfoMapper.findBySimple(user);
        logger.info(userInfo.getSysId().toString());
        Thread.sleep(6000);
        logger.info("---------");
        userInfo.getAdrs().forEach(System.out::println);
//        System.out.println("-----房屋地址信息----");
//        userInfo.getAdrs().forEach(System.out::println);
//        List<UserInfo> resList = userInfoMapper.findAll();
//        resList.forEach(System.out::println);
//        Map<Integer,UserInfo> resMap = userInfoMapper.findAllRtMap();
//        System.out.println(resMap);
    }



    private void testGenK(UserInfoMapper userInfoMapper){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserAcco("test008");
        userInfo.setUserName("阿萨德");
        userInfo.setPhoneNo("11111111111");
        userInfo.setEmail("zclys06@163.com");
        userInfoMapper.save(userInfo);
        System.out.println("当前主键："+userInfo.getSysId());
    }

}
