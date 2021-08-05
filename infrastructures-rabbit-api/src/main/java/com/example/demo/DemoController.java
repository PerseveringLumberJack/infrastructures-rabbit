package com.example.demo;

import com.example.toolkit.ExceptionUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/demo")
@Api("Demo Controller")
public class DemoController {




    @ResponseBody
    @GetMapping("/query")
    @ApiOperation(value = "query")
    public void query() {

        ExceptionUtils.throwException("测试自定义异常");

    }

    @ResponseBody
    @GetMapping(value = "unknown")
    @ApiOperation(value = "unknownException")
    public void unknownException() {
        int i = 0;
        int b = 1/i;
    }

}
