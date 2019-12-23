package communityselfproject.Controller;

import communityselfproject.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author qwj
 * @version 1.0
 * @date 2019/12/20 15:30
 */
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO USER (name,account_id,token, gmt_create,gmt_modified) VALUES (#{name},#{accountId},#{token}, #{gmtCreate},#{gmtModified})")
    void insert(User user);
}
