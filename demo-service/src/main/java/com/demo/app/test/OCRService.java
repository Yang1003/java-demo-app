package com.demo.app.test;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 测试方法
 *
 * @author wangjiayang
 * @Email wangjiayang@fiberhome.com
 * @date 2023/8/14 9:37
 */
@Slf4j
@Service
public class OCRService {

    @Resource
    private Tesseract tesseract;

    /**
     * 识别图片中的文字
     * @param imageFile 图片文件
     * @return 文字信息
     */
    public String recognizeText(MultipartFile imageFile) throws TesseractException, IOException {

        // 转换
        InputStream sbs = new ByteArrayInputStream(imageFile.getBytes());
        BufferedImage bufferedImage = ImageIO.read(sbs);
        // 对图片进行文字识别
        return tesseract.doOCR(bufferedImage);
    }
}
