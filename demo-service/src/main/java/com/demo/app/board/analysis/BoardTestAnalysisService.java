package com.demo.app.board.analysis;

import com.demo.app.board.analysis.module.BoardTestResultAnalysisModule;
import com.demo.app.board.analysis.module.BoardTestResultAnalysisModule0313;
import com.demo.app.board.analysis.module.BoardTestResultImport;
import com.demo.app.board.analysis.module.BoardTestResultPositionImport;
import com.fiberhome.manufacture.common.constants.BizErrorCode;
import com.fiberhome.manufacture.common.constants.NumberConstants;
import com.fiberhome.manufacture.common.exception.BizException;
import com.fiberhome.manufacture.common.utils.easyexcel.CsvAndExcelUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 宽产测试结果分析service
 *
 * @author wangjiayang
 * @Email wangjiayang@fiberhome.com
 * @date 2023/8/8 9:57
 */
@Service
@Slf4j
public class BoardTestAnalysisService {

    public void exportOracleByFile(HttpServletResponse response, MultipartFile file) {
        String fileOrderName = file.getOriginalFilename();
        fileOrderName = fileOrderName.substring(0, fileOrderName.indexOf("."));
        List<BoardTestResultAnalysisModule> modules = new ArrayList<>();
        List<BoardTestResultImport> boardTestResults = getTestResultFormFile(file);
        final List<List<BoardTestResultImport>> partitionList = Lists.partition(boardTestResults, NumberConstants.FIVE_HUNDRED);
        for (List<BoardTestResultImport> part : partitionList) {
            for (BoardTestResultImport result : part) {
                if ("TSN".equals(result.getTsn())) {
                    continue;
                }
                log.info("TSN : " + result.getTsn());
                BoardTestResultAnalysisModule module = new BoardTestResultAnalysisModule();
                String orderNum = result.getTsn().substring(0, 8);
                module.setOrderNumber(orderNum);
                module.setTsn(result.getTsn());
                module.setMac(result.getMac());
                module.setWire(getWire(result.getTestLog()));
                module.setGroup(getGroup(result.getTestLog()));
                module.setFlashAddress(getFlashAddress(result.getTestLog()));
                module.setApplyTime(result.getDateTime());
                modules.add(module);
            }
        }
        String fileName = fileOrderName + ".xlsx";
        try {
            CsvAndExcelUtil.writeEasyExcel(response, BoardTestResultAnalysisModule.class, modules, null,
                    fileName, "");
        } catch (Exception e) {
            throw new BizException(BizErrorCode.DATA_EXCEPTION, "导出Excel数据异常！" + e);
        }
    }

    /**
     * 资产导入
     *
     * @param file file
     * @return List<BoardTestResultImport>
     */
    private List<BoardTestResultImport> getTestResultFormFile(MultipartFile file) {
        List<BoardTestResultImport> list;
        try (InputStream inputStream = file.getInputStream()) {
            // 解析 Excel
            list = CsvAndExcelUtil.readCSV(inputStream, BoardTestResultImport.class);
        } catch (Exception e) {
            throw new BizException(BizErrorCode.DATA_EXCEPTION, "解析CSV数据异常！" + e);
        }
        return list;
    }

    private String getWire(String testLog) {
        String itemCodeKey = "\"ItemCode\": \"5\",";
        int start = testLog.indexOf(itemCodeKey);
        if (start == -1) {
            log.info("ItemCode 5 is Empty ！");
            return "";
        }
        String endKey = "}";
        int end = testLog.indexOf(endKey, start);
        String positionStr = testLog.substring(start, end);
        String wireKey = "#";
        start = positionStr.indexOf(wireKey);
        positionStr = positionStr.substring(start + 1);
        end = positionStr.indexOf(wireKey);
        if (start == -1 || end == -1) {
            log.info("线体解析失败 , start = " + start + " , end = " + end);
            return "";
        }
        String wire = positionStr.substring(0, end);
        if (wire != null) {
            wire = wire.trim();
        }
        return wire.trim();
    }

