package borrower.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalcTest {
	public static void main(String[] args) throws ParseException {
//		CalendarDAO dao = new CalendarDAO();
		
		String name1 = "トウモロコシ";
		String name2 = "ハクサイ";
		String name3 = "null";
		String strDate = "2023-09-10";
		String SowStart1 = "2023-03-21";
		String SowEnd1 = "2023-04-20";
		String SowStart2 = "2023-08-11";
		String SowEnd2 = "2023-09-10";
		String SowStart3 = "null";
		String SowEnd3 = "null";
		String PlantingStart1 = "2023-04-21";
		String PlantingEnd1 = "2023-05-10";
		String PlantingStart2 = "2023-09-11";
		String PlantingEnd2 = "2023-10-10";
		String PlantingStart3 = "null";
		String PlantingEnd3 = "null";
		String HarvestStart1 = "2023-06-21";
		String HarvestEnd1 = "2023-07-31";
		String HarvestStart2 = "2023-11-01";
		String HarvestEnd2 = "2024-01-20";
		String HarvestStart3 = "null";
		String HarvestEnd3 = "null";
		
//		int ret = CalendarCalc.date(strDate, SowStart1, SowEnd1, SowStart2, SowEnd2, SowStart3, SowEnd3);
//		System.out.println(ret);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(strDate);
		Date sowStart1 = null;
		Date sowEnd1 = null;
		Date sowStart2 = null;
		Date sowEnd2 = null;
		Date sowStart3 = null;
		Date sowEnd3 = null;
		Date plantingStart1 = null;
	    Date plantingEnd1 = null;
	    Date plantingStart2 = null;
	    Date plantingEnd2 = null;
	    Date plantingStart3 = null;
	    Date plantingEnd3 = null;
	    Date harvestStart1 = null;
	    Date harvestEnd1 = null;
	    Date harvestStart2 = null;
	    Date harvestEnd2 = null;
	    Date harvestStart3 = null;
	    Date harvestEnd3 = null;
	    
	    List<Long> list = new ArrayList<Long>();
	    long datetime = date.getTime();
	    long sowDif1 = -1;
	    long sowDif2 = -1;
	    long sowDif3 = -1;
	    long plantingDif1 = -1;
	    long plantingDif2 = -1;
	    long plantingDif3 = -1;
	    long harvestDif1 = -1;
	    long harvestDif2 = -1;
	    long harvestDif3 = -1;
	    long sow1 = -1;
    	long sow2 = -1;
    	long sow3 = -1; 
	    long one_date_time = 1000 * 60 * 60 * 24;
	    long max = Long.MIN_VALUE;
	    
		if(SowStart1 != "null") {
			sowStart1 = format.parse(SowStart1);
			sowEnd1 = format.parse(SowEnd1);
			
			long StartTime = sowStart1.getTime();
		    long EndTime = sowEnd1.getTime();
		    sowDif1 = (EndTime - StartTime) / one_date_time;
		    sow1 = (datetime - StartTime) / one_date_time;
	    	if(sow1 >= 0 && sow1 <= sowDif1) {
	    		list.add(sow1);
		    } else {
		    	sow1 = -1;
		    }
		}
		if(SowStart2 != "null") {
			sowStart2 = format.parse(SowStart2);
		    sowEnd2 = format.parse(SowEnd2);
		    
		    long StartTime = sowStart2.getTime();
		    long EndTime = sowEnd2.getTime();
		    sowDif2 = (EndTime - StartTime) / one_date_time;
		    sow2 = (datetime - StartTime) / one_date_time;
		    if(sow2 >= 0 && sow2 <= sowDif2) {
		    	list.add(sow2);
		    } else {
		    	sow2 = -1;
		    }
		}
		if(SowStart3 != "null") {
			sowStart3 = format.parse(SowStart3);
		    sowEnd3 = format.parse(SowEnd3);
		    
		    long StartTime = sowStart3.getTime();
		    long EndTime = sowEnd3.getTime();
		    sowDif3 = (EndTime - StartTime) / one_date_time;
		    sow3 = (datetime - StartTime) / one_date_time;
		    if(sow3 >= 0 && sow3 <= sowDif3) {
		    	list.add(sow3); 
		    } else {
		    	sow3 = -1;
		    }
		}
		if(PlantingStart1 != "null") {
			plantingStart1 = format.parse(PlantingStart1);
		    plantingEnd1 = format.parse(PlantingEnd1);
		    
		    long StartTime = plantingStart1.getTime();
		    long EndTime = plantingEnd1.getTime();
		    plantingDif1 = (EndTime - StartTime) / one_date_time;
		}
	    if(PlantingStart2 != "null") {
	    	plantingStart2 = format.parse(PlantingStart2);
		    plantingEnd2 = format.parse(PlantingEnd2);
		    
		    long StartTime = plantingStart2.getTime();
		    long EndTime = plantingEnd2.getTime();
		    plantingDif2 = (EndTime - StartTime) / one_date_time;
	    }
	    if(PlantingStart3 != "null") {
	    	plantingStart3 = format.parse(PlantingStart3);
		    plantingEnd3 = format.parse(PlantingEnd3);
		    
		    long StartTime = plantingStart3.getTime();
		    long EndTime = plantingEnd3.getTime();
		    plantingDif3 = (EndTime - StartTime) / one_date_time;
	    }
	    if(HarvestStart1 != "null") {
	    	harvestStart1 = format.parse(HarvestStart1);
		    harvestEnd1 = format.parse(HarvestEnd1);
		    
		    long StartTime = harvestStart1.getTime();
		    long EndTime = harvestEnd1.getTime();
		    harvestDif1 = (EndTime - StartTime) / one_date_time;
	    }
	    if(HarvestStart2 != "null") {
	    	harvestStart2 = format.parse(HarvestStart2);
		    harvestEnd2 = format.parse(HarvestEnd2);
		    
		    long StartTime = harvestStart2.getTime();
		    long EndTime = harvestEnd2.getTime();
		    harvestDif2 = (EndTime - StartTime) / one_date_time;
	    }
	    if(HarvestStart3 != "null") {
	    	harvestStart3 = format.parse(HarvestStart3);
		    harvestEnd3 = format.parse(HarvestEnd3);
		    
		    long StartTime = harvestStart3.getTime();
		    long EndTime = harvestEnd3.getTime();
		    harvestDif3 = (EndTime - StartTime) / one_date_time;
	    }
	    
	    for(long i : list) {
	    	if(i >= max) {
				max = i;
			}
	    }
		
		Calendar cal = Calendar.getInstance();
	    
		if(sowStart1 != null) {
			cal.setTime(sowStart1);
		    if(sow1 != -1) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) sow1);
		    } else if(sowDif1 >= max) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) max);
		    }
		    int StartYear = cal.get(Calendar.YEAR);
		    int StartMonth = cal.get(Calendar.MONTH) + 1;
		    int StartDay = cal.get(Calendar.DATE);
		    cal.setTime(sowEnd1);
		    int EndYear = cal.get(Calendar.YEAR);
		    int EndMonth = cal.get(Calendar.MONTH) + 1;
		    int EndDay = cal.get(Calendar.DATE);
		    System.out.println(name1 + ", " + StartYear + ", " + StartMonth + ", " + StartDay + ", " + 
		    		EndYear + ", " + EndMonth + ", " + EndDay);
