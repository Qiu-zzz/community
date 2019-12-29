package communityselfproject.service;

import communityselfproject.dto.ArticleDTO;
import communityselfproject.dto.PaginationDTO;
import communityselfproject.mapper.ArticleMapper;
import communityselfproject.mapper.UserMapper;
import communityselfproject.model.Article;
import communityselfproject.model.User;
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

    public PaginationDTO list(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer count = articleMapper.count();
        Integer totalPage;
        if (count % size == 0) {
            totalPage = count / size;
        } else {
            totalPage = (count / size) + 1;
        }
        paginationDTO.setPagination(count,totalPage, page);
        page = page < 1 ? 1 : page;
        page = page > paginationDTO.getTotalPage() ? paginationDTO.getTotalPage() : page;

        Integer offset = size * (page - 1);
        if (offset<0){
            offset = 1;
        }
        List<Article> articleList = articleMapper.list(offset, size);
        List<ArticleDTO> articleDTOList = new ArrayList<>();


        for (Article article : articleList) {
            User user = userMapper.findById(article.getCreator());
            ArticleDTO articleDTO = new ArticleDTO();
            BeanUtils.copyProperties(article, articleDTO);
            articleDTO.setUser(user);
            articleDTOList.add(articleDTO);
        }
        paginationDTO.setArticleDTOS(articleDTOList);


        return paginationDTO;
    }

    public PaginationDTO listById(Integer userId, Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer count = articleMapper.countByUserId(userId);
        Integer totalPage;
        if (count % size == 0) {
            totalPage = count / size;
        } else {
            totalPage = (count / size) + 1;
        }

        paginationDTO.setPagination(count,totalPage, page);
        page = page < 1 ? 1 : page;
        page = page > paginationDTO.getTotalPage() ? paginationDTO.getTotalPage() : page;

        Integer offset = size * (page - 1);
        if (offset<0){
            offset = 1;
        }

        List<Article> articleList = articleMapper.listById(userId,offset, size);
        List<ArticleDTO> articleDTOList = new ArrayList<>();


        for (Article article : articleList) {
            User user = userMapper.findById(article.getCreator());
            ArticleDTO articleDTO = new ArticleDTO();
            BeanUtils.copyProperties(article, articleDTO);
            articleDTO.setUser(user);
            articleDTOList.add(articleDTO);
        }
        paginationDTO.setArticleDTOS(articleDTOList);


        return paginationDTO;
    }

    public ArticleDTO getById(Integer id) {
        Article article = articleMapper.getById(id);
        ArticleDTO articleDTO = new ArticleDTO();
        BeanUtils.copyProperties(article,articleDTO);
        User user = userMapper.findById(article.getCreator());
        articleDTO.setUser(user);
        return articleDTO;
    }
}
