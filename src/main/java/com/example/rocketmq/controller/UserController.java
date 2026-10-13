package com.example.rocketmq.controller;

import com.example.rocketmq.dao.User;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

//@RestController
//@RequestMapping("/users")
//public class UserController {
//    @PostMapping("/redict")
//    public ResponseEntity<User>create(@RequestBody User user)
//    {
//        URI location=URI.create("www.baidu.com");
//        return ResponseEntity.created(location).body(user);
//    }
//    @GetMapping("/load")
//    public ResponseEntity<Resource>downloadReport()throws IOException
//    {
//        Path path= Path.of("D:/Code/pom.xml");
//        if(!Files.isRegularFile(path)||!Files.isReadable(path))
//        {
//            return ResponseEntity.notFound().build();
//        }
//        Resource resource=new FileSystemResource(path);
//        String disposition= ContentDisposition
//                .attachment()
//                .filename("files.xml")
//                .build()
//                .toString();
//        System.out.println(disposition);
//        return ResponseEntity.ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .contentLength(Files.size(path))
//                .header(HttpHeaders.CONTENT_DISPOSITION,disposition)
//                .body(resource);
//    }
//
//    @GetMapping(value = "/json"
//    ,consumes = "application/json"
//    ,produces = "application/json")
//    public ResponseEntity<User>accept()
//    {
//        User user=new User();
//        user.setId(10);
//        user.setTime(50);
//        user.setScore(600);
//        user.setName("ganchuhao");
//        return ResponseEntity.ok(user);
//    }
//}