//		    dao.create(new CalendarBean(1, StartYear, StartMonth, StartDay, EndYear, EndMonth, EndDay, 
//		    		"borrower", name1, "種まき","本文"));
		} else {
			System.out.println(name1 + ", " + SowStart1 + ", " + SowEnd1);
//			dao.create(new CalendarBean(1, 0, 0, 0, 0, 0, 0, "borrower", name1, "種まき","本文"));
		}
		if(plantingStart1 != null) {
			cal.setTime(plantingStart1);
		    if(sow1 != -1 && plantingDif1 >= sow1) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) sow1);
		    } else if(plantingDif1 >= max) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) max);
		    }
		    int StartYear = cal.get(Calendar.YEAR);
		    int StartMonth = cal.get(Calendar.MONTH) + 1;
		    int StartDay = cal.get(Calendar.DATE);
		    cal.setTime(plantingEnd1);
		    int EndYear = cal.get(Calendar.YEAR);
		    int EndMonth = cal.get(Calendar.MONTH) + 1;
		    int EndDay = cal.get(Calendar.DATE);
		    System.out.println(name1 + ", " + StartYear + ", " + StartMonth + ", " + StartDay + ", " + 
		    		EndYear + ", " + EndMonth + ", " + EndDay);
//		    dao.create(new CalendarBean(2, StartYear, StartMonth, StartDay, EndYear, EndMonth, EndDay, 
//		    		"borrower", name1, "植付","本文"));
		} else {
			System.out.println(name1 + ", " + PlantingStart1 + ", " + PlantingEnd1);
//			dao.create(new CalendarBean(2, 0, 0, 0, 0, 0, 0, "borrower", name1, "植付","本文"));
		}
		if(harvestStart1 != null) {
			cal.setTime(harvestStart1);
		    if(sow1 != -1 && harvestDif1 >= sow1) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) sow1);
		    } else if(harvestDif1 >= max) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) max);
		    }
		    int StartYear = cal.get(Calendar.YEAR);
		    int StartMonth = cal.get(Calendar.MONTH) + 1;
		    int StartDay = cal.get(Calendar.DATE);
		    cal.setTime(harvestEnd1);
		    int EndYear = cal.get(Calendar.YEAR);
		    int EndMonth = cal.get(Calendar.MONTH) + 1;
		    int EndDay = cal.get(Calendar.DATE);
		    System.out.println(name1 + ", " + StartYear + ", " + StartMonth + ", " + StartDay + ", " + 
		    		EndYear + ", " + EndMonth + ", " + EndDay);
