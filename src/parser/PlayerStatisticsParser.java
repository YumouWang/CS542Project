package parser;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PlayerStatisticsParser {
	public List<List<String>> parse() {
		List<List<String>> playerStatisticsList = new LinkedList<List<String>>();
		try {
			FileInputStream file = new FileInputStream(new File("datafiles/GameResult(player).xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row;
			XSSFCell cell;

		    int rows; // Number of rows
		    rows = sheet.getPhysicalNumberOfRows();
		    System.out.println(rows);

		    int cols = 0; // Number of columns
		    int tmp = 0;
		    
		    for(int i = 0; i < 10 || i < rows; i++) {
		        row = sheet.getRow(i);
		        if(row != null) {
		            tmp = sheet.getRow(i).getPhysicalNumberOfCells();
		            if(tmp > cols) cols = tmp;
		        }
		        System.out.println(cols);
		    }
		    
		    for(int r = 1; r < rows; r++) {
		    	List<String> playerStatistics = new LinkedList<String>();
		    	String[] str = new String[16];
		        row = sheet.getRow(r);
		        int i = 0;
		        if(row != null) {
		            for(int c = 0; c < cols; c++) {
		                cell = row.getCell((int)c);
		                if(cell != null) {
		                	if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
		                		float value =  (float) cell.getNumericCellValue();
		                		if((value % 1) == 0) {	
		                			str[i] = Integer.toString((int)value);
		                		} else {
			                		str[i] = Float.toString(value);
		                		}
		                		System.out.print(value + ",  ");
		                	} else {
		                		str[i] = cell.getStringCellValue();
		                		System.out.print(str[i] + ",  ");
		                	}
		                	playerStatistics.add(str[i]);
//		                	System.out.println("str :" + str[i]);
		                	i++;
		                }
		            }
		            System.out.println("");
		            playerStatisticsList.add(playerStatistics);
		        }
		    }
		} catch(Exception e) {
		    System.out.println(e);
		}
		return playerStatisticsList;          
	}

}
