package com.weifj.controller;

import com.weifj.annotation.LoginRequired;
import com.weifj.annotation.MyLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class TestController {

    @LoginRequired
    @GetMapping("/sourceA")
    public String sourceA() {
        return "sourceA资源";
    }

    @GetMapping("/sourceB")
    public String sourceB() {
        return "sourceB";
    }

    @MyLog
    @GetMapping("sourceC/{source_name}")
    public String sourceC(@PathVariable("source_name")String sourceName){
        return "您正在访问sourceC资源";
    }

}
