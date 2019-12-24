package communityselfproject.service;

import communityselfproject.dto.ArticleDTO;
import communityselfproject.mapper.ArticleMapper;
import communityselfproject.mapper.UserMapper;
import communityselfproject.model.Article;
import communityselfproject.model.User;
import org.apache.catalina.mbeans.MBeanUtils;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qwj
 * @version 1.0
 * @date 2019/12/24 14:32
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserMapper userMapper;
    public List<ArticleDTO> list() {
        List<Article> articleList = articleMapper.list();
        List<ArticleDTO> articleDTOList = new ArrayList<>();
        for (Article article : articleList){
            User user = userMapper.findById(article.getCreator());
            ArticleDTO articleDTO = new ArticleDTO();
            BeanUtils.copyProperties(article,articleDTO);
            articleDTO.setUser(user);
            articleDTOList.add(articleDTO);
        }
        return articleDTOList;
    }
}
