package pers.tan.springbootlearnquickstart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/index/index")
    public String index() {
        return "index";
    }
}
