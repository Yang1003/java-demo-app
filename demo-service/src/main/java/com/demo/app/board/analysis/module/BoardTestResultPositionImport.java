package com.demo.app.board.analysis.module;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * BRD工序补充
 *
 * @author wangjiayang
 * @Email wangjiayang@fiberhome.com
 * @date 2023/4/3 10:46
 * <p>
 */

@ApiModel("测试结果解析")
@Data
public class BoardTestResultPositionImport {

    // "TESTPOSTIONNUMBER","TESTRESULT","TSN","PERSONNAME","DATETIME","TESTLOG","MAC"

    @ApiModelProperty("TESTPOSTIONNUMBER")
    private String testPositionNum;

    @ApiModelProperty("TESTRESULT")
    private String testResult;

    @ApiModelProperty("TSN")
    private String tsn;

    @ApiModelProperty("PERSONNAME")
    private String personName;

    @ApiModelProperty("DATETIME")
    private String dateTime;

    @ApiModelProperty("TESTLOG")
    private String testLog;

    @ApiModelProperty("MAC")
    private String mac;

    @ApiModelProperty("ORDERNUM")
    private String orderNum;

}
