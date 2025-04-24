package com.demo.app.controller.test;

import com.demo.app.test.OCRService;
import com.demo.app.test.TestService;

import net.sourceforge.tess4j.TesseractException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * ocr
 * @author ZNZZ-2
 */

@Api(tags = "ocr")
@RestController
@RequestMapping("/ocr")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
public class OCRController {

    @Resource
    private OCRService ocrService;

    @PostMapping(value = "/recognize", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String recognizeImage(@RequestParam("file") MultipartFile file) throws TesseractException, IOException {

        // 调用OcrService中的方法进行文字识别
        return ocrService.recognizeText(file);
    }

}
