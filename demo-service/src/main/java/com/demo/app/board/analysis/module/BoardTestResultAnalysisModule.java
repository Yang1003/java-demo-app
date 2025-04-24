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
public class BoardTestResultAnalysisModule {

    @ExcelProperty("订单号")
    private String orderNumber;

    @ExcelProperty("TSN")
    private String tsn;

    @ExcelProperty("MAC")
    private String mac;

    @ExcelProperty("线体")
    private String wire;

    @ExcelProperty("Group")
    private String group;

    @ExcelProperty("FLASH address 0x20")
    private String flashAddress;

    @ExcelProperty("申请时间")
    private String applyTime;


}
