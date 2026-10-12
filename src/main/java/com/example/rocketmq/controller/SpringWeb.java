package com.example.rocketmq.controller;

import com.example.rocketmq.dao.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class SpringWeb {

    @GetMapping("/home")
    public String home(@RequestHeader(name = "Accept",defaultValue = "zh-CN") String language,
                       @RequestHeader(name="Accept-Charset",defaultValue = "Charset") String charset)
    {
        return language+":"+charset;
    }

    @GetMapping("/servlet")
    public String servlet(HttpServletRequest request, HttpServletResponse response)
    {
        try {
            response.getWriter().write("DASDAS");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return "Hello";
    }

    @PostMapping("/user")
    public ResponseEntity<User>create(@RequestBody User user)
    {
        return ResponseEntity.accepted().body(user);
    }

}
