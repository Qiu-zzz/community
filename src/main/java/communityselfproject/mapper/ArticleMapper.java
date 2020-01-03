package communityselfproject.mapper;

import communityselfproject.dto.ArticleDTO;
import communityselfproject.model.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qwj
 * @version 1.0
 * @date 2019/12/23 14:57
 */
@Mapper
@Repository
public interface ArticleMapper {
    @Insert("insert into article (title,description,gmt_create,gmt_modified,creator,tag) " +
            "values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void  create(Article article);

    @Select("select * from article limit #{offset}, #{size}")
    List<Article> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select * from article where creator=${userId} limit #{offset}, #{size} ")
    List<Article> listById(@Param(value = "userId") Integer userId, @Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from article")
    Integer count();

    @Select("select count(1) from article where creator=#{userId}")
    Integer countByUserId(@Param(value = "userId") Integer userId);

    @Select("select * from article where id=#{id}")
    Article getById(@Param(value = "id") Integer id);

    @Update("update article set title=#{title},description=#{description},gmt_modified=#{gmtModified},tag=#{tag} where id=#{id}")
    int update(Article article);

    @Update("update article set view_count=view_count+1 where id=#{id}")
    void updateViewCount(Article article);
}
