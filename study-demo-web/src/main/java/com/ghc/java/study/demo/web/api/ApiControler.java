package com.ghc.java.study.demo.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p> </p>
 *
 * @Author : gonghongcai.
 * @Date : 2018/1/7 23:59.
 * @Description :
 */
@Controller
@RequestMapping({"api/fund/jinniu"})
public class ApiControler {

    @ResponseBody
    @RequestMapping(value = "/test")
    public String getTest(){
        return "success";
    }
}
