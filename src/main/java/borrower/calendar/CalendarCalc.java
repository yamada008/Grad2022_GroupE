package borrower.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import borrower.advise.Advise;

public class CalendarCalc {
	/**
	 * 2つの日付の差を求めます。
	 * 日付文字列 strDate1 – strDate2 が何日かを返します。
	 * 
	 * @param strDate1    日付文字列 yyyy-MM-dd
	 * @param strDate2    日付文字列 yyyy-MM-dd
	 * @return    2つの日付の差
	 * @throws ParseException 日付フォーマットが不正な場合
	 */
	public static List<Search> date(String strDate, Advise advise) 
	    throws ParseException {
		List<Search> searchList = new ArrayList<>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    Date date = format.parse(strDate);
	    int id = advise.getId();
	    String type = advise.getType();
	    int id1 = advise.getId1();
	    String name1 = advise.getName1();
	    int id2 = advise.getId2();
	    String name2 = advise.getName2();
	    int id3 = advise.getId3();
	    String name3 = advise.getName3();
	    Date sowStart1 = format.parse(advise.getSowStart1());
	    Date sowEnd1 = format.parse(advise.getSowEnd1());
	    Date sowStart2 = format.parse(advise.getSowStart2());
	    Date sowEnd2 = format.parse(advise.getSowEnd2());
	    Date sowStart3 = format.parse(advise.getSowStart3());
	    Date sowEnd3 = format.parse(advise.getSowEnd3());
	    Date plantingStart1 = format.parse(advise.getPlantingStart1());
	    Date plantingEnd1 = format.parse(advise.getPlantingEnd1());
	    Date plantingStart2 = format.parse(advise.getPlantingStart2());
	    Date plantingEnd2 = format.parse(advise.getPlantingEnd2());
	    Date plantingStart3 = format.parse(advise.getPlantingStart3());
	    Date plantingEnd3 = format.parse(advise.getPlantingEnd3());
	    Date harvestStart1 = format.parse(advise.getHarvestStart1());
	    Date harvestEnd1 = format.parse(advise.getHarvestEnd1());
	    Date harvestStart2 = format.parse(advise.getHarvestStart2());
	    Date harvestEnd2 = format.parse(advise.getHarvestEnd2());
	    Date harvestStart3 = format.parse(advise.getHarvestStart3());
	    Date harvestEnd3 = format.parse(advise.getHarvestEnd3());
	    
	    int dif = calc(date, sowStart1, sowEnd1, sowStart2, sowEnd2, sowStart3, sowEnd3);
	    
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(sowStart1);
	    cal.add(Calendar.DAY_OF_MONTH, dif);
	    sowStart1 = cal.getTime();
	    cal.setTime(sowStart2);
	    cal.add(Calendar.DAY_OF_MONTH, dif);
	    sowStart2 = cal.getTime();
	    cal.setTime(sowStart3);
	    cal.add(Calendar.DAY_OF_MONTH, dif);
	    sowStart3 = cal.getTime();
	    cal.setTime(plantingStart1);
	    cal.add(Calendar.DAY_OF_MONTH, dif);
	    plantingStart1 = cal.getTime();
	    cal.setTime(plantingStart2);
	    cal.add(Calendar.DAY_OF_MONTH, dif);
	    plantingStart2 = cal.getTime();
	    cal.setTime(plantingStart3);
	    cal.add(Calendar.DAY_OF_MONTH, dif);
	    plantingStart3 = cal.getTime();
	    cal.setTime(harvestStart1);
	    cal.add(Calendar.DAY_OF_MONTH, dif);
	    harvestStart1 = cal.getTime();
	    cal.setTime(harvestStart2);
	    cal.add(Calendar.DAY_OF_MONTH, dif);
	    harvestStart2 = cal.getTime();
	    cal.setTime(harvestStart3);
	    cal.add(Calendar.DAY_OF_MONTH, dif);
	    harvestStart3 = cal.getTime();
	    
	    Search search = new Search(id, type, id1, name1, id2, name2, id3, name3, sowStart1, 
				sowEnd1, sowStart2, sowEnd2, sowStart3, sowEnd3, plantingStart1, plantingEnd1, 
				plantingStart2, plantingEnd2, plantingStart3, plantingEnd3, harvestStart1, 
				harvestEnd1, harvestStart2, harvestEnd2, harvestStart3, harvestEnd3);
		searchList.add(search);
	    
	    return searchList;
	}
	/**
	 * 2つの日付の差を求めます。
	 * java.util.Date 型の日付 date1 – date2 が何日かを返します。
	 * 
	 * 計算方法は以下となります。
	 * 1.最初に2つの日付を long 値に変換します。
	 * 　※この long 値は 1970 年 1 月 1 日 00:00:00 GMT からの
	 * 　経過ミリ秒数となります。
	 * 2.次にその差を求めます。
	 * 3.上記の計算で出た数量を 1 日の時間で割ることで
	 * 　日付の差を求めることができます。
	 * 　※1 日 ( 24 時間) は、86,400,000 ミリ秒です。
	 * 
	 * @param date1    日付 java.util.Date
	 * @param date2    日付 java.util.Date
	 * @return    2つの日付の差
	 */
	public static int calc(Date date, Date sowStart1, Date sowEnd1, Date sowStart2, 
			Date sowEnd2, Date sowStart3, Date sowEnd3) {
	    long datetime = date.getTime();
	    long SowStart1 = sowStart1.getTime();
	    long SowStart2 = sowStart2.getTime();
	    long SowStart3 = sowStart3.getTime();
	    long one_date_time = 1000 * 60 * 60 * 24;
	    long ret = 0;
	    
	    if((date.before(sowStart1) == true && date.after(sowEnd1) == true) || 
	    		date.equals(sowStart1) == true || date.equals(sowEnd1) == true) {
	    	long SS1 = (datetime - SowStart1) / one_date_time;
	    	ret = SS1;
	    } else if((date.before(sowStart2) == true && date.after(sowEnd2) == true) || 
	    		date.equals(sowStart2) == true || date.equals(sowEnd2) == true) {
	    	long SS2 = (datetime - SowStart2) / one_date_time;
	    	ret = SS2;
	    } else if((date.before(sowStart3) == true && date.after(sowEnd3) == true || 
	    		date.equals(sowStart3) == true || date.equals(sowEnd3) == true)) {
	    	long SS3 = (datetime - SowStart3) / one_date_time;
		    ret = SS3; 
	    }
	    return (int) ret;
	}
}
