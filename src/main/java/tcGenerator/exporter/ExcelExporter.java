package tcGenerator.exporter;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import tcGenerator.model.TestCase;

import java.io.FileOutputStream;
import java.util.List;

public class ExcelExporter {

	public static void export(List<TestCase> testCases, String filePath) {

		try (Workbook workbook = new XSSFWorkbook()) {

			Sheet sheet = workbook.createSheet("TestCases");

			Row header = sheet.createRow(0);

			String[] columns = { "ID", "Title", "Type", "Steps", "Expected Result", "Priority" };

			for (int i = 0; i < columns.length; i++) {
				header.createCell(i).setCellValue(columns[i]);
			}

			int rowNum = 1;

			for (TestCase tc : testCases) {

				Row row = sheet.createRow(rowNum++);

				row.createCell(0).setCellValue(tc.getId());
				row.createCell(1).setCellValue(tc.getTitle());
				row.createCell(2).setCellValue(tc.getType());
				row.createCell(3).setCellValue(String.join("\n", tc.getSteps()));
				row.createCell(4).setCellValue(tc.getExpectedResult());
				row.createCell(5).setCellValue(tc.getPriority());
			}

			for (int i = 0; i < columns.length; i++) {
				sheet.autoSizeColumn(i);
			}

			try (FileOutputStream fos = new FileOutputStream(filePath)) {
				workbook.write(fos);
			}

			System.out.println("Excel exported successfully to: " + filePath);

		} catch (Exception e) {
			throw new RuntimeException("Failed to export Excel", e);
		}
	}
}
