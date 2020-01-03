package communityselfproject.Controller;

import communityselfproject.exception.CustomizeErrorCode;
import communityselfproject.exception.CustomizeException;
import communityselfproject.mapper.ArticleMapper;
import communityselfproject.mapper.UserMapper;
import communityselfproject.model.Article;
import communityselfproject.model.User;
import communityselfproject.model.UserExample;
import communityselfproject.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author qwj
 * @version 1.0
 * @date 2019/12/23 11:01
 */
@Controller
public class PublishController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleService articleService;

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name = "id") Integer id,
                       Model model) {
        Article article = articleMapper.getById(id);
        model.addAttribute("title", article.getTitle());
        model.addAttribute("description", article.getDescription());
        model.addAttribute("tag", article.getTag());
        model.addAttribute("id", article.getId());
        return "publish";
    }

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("id") Integer id,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            HttpServletRequest request,
            Model model
    ) {

        if (title == null || title == "") {
            model.addAttribute("error", "标题不能为空");
            return "/publish";
        }
        if (description == null || description == "") {
            model.addAttribute("error", "描述不能为空");
            return "/publish";
        }
        if (tag == null || tag == "") {
            model.addAttribute("error", "标签不能为空");
            return "/publish";
        }

        List<User> user = (List<User>) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "登录错误");
            return "/publish";
        }
        Article article = new Article();
        article.setTitle(title);
        article.setDescription(description);
        article.setTag(tag);
        article.setCreator(user.get(0).getId());
        article.setId(id);

        if (id == null) {
            articleMapper.create(article);
        }else {
            UserExample example = new UserExample();
            example.createCriteria().andIdEqualTo(articleMapper.getById(id).getCreator());
            List<User> articleUsers = userMapper.selectByExample(example);
            if (!user.get(0).getId().equals(articleUsers.get(0).getId())) {
                model.addAttribute("error", "权限错误");
                return "/publish";
            }
            article.setGmtModified(System.currentTimeMillis());
            int updated = articleMapper.update(article);
            if (updated != 1){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
        }
        return "redirect:/";
    }
}
