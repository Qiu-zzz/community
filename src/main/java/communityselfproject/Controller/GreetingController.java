package communityselfproject.Controller;

import communityselfproject.dto.ArticleDTO;
import communityselfproject.dto.PaginationDTO;
import communityselfproject.mapper.ArticleMapper;
import communityselfproject.mapper.UserMapper;
import communityselfproject.model.Article;
import communityselfproject.model.User;
import communityselfproject.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class GreetingController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5")Integer size)
    {

        PaginationDTO paginationDTO = articleService.list(page, size);
        model.addAttribute("articles",paginationDTO);
        return "index";
    }
}
