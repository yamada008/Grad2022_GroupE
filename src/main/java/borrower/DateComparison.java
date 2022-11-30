package borrower;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateComparison {
	public static boolean Comparison(String strDate, String SowStart, String SowEnd, String PlantingStart, 
			String PlantingEnd) {
		try {
        	
 			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
 			Date start_date = sdFormat.parse(strDate);
 			Date sowStart = sdFormat.parse(SowStart);
 			Date sowEnd = sdFormat.parse(SowEnd);
 			Date plantingStart = sdFormat.parse(PlantingStart);
 			Date plantingEnd = sdFormat.parse(PlantingEnd);
 			
 			if(sowStart != null) {
 				if(start_date.after(sowStart) == true) {
 					if(start_date.before(sowEnd) == true) {
 						return true;
 					} else {
 						return false;
 					}
 				} else {
 					if(start_date.equals(sowStart) == true) {
 						return true;
 					} else {
 						return false;
 					}
 				}
 			} else {
 				if(start_date.after(plantingStart) == true) {
 					if(start_date.before(plantingEnd) == true) {
 						return true;
 					} else {
 						return false;
 					}
 				} else {
 					if(start_date.equals(plantingStart) == true) {
 						return true;
 					} else {
 						return false;
 					}
 				}
 			}
 			
 		} catch (ParseException e) {
 			e.printStackTrace();
 			return false;
 		}
	}
}
