package utils;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class UsePioOutExcel {
	
	/**
	 * ����excelͨ����
	 * @param list    Ҫ����������
	 * @param columnSize  ����
	 * @param response  response����
	 * @param sheetName sheet������   
	 * @param fileName  �ļ���
	 * @throws IOException
	 */
	public static void writeExcel (List list,int columnSize,HttpServletResponse response,String sheetName,String fileName,String[] cellFormatType) throws IOException {
		
		HSSFWorkbook wb = new HSSFWorkbook();  
        HSSFSheet sheet = wb.createSheet();     //��ȡһ��sheetnew String( sheetName.getBytes("GBK"),"ISO8859-1")
        wb.setSheetName(0, sheetName);
        HSSFHeader header = sheet.getHeader(); 
        header.setCenter("Center Header"); 
        
        HSSFRow row=null;
        for(int rowId=0;rowId<list.size();rowId++){
        	String[] st=(String[])list.get(rowId);
        	row = sheet.createRow(rowId);    //������
        	
      	  	for(int columnId=0; columnId < columnSize; columnId++){
      	  		HSSFCell cell = row.createCell((short)columnId);    	//������	  		
      	  		//cell.setEncoding("UTF-16");			//���õ�Ԫ����ַ������ʽ
      	  		if(cellFormatType==null || cellFormatType.length==0){	//���cellFormatType���鲻Ϊ��
      	  			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
      	  			cell.setCellValue(st[columnId]); 
      	  		}else{
      	  			if(!cellFormatType[columnId].equals("t") && rowId!=0){
      	  				cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
      	  				//�����ֵ��Ϊ��
	  					if(st[columnId]!=null){
	  					 cell.setCellValue(Double.parseDouble(st[columnId])); 
	  					}else{
	  					 cell.setCellValue(st[columnId]); 
	  					}
      	  			}else{
      	  				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
      	  				cell.setCellValue(st[columnId]); 
      	  			}
      	  		}
      	  	}
        }
        
        /**
         * �������û�ѡ�񱣴�·��
         */
        response.reset();  
		response.setHeader( "Content-Disposition", "attachment;filename="  + new String( fileName.getBytes("GBK"), "ISO8859-1"));
        wb.write(response.getOutputStream());
        response.getOutputStream().close(); 
        
	}

}