    private String getGroup(String testLog) {
        String itemCodeKey = "\"ItemCode\": \"5\",";
        int start = testLog.indexOf(itemCodeKey);
        if (start == -1) {
            log.info("ItemCode 5 is Empty , , start = " + start);
            return "";
        }
        String endKey = "OtherDetail3";
        int end = testLog.indexOf(endKey, start);
        String positionStr = testLog.substring(start, end);
        String groupStartKey = "\"Group\":";
        String groupEndKey = ",";
        start = positionStr.indexOf(groupStartKey);
        end = positionStr.indexOf(groupEndKey, start);
        String groupStr = positionStr.substring(start + groupStartKey.length(), end);
        groupStr = groupStr.replaceAll("\"", "");
        return groupStr.trim();
    }

    private String getFlashAddress(String testLog) {
        String flashAddressKey = "FLASH address 0x20";
        String endKey = "FLASH address 0x24";
        int start = testLog.indexOf(flashAddressKey);
        int end = testLog.indexOf(endKey, start);
        if (start != -1 && end != -1) {
            String flashAddressStr = testLog.substring(start + flashAddressKey.length(), end);
            return flashAddressStr.trim();
        } else {
            log.error("FlashAddress解析失败：, start = " + start + " , end = " + end);
        }
        return "";
    }

    public void exportOracleByFile20240313(HttpServletResponse response, MultipartFile file) {
        String fileOrderName = file.getOriginalFilename();
        fileOrderName = fileOrderName.substring(0, fileOrderName.indexOf("."));
        List<BoardTestResultAnalysisModule0313> modules = new ArrayList<>();
        List<BoardTestResultPositionImport> boardTestResults = getTestResultFormFile0313(file);
        final List<List<BoardTestResultPositionImport>> partitionList = Lists.partition(boardTestResults, NumberConstants.FIVE_HUNDRED);
        for (List<BoardTestResultPositionImport> part : partitionList) {
            for (BoardTestResultPositionImport result : part) {
                if ("TSN".equals(result.getTsn())) {
                    continue;
                }
                log.info("TSN : " + result.getTsn());
                BoardTestResultAnalysisModule0313 module = new BoardTestResultAnalysisModule0313();
                String orderNum = result.getTsn().substring(0, 8);
                module.setOrderNumber(orderNum);
                module.setTsn(result.getTsn());
                module.setMac(result.getMac());
                module.setCTime(getCTime(result.getTestLog()));
                modules.add(module);
            }
        }
        String fileName = fileOrderName + ".xlsx";
        try {
            CsvAndExcelUtil.writeEasyExcel(response, BoardTestResultAnalysisModule0313.class, modules, null,
                    fileName, "");
        } catch (Exception e) {
            throw new BizException(BizErrorCode.DATA_EXCEPTION, "导出Excel数据异常！" + e);
        }
    }

    /**
     * 资产导入
     *
     * @param file file
     * @return List<BoardTestResultImport>
     */
    private List<BoardTestResultPositionImport> getTestResultFormFile0313(MultipartFile file) {
        List<BoardTestResultPositionImport> list;
        try (InputStream inputStream = file.getInputStream()) {
            // 解析 Excel
            list = CsvAndExcelUtil.readCSV(inputStream, BoardTestResultPositionImport.class);
        } catch (Exception e) {
            throw new BizException(BizErrorCode.DATA_EXCEPTION, "解析CSV数据异常！" + e);
        }
        return list;
    }

    private String getCTime(String testLog) {
        String itemCodeKey = "\"ItemCode\": \"1215\",";
        int start = testLog.indexOf(itemCodeKey);
        if (start == -1) {
            log.info("ItemCode 1215 is Empty , , start = " + start);
            return "";
        }
        String endKey = "TestResult";
        int end = testLog.indexOf(endKey, start);
        String positionStr = testLog.substring(start, end);
        String cTime = "\"TestValue\":";
        String groupEndKey = ",";
        start = positionStr.indexOf(cTime);
        end = positionStr.indexOf(groupEndKey, start);
        String groupStr = positionStr.substring(start + cTime.length(), end);
        groupStr = groupStr.replaceAll("\"", "");
        return groupStr.trim();
    }
}
