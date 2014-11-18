package parser;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entity.Game;

public class GameParser {
	public ArrayList<Game> parse() {
		ArrayList<Game> gameList = new ArrayList<Game>();
		try {
			FileInputStream file = new FileInputStream(new File("datafiles/game.xlsx"));
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
		    	String[] str = new String[7];
		        row = sheet.getRow(r);
		        int i = 0;
		        if(row != null) {
		            for(int c = 0; c < cols; c++) {
		                cell = row.getCell((int)c);
		                if(cell != null) {
		                	if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
		                		int value = (int) cell.getNumericCellValue();
		                		str[i] = Integer.toString(value);
//		                		System.out.print(value + ",  ");
		                	} else {
		                		str[i] = cell.getStringCellValue();
//		                		System.out.print(str[i] + ",  ");
		                	}
		                	i++;
		                }
		            }
		            //System.out.println("");
		            Game game = new Game(Integer.parseInt(str[0]), str[1], str[2], str[3]);            
		            gameList.add(game);
		        }
		    }
		} catch(Exception e) {
		    System.out.println(e);
		}
		return gameList;          
	}
}
