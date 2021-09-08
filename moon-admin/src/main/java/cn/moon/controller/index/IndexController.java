package cn.moon.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kell
 * @date 2020-05-31 11:45
 */
@Controller
public class IndexController {

    @GetMapping(path = "/")
    public String index() {
        return "index";
    }
}
