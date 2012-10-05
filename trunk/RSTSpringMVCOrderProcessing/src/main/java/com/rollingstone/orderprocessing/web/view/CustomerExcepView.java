package com.rollingstone.orderprocessing.web.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.rollingstone.orderprocessing.model.Customer;

public class CustomerExcepView extends AbstractExcelView {

	protected void buildExcelDocument(Map model, HSSFWorkbook workbook,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<Customer> customers = (List) model.get("customers");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow header = sheet.createRow(0);
		header.createCell((short) 0).setCellValue(" Name");
		header.createCell((short) 1).setCellValue("Member Sicnce");
		header.createCell((short) 2).setCellValue("City");
		header.createCell((short) 3).setCellValue("State");
		header.createCell((short) 4).setCellValue("Balance");

		int rowNum = 1;
		for (Customer customer : customers) {
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell((short) 0).setCellValue(customer.getCustomerName());
			row.createCell((short) 1).setCellValue(
					dateFormat.format(customer.getMemberSince()));
			row.createCell((short) 2).setCellValue(
					customer.getCustomerAddress().getCity());
			row.createCell((short) 2).setCellValue(
					customer.getCustomerAddress().getState());
			row.createCell((short) 0).setCellValue(customer.getBalance());

		}

	}
}
