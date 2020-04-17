package com.lqk.mvc.controller;

import com.lqk.mvc.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
@SessionAttributes(value = "user",types = {String.class})
@Controller
public class HelloController {
    public static final String SUCCESS = "success";

    @ModelAttribute
    public  void getUser(@RequestParam(value = "id",required = false) Integer id,Map<String,Object> map){
        if(id != null){
            User user = new User();
            user.setId(1);
            user.setPassword("123456");
            user.setUsername("Tom");
            user.setEmail("Tom@qq.com");
            user.setAge(12);
            System.out.println("获取的user："+user);
            map.put("user",user);
        }
    }
    @RequestMapping("/testSessionAttribute")
    public String testAttribute(User user){
        System.out.println(user);
        return SUCCESS;
    }
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String,Object> m){
        User u = new User();
        u.setUsername("lqk");
        u.setAge(17);
        u.setEmail("lqk@foxmail.com");
        m.put("user",u);
        m.put("school","sanwangling");
        return SUCCESS;
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(Map<String,Object> m){
        m.put("names", Arrays.asList("tom","jerry","mike"));
        return SUCCESS;
    }
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView m = new ModelAndView();
        m.setViewName(SUCCESS);
        m.addObject("time",new Date());
        return m;
    }
    @RequestMapping("/testServletApi")
    public String testServletApi(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("key","你的英文名字是什么");
        System.out.println(request.getAttribute("key"));
        return  SUCCESS;
    }
    @RequestMapping("/testPojo")
    public String testPojo(User user){
        System.out.println("testPojo:"+user);
        return SUCCESS;
    }
    @RequestMapping("/testRequestCookie")
    public String testRequestCookie(@CookieValue(value = "JSESSIONID")String value){
        System.out.println("JSESSIONID:"+value);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "COOKIE")String accept){
        System.out.println("COOKIE:"+accept);
        return SUCCESS;
    }
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(@RequestParam(name = "username",required = false,defaultValue = "lqk") String username) {
        System.out.println("username1:" + username);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRestPut/{id}", method = RequestMethod.PUT)
    public String testRestPut(@PathVariable Integer id) {
        System.out.println("put id : " + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRestDelete/{id}", method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable Integer id) {
        System.out.println("id : " + id);
        return "success";
    }

    @RequestMapping(value = "/testPathVariable/{id}")
    public String testPathVariable(@PathVariable(value = "id") Integer id) {
        System.out.println("id : " + id);
        return "success";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET, params = {"username"})
    public String hello() {
        return "success";
    }
}
