package top.zhuchl.mybatis.dao.mapper;

import org.apache.ibatis.annotations.Param;
import top.zhuchl.mybatis.dao.entity.Address;

import java.util.List;

/**
 * @author zclys
 * @date 2021/4/10 16:22
 */
public interface AddressMapper {

    Address findOne(@Param("userAcco")String userAcco);

    List<Address> findColl(@Param("userAcco")String userAcco);
}
