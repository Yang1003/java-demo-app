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
public class BoardTestResultImport {

    @ApiModelProperty("MAC")
    private String mac;

    @ApiModelProperty("TSN")
    private String tsn;

    @ApiModelProperty("LINE")
    private String line;

    @ApiModelProperty("DATETIME")
    private String dateTime;

    @ApiModelProperty("testLog")
    private String testLog;

    @ApiModelProperty("orderNum")
    private String orderNum;

}
