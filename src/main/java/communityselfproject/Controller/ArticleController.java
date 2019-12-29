package communityselfproject.Controller;

import communityselfproject.dto.ArticleDTO;
import communityselfproject.mapper.ArticleMapper;
import communityselfproject.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author qwj
 * @version 1.0
 * @date 2019/12/27 9:10
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article/{id}")
    public String article(@PathVariable(name = "id")Integer id,Model model){
        ArticleDTO articleDTO = articleService.getById(id);
        model.addAttribute("article",articleDTO);
        return "article";
    }
}
