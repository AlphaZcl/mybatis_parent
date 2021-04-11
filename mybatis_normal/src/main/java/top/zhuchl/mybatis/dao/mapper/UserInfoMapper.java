package top.zhuchl.mybatis.dao.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import top.zhuchl.mybatis.dao.entity.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * @author zclys
 * @date 2021/2/26 14:49
 */
public interface UserInfoMapper {

//    @Select("SELECT * FROM `user_info` WHERE SYS_ID = #{id} ")
    UserInfo findOne(@Param("id") Integer id);

    UserInfo findOneByU(@Param("id") Integer id,@Param("userAcco") String userAcco);

    UserInfo findOneByMultiP(@Param("id") Integer id,String userAcco,UserInfo userInfo);

    List<UserInfo> findAll();

    @MapKey("sysId")
    Map<Integer,UserInfo> findAllRtMap();

    void add(UserInfo userInfo);

    void save(UserInfo userInfo);

    UserInfo findUserInfoWithAddr(@Param("id") Integer id,@Param("userAcco") String userAcco);

    UserInfo findCollection(@Param("userAcco")String userAcco);

    UserInfo findBySimple(UserInfo userInfo);

    List<UserInfo> findMore(@Param("params") List<String> params);

    List<UserInfo> findMore2(Map<String,Object> paramMap);

    void updateUser(UserInfo userInfo);
}
