package project.thangnd.utils;

import java.text.Normalizer;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import project.thangnd.dtos.TransactionDetailDto;
import project.thangnd.models.User;

public class ExportPdfBill extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Paragraph par_header = new Paragraph("HOA DON");
		par_header.setAlignment(Element.ALIGN_CENTER);
		document.add(par_header);
		User user = (User) model.get("user_bill");
		String address = (String) model.get("address_bill");
		PdfPTable table1 = new PdfPTable(3);
		table1.setWidthPercentage(100.0f);
		table1.setWidths(new float[] {3.0f, 2.0f, 2.0f});
		table1.setSpacingBefore(10);
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		
		PdfPCell cell = new PdfPCell();
		cell.setPadding(5);
		List<TransactionDetailDto> list = (List<TransactionDetailDto>) model.get("trans_detail_bill");
		cell.setPhrase(new Phrase("Ten khach hang", font));
		table1.addCell(cell);
		cell.setPhrase(new Phrase("So dien thoai", font));
		table1.addCell(cell);
		cell.setPhrase(new Phrase("Dia chi", font));
		table1.addCell(cell);
		cell.setPhrase(new Phrase(user.getUsername(), font));
		table1.addCell(cell);
		cell.setPhrase(new Phrase(user.getPhone(), font));
		table1.addCell(cell);
		cell.setPhrase(new Phrase(removeAccent(address), font));
		table1.addCell(cell);

		document.add(table1);
		Paragraph para_detail = new Paragraph("Chi tiet hoa don");
		para_detail.setAlignment(Element.ALIGN_CENTER);
		document.add(para_detail);
		
		PdfPTable table2 = new PdfPTable(3);
		table2.setWidthPercentage(100.0f);
		table2.setWidths(new float[] {3.0f, 2.0f, 2.0f});
		table2.setSpacingBefore(10);
		
		cell.setPhrase(new Phrase("Ma don hang", font));
		table2.addCell(cell);
		cell.setPhrase(new Phrase("Mon an", font));
		table2.addCell(cell);
		cell.setPhrase(new Phrase("So luong", font));
		table2.addCell(cell);
		for(TransactionDetailDto trans: list){
			table2.addCell(String.valueOf(trans.getTransaction_id()));
			table2.addCell(removeAccent(trans.getName_food()));
			table2.addCell(trans.getQuantum());
		}
		table2.addCell(cell);
		document.add(table2);
		String price_bill = (String) model.get("price_bill");
		Paragraph par_price = new Paragraph("tong tien: " + price_bill);
		par_price.setAlignment(Element.ALIGN_RIGHT);
		document.add(par_price);
	}
	
	 public static String removeAccent(String s) {
		  
		  String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		  Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		  return pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replace("đ", "");
		 }

}