//		    dao.create(new CalendarBean(3, StartYear, StartMonth, StartDay, EndYear, EndMonth, EndDay, 
//		    		"borrower", name1, "収穫","本文"));
		} else {
			System.out.println(name1 + ", " + HarvestStart1 + ", " + HarvestEnd1);
//			dao.create(new CalendarBean(3, 0, 0, 0, 0, 0, 0, "borrower", name1, "収穫","本文"));
		}
	    
		if(sowStart2 != null) {
			cal.setTime(sowStart2);
		    if(sow2 != -1) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) sow2);
		    } else if(sowDif2 >= max) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) max);
		    }
		    int StartYear = cal.get(Calendar.YEAR);
		    int StartMonth = cal.get(Calendar.MONTH) + 1;
		    int StartDay = cal.get(Calendar.DATE);
		    cal.setTime(sowEnd2);
		    int EndYear = cal.get(Calendar.YEAR);
		    int EndMonth = cal.get(Calendar.MONTH) + 1;
		    int EndDay = cal.get(Calendar.DATE);
		    System.out.println(name2 + ", " + StartYear + ", " + StartMonth + ", " + StartDay + ", " + 
		    		EndYear + ", " + EndMonth + ", " + EndDay);
//		    dao.create(new CalendarBean(4, StartYear, StartMonth, StartDay, EndYear, EndMonth, EndDay, 
//		    		"borrower", name2, "種まき","本文"));
		} else {
			System.out.println(name2 + ", " + SowStart2 + ", " + SowEnd2);
//			dao.create(new CalendarBean(4, 0, 0, 0, 0, 0, 0, "borrower", name2, "種まき","本文"));
		}
		if(plantingStart2 != null) {
			cal.setTime(plantingStart2);
		    if(sow2 != -1 && plantingDif2 >= sow2) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) sow2);
		    } else if(plantingDif2 >= max) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) max);
		    }
		    int StartYear = cal.get(Calendar.YEAR);
		    int StartMonth = cal.get(Calendar.MONTH) + 1;
		    int StartDay = cal.get(Calendar.DATE);
		    cal.setTime(plantingEnd2);
		    int EndYear = cal.get(Calendar.YEAR);
		    int EndMonth = cal.get(Calendar.MONTH) + 1;
		    int EndDay = cal.get(Calendar.DATE);
		    System.out.println(name2 + ", " + StartYear + ", " + StartMonth + ", " + StartDay + ", " + 
		    		EndYear + ", " + EndMonth + ", " + EndDay);
//		    dao.create(new CalendarBean(5, StartYear, StartMonth, StartDay, EndYear, EndMonth, EndDay, 
//		    		"borrower", name2, "植付","本文"));
		} else {
			System.out.println(name2 + ", " + PlantingStart2 + ", " + PlantingEnd2);
//			dao.create(new CalendarBean(5, 0, 0, 0, 0, 0, 0, "borrower", name2, "植付","本文"));
		}
		if(harvestStart2 != null) {
			cal.setTime(harvestStart2);
		    if(sow2 != -1 && harvestDif2 >= sow2) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) sow2);
		    } else if(harvestDif2 >= max) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) max);
		    }
		    int StartYear = cal.get(Calendar.YEAR);
		    int StartMonth = cal.get(Calendar.MONTH) + 1;
		    int StartDay = cal.get(Calendar.DATE);
		    cal.setTime(harvestEnd2);
		    int EndYear = cal.get(Calendar.YEAR);
		    int EndMonth = cal.get(Calendar.MONTH) + 1;
		    int EndDay = cal.get(Calendar.DATE);
		    System.out.println(name2 + ", " + StartYear + ", " + StartMonth + ", " + StartDay + ", " + 
		    		EndYear + ", " + EndMonth + ", " + EndDay);
