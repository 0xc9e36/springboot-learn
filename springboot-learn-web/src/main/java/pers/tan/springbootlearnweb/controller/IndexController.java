package pers.tan.springbootlearnweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;

@Controller
public class IndexController {

    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public void exception(String type) throws Exception{
        if ("1".equals(type)) {
            throw new IllegalArgumentException("参数异常");
        } else if("2".equals(type)) {
            throw new NullPointerException("空指针异常");
        }
    }

    @RequestMapping("/hello")
    public String hello(Model m) {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "hello";
    }
}