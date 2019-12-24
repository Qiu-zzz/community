package communityselfproject.mapper;

import communityselfproject.model.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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

    @Select("select * from article")
    List<Article> list();
}
