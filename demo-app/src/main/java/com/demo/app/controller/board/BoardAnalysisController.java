package com.demo.app.controller.board;

import com.demo.app.board.analysis.BoardTestAnalysisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 宽产测试结果数据分析
 * @author ZNZZ-2
 */

@Api(tags = "宽产-测试数据分析")
@RestController
@RequestMapping("/board/analysis")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
public class BoardAnalysisController {

    @Resource
    private BoardTestAnalysisService boardTestAnalysisService;

    @ApiOperation("宽产测试结果导出")
    @PostMapping("/boardTestResultExportByFile")
    public void boardTestResultExport(HttpServletResponse response, @RequestParam MultipartFile file) {
        boardTestAnalysisService.exportOracleByFile(response, file);
    }

    @ApiOperation("宽产测试结果导出")
    @PostMapping("/20240313/boardTestResultExportByFile")
    public void boardTestResultExport20240313(HttpServletResponse response, @RequestParam MultipartFile file) {
        boardTestAnalysisService.exportOracleByFile20240313(response, file);
    }

}
