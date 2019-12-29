package communityselfproject.mapper;

import communityselfproject.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author qwj
 * @version 1.0
 * @date 2019/12/20 15:30
 */
@Mapper
@Repository
public interface UserMapper {
    @Insert("INSERT INTO USER (name,account_id,token, gmt_create,gmt_modified,avatar_url) VALUES (#{name},#{accountId},#{token}, #{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id")Integer id);

    @Select("select * from user where account_id = #{accountId}")
    User findByAccountId(@Param("accountId")Integer accountId);

    @Update("update user set name=#{name},token=#{token},gmt_modified=#{gmtModified},avatar_url=#{avatarUrl} where account_id=#{accountId}")
    void update(User user);
}
