package com.demo.app.test;

import com.fiberhome.manufacture.common.utils.GzipUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 测试方法
 *
 * @author wangjiayang
 * @Email wangjiayang@fiberhome.com
 * @date 2023/8/14 9:37
 */
@Slf4j
@Service
public class TestService {

    public String compressToBase64String(String str) {
        String base64Str = GzipUtils.compressToBase64String(str);
        return base64Str;
    }

    public String uncompressToString(String str) {
        String base64Str = GzipUtils.uncompressToString(str);
        return base64Str;
    }
}
