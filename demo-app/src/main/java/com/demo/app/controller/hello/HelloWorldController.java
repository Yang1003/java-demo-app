package com.demo.app.controller.hello;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * Hello World
 * @author ZNZZ-2
 */

@Api(tags = "Hello World!")
@RestController
@RequestMapping("/hello")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
public class HelloWorldController {

    @ApiOperation("Hello World")
    @GetMapping("/world")
    public String helloWorld() {
        return "Hello World!";
    }

}