//		    dao.create(new CalendarBean(6, StartYear, StartMonth, StartDay, EndYear, EndMonth, EndDay, 
//		    		"borrower", name2, "収穫","本文"));
		} else {
			System.out.println(name2 + ", " + HarvestStart2 + ", " + HarvestEnd2);
//			dao.create(new CalendarBean(6, 0, 0, 0, 0, 0, 0, "borrower", name2, "収穫","本文"));
		}
		
		if(sowStart3 != null) {
			cal.setTime(sowStart3);
		    if(sow3 != -1) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) sow3);
		    } else if(sowDif3 >= max) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) max);
		    }
		    int StartYear = cal.get(Calendar.YEAR);
		    int StartMonth = cal.get(Calendar.MONTH) + 1;
		    int StartDay = cal.get(Calendar.DATE);
		    cal.setTime(sowEnd3);
		    int EndYear = cal.get(Calendar.YEAR);
		    int EndMonth = cal.get(Calendar.MONTH) + 1;
		    int EndDay = cal.get(Calendar.DATE);
		    System.out.println(name3 + ", " + StartYear + ", " + StartMonth + ", " + StartDay + ", " + 
		    		EndYear + ", " + EndMonth + ", " + EndDay);
//		    dao.create(new CalendarBean(7, StartYear, StartMonth, StartDay, EndYear, EndMonth, EndDay, 
//		    		"borrower", name3, "種まき","本文"));
		} else {
			System.out.println(name3 + ", " + SowStart3 + ", " + SowEnd3);
//			dao.create(new CalendarBean(7, 0, 0, 0, 0, 0, 0, "borrower", name3, "種まき","本文"));
		}
		if(plantingStart3 != null) {
			cal.setTime(plantingStart3);
		    if(sow3 != -1 && plantingDif3 >= sow3) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) sow3);
		    } else if(plantingDif3 >= max) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) max);
		    }
		    int StartYear = cal.get(Calendar.YEAR);
		    int StartMonth = cal.get(Calendar.MONTH) + 1;
		    int StartDay = cal.get(Calendar.DATE);
		    cal.setTime(plantingEnd3);
		    int EndYear = cal.get(Calendar.YEAR);
		    int EndMonth = cal.get(Calendar.MONTH) + 1;
		    int EndDay = cal.get(Calendar.DATE);
		    System.out.println(name3 + ", " + StartYear + ", " + StartMonth + ", " + StartDay + ", " + 
		    		EndYear + ", " + EndMonth + ", " + EndDay);
//		    dao.create(new CalendarBean(8, StartYear, StartMonth, StartDay, EndYear, EndMonth, EndDay, 
//		    		"borrower", name3, "植付","本文"));
		} else {
			System.out.println(name3 + ", " + PlantingStart3 + ", " + PlantingEnd3);
//			dao.create(new CalendarBean(8, 0, 0, 0, 0, 0, 0, "borrower", name3, "植付","本文"));
		}
		if(harvestStart3 != null) {
			cal.setTime(harvestStart3);
		    if(sow3 != -1 && harvestDif3 >= sow3) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) sow3);
		    } else if(harvestDif3 >= max) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) max);
		    }
		    int StartYear = cal.get(Calendar.YEAR);
		    int StartMonth = cal.get(Calendar.MONTH) + 1;
		    int StartDay = cal.get(Calendar.DATE);
		    cal.setTime(harvestEnd3);
		    int EndYear = cal.get(Calendar.YEAR);
		    int EndMonth = cal.get(Calendar.MONTH) + 1;
		    int EndDay = cal.get(Calendar.DATE);
		    System.out.println(name3 + ", " + StartYear + ", " + StartMonth + ", " + StartDay + ", " + 
		    		EndYear + ", " + EndMonth + ", " + EndDay);
//		    dao.create(new CalendarBean(9, StartYear, StartMonth, StartDay, EndYear, EndMonth, EndDay, 
//		    		"borrower", name3, "収穫","本文"));
		} else {
			System.out.println(name3 + ", " + HarvestStart3 + ", " + HarvestEnd3);
//			dao.create(new CalendarBean(9, 0, 0, 0, 0, 0, 0, "borrower", name3, "収穫","本文"));
		}
		
	}

}
