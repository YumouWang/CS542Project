package parser;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entity.Player;

public class PlayerParser {
	public ArrayList<Player> parse() {
		ArrayList<Player> playerList = new ArrayList<Player>();
		try {
			FileInputStream file = new FileInputStream(new File("datafiles/player.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row;
			XSSFCell cell;

		    int rows; // Number of rows
		    rows = sheet.getPhysicalNumberOfRows();

		    int cols = 0; // Number of columns
		    int tmp = 0;
		    
		    for(int i = 0; i < 10 || i < rows; i++) {
		        row = sheet.getRow(i);
		        if(row != null) {
		            tmp = sheet.getRow(i).getPhysicalNumberOfCells();
		            if(tmp > cols) cols = tmp - 1;
		        }
		    }
		    
		    for(int r = 1; r < rows; r++) {
		    	System.out.println("Row:" + rows);
		    	String[] str = new String[7];
		        row = sheet.getRow(r);
		        int i = 0;
		        if(row != null) {
		            for(int c = 0; c < cols; c++) {
		            	System.out.println("cols:" + cols);
		                cell = row.getCell((int)c);
		                if(cell != null) {
		                	if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
		                		int value = (int) cell.getNumericCellValue();
		                		str[i] = Integer.toString(value);
		                		System.out.print(value + ",  ");
		                	} else {
		                		str[i] = cell.getStringCellValue();
		                		System.out.print(str[i] + ",  ");
		                	}
		                	i++;
		                }
		            }
		            System.out.println("");
		            Player player = new Player(str[0], str[1], Integer.parseInt(str[2]), str[3], Integer.parseInt(str[4]), str[5], Integer.parseInt(str[6]));
		            playerList.add(player);
		        }
		    }
		} catch(Exception e) {
		    System.out.println(e);
		}
		return playerList;      
	}
}
