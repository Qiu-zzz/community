package communityselfproject.Controller;

import communityselfproject.dto.ArticleDTO;
import communityselfproject.dto.PaginationDTO;
import communityselfproject.model.User;
import communityselfproject.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author qwj
 * @version 1.0
 * @date 2019/12/26 9:57
 */
@Controller
public class ProfileController {

    @Autowired
    private ArticleService articleService;
    
    @GetMapping("/profile/{action}")
    public String profile(@PathVariable String action,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "5")Integer size,
                          Model model,
                          HttpServletRequest request){


        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return "redirect:/";
        }
        switch (action){
            case "subscribe":
                model.addAttribute("section","subscribe");
                model.addAttribute("sectionName","我的订阅");
                break;
            case "reply":
                model.addAttribute("section","reply");
                model.addAttribute("sectionName","最新回复");
                break;
            default:
                model.addAttribute("section","articles");
                model.addAttribute("sectionName","我的文章");
        }
        PaginationDTO paginationDTO = articleService.listById(user.getId(),page,size);
        model.addAttribute("articles",paginationDTO);
        return "profile";
    }
}
