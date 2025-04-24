package com.demo.app.board.analysis.module;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 测试结果分析
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@HeadRowHeight(20)
public class BoardTestResultAnalysisModule0313 {

    @ExcelProperty("订单号")
    private String orderNumber;

    @ExcelProperty("TSN")
    private String tsn;

    @ExcelProperty("MAC")
    private String mac;

    @ExcelProperty("测试项")
    private String itemCode;

    @ExcelProperty("编译时间")
    private String cTime;


}
