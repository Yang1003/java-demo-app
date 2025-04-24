package com.demo.app.controller.test;

import com.demo.app.test.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Hello World
 * @author ZNZZ-2
 */

@Api(tags = "Test")
@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
public class TestController {

    @Resource
    private TestService testService;

    @ApiOperation("compressToBase64String")
    @GetMapping("/compressToBase64String")
    public String compressToBase64String(@RequestParam("str") String str) {
        return testService.compressToBase64String(str);
    }

    @ApiOperation("uncompressToString")
    @GetMapping("/uncompressToString")
    public String uncompressToString(@RequestParam("str") String str) {
        return testService.uncompressToString(str);
    }

}
