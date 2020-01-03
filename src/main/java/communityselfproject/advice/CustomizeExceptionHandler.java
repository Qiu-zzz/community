package communityselfproject.advice;

import communityselfproject.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author qwj
 * @version 1.0
 * @date 2019/12/31 8:57
 */

@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable e, Model model){
        if (e instanceof CustomizeException){
            model.addAttribute("messages",e.getMessage());
        }else {
            model.addAttribute("messages","服务器正忙，请您稍后再试！");
        }
        return new ModelAndView("error");
    }

}
