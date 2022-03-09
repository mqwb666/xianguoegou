package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class change {
	//时间转化
	public static Date chagetime(String t){
		Date d=null;
		try {
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
			 d=sf.parse(t);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return d;
		
	}

}
