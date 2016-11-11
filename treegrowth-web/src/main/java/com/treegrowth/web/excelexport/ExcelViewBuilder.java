package com.treegrowth.web.excelexport;

import com.treegrowth.service.bo.UserDetailBasic;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.google.common.io.Resources.asByteSource;
import static com.google.common.io.Resources.getResource;

@Component
public class ExcelViewBuilder extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      Workbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        //get excel template
        HSSFWorkbook selfWorkbook = new HSSFWorkbook(asByteSource(getResource("template.xls")).openBufferedStream());
        Sheet exportSheet = selfWorkbook.getSheetAt(0);

        //fill in query condition
        int conditionRowIndex = 2, conditionColumnIndex = 2;
        Object from = model.get("from");
        Object to = model.get("to");
        if (from != null || to != null) {
            exportSheet.getRow(conditionRowIndex++).getCell(conditionColumnIndex).setCellValue(Objects.toString(from, "") + " ～ " + Objects.toString(to, ""));
        }

        Object verifier = model.get("verifier");
        if (verifier != null) {
            exportSheet.getRow(conditionRowIndex++).getCell(conditionColumnIndex).setCellValue(verifier.toString());
        }

        Object posId = model.get("posId");
        if (posId != null) {
            exportSheet.getRow(conditionRowIndex).getCell(conditionColumnIndex).setCellValue(posId.toString());
        }

        // fill in data rows
        int orderCount = 1;
        int rowIndex = 8;
        /** unchecked
         * to avoid error, the key "sheetList" in inject object model type must be List<UserCouponHistory>*/
        @SuppressWarnings("unchecked")
        List<UserDetailBasic> userCouponHistories = (List<UserDetailBasic>) model.get("sheetList");
        for (UserDetailBasic userDetail : userCouponHistories) {
            int columnIndex = 1;
            Row aRow = exportSheet.createRow(rowIndex++);
            aRow.createCell(columnIndex++).setCellValue(orderCount++);
            aRow.createCell(columnIndex++).setCellValue(userDetail.getName());
            aRow.createCell(columnIndex).setCellValue(userDetail.getName());
        }


        String fileName = URLEncoder.encode("惠券统计.xls", "utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        response.setCharacterEncoding("utf-8");
        response.setContentType(getContentType());
        renderWorkbook(selfWorkbook, response);
    }

}
