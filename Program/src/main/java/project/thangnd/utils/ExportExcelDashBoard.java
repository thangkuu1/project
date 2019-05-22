package project.thangnd.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import project.thangnd.dtos.TransactionDetailDto;
import project.thangnd.models.Transaction_detail;

public class ExportExcelDashBoard extends AbstractXlsView{

//	@Override
//	protected void buildExcelDocument(Map model, HSSFWorkbook workbook, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		// TODO Auto-generated method stub
//		HSSFSheet excelSheet = workbook.createSheet("Thống kê");
//		List<Transaction_detail> list_trans = (List<Transaction_detail>) model.get("list_trans");
//		setExcelHeader(excelSheet);
//		setExcelRows(excelSheet, list_trans);
//		
//		System.out.println("vao day roi");
//	}
	public void setExcelHeader(HSSFSheet excelSheet){
		HSSFRow excelHeader = excelSheet.createRow(0);
		excelHeader.createCell(0).setCellValue("Mã món ăn");
		excelHeader.createCell(1).setCellValue("Tên Món ăn");
		excelHeader.createCell(2).setCellValue("Số lương đã bán");
	}
	
	public void setExcelRows(HSSFSheet excelSheet, List<TransactionDetailDto> list){
		int record = 1;
		for(TransactionDetailDto trans : list){
			HSSFRow excelRow = excelSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(trans.getId_food());
			excelRow.createCell(1).setCellValue(trans.getName_food());
			excelRow.createCell(2).setCellValue(trans.getQuantum());
		}
	}
	@Override
	protected void buildExcelDocument(Map model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HSSFSheet excelSheet = (HSSFSheet) workbook.createSheet("Thống kê");
		List<TransactionDetailDto> list_trans = (List<TransactionDetailDto>) model.get("list_trans");
		setExcelHeader(excelSheet);
		setExcelRows(excelSheet, list_trans);
		
		System.out.println("vao day roi");
		
	}

}
