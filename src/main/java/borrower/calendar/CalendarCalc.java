package borrower.calendar;

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
//	public static Search date(String strDate, Advise advise) 
//	    throws ParseException {
//		Search search = new Search();
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//	    Date date = format.parse(strDate);
//	    search.setId(advise.getId());
//	    search.setType(advise.getType());
//	    search.setId1(advise.getId1());
//	    search.setName1(advise.getName1());
//	    search.setId2(advise.getId2());
//	    search.setName2(advise.getName2());
//	    search.setId3(advise.getId3());
//	    search.setName3(advise.getName3());
//	    Date sowStart1 = format.parse(advise.getSowStart1());
//	    Date sowEnd1 = format.parse(advise.getSowEnd1());
//	    Date sowStart2 = format.parse(advise.getSowStart2());
//	    Date sowEnd2 = format.parse(advise.getSowEnd2());
//	    Date sowStart3 = format.parse(advise.getSowStart3());
//	    Date sowEnd3 = format.parse(advise.getSowEnd3());
//	    Date plantingStart1 = format.parse(advise.getPlantingStart1());
//	    search.setPlantingEnd1(format.parse(advise.getPlantingEnd1()));
//	    Date plantingStart2 = format.parse(advise.getPlantingStart2());
//	    search.setPlantingEnd2(format.parse(advise.getPlantingEnd2()));
//	    Date plantingStart3 = format.parse(advise.getPlantingStart3());
//	    search.setPlantingEnd3(format.parse(advise.getPlantingEnd3()));
//	    Date harvestStart1 = format.parse(advise.getHarvestStart1());
//	    search.setHarvestEnd1(format.parse(advise.getHarvestEnd1()));
//	    Date harvestStart2 = format.parse(advise.getHarvestStart2());
//	    search.setHarvestEnd2(format.parse(advise.getHarvestEnd2()));
//	    Date harvestStart3 = format.parse(advise.getHarvestStart3());
//	    search.setHarvestEnd3(format.parse(advise.getHarvestEnd3()));
//	    
//	    int dif = calc(date, sowStart1, sowEnd1, sowStart2, sowEnd2, sowStart3, sowEnd3);
//	    
//	    Calendar cal = Calendar.getInstance();
//	    cal.setTime(sowStart1);
//	    cal.add(Calendar.DAY_OF_MONTH, dif);
//	    sowStart1 = cal.getTime();
//	    search.setSowStart1(sowStart1);
//	    cal.setTime(sowStart2);
//	    cal.add(Calendar.DAY_OF_MONTH, dif);
//	    sowStart2 = cal.getTime();
//	    search.setSowStart2(sowStart2);
//	    cal.setTime(sowStart3);
//	    cal.add(Calendar.DAY_OF_MONTH, dif);
//	    sowStart3 = cal.getTime();
//	    search.setSowStart3(sowStart3);
//	    cal.setTime(plantingStart1);
//	    cal.add(Calendar.DAY_OF_MONTH, dif);
//	    plantingStart1 = cal.getTime();
//	    search.setPlantingStart1(plantingStart1);
//	    cal.setTime(plantingStart2);
//	    cal.add(Calendar.DAY_OF_MONTH, dif);
//	    plantingStart2 = cal.getTime();
//	    search.setPlantingStart2(plantingStart2);
//	    cal.setTime(plantingStart3);
//	    cal.add(Calendar.DAY_OF_MONTH, dif);
//	    plantingStart3 = cal.getTime();
//	    search.setPlantingStart3(plantingStart3);
//	    cal.setTime(harvestStart1);
//	    cal.add(Calendar.DAY_OF_MONTH, dif);
//	    harvestStart1 = cal.getTime();
//	    search.setHarvestStart1(harvestStart1);
//	    cal.setTime(harvestStart2);
//	    cal.add(Calendar.DAY_OF_MONTH, dif);
//	    harvestStart2 = cal.getTime();
//	    search.setHarvestStart2(harvestStart2);
//	    cal.setTime(harvestStart3);
//	    cal.add(Calendar.DAY_OF_MONTH, dif);
//	    harvestStart3 = cal.getTime();
//	    search.setHarvestStart3(harvestStart3);
//		return search;
//	}
//	/**
//	 * 2つの日付の差を求めます。
//	 * java.util.Date 型の日付 date1 – date2 が何日かを返します。
//	 * 
//	 * 計算方法は以下となります。
//	 * 1.最初に2つの日付を long 値に変換します。
//	 * 　※この long 値は 1970 年 1 月 1 日 00:00:00 GMT からの
//	 * 　経過ミリ秒数となります。
//	 * 2.次にその差を求めます。
//	 * 3.上記の計算で出た数量を 1 日の時間で割ることで
//	 * 　日付の差を求めることができます。
//	 * 　※1 日 ( 24 時間) は、86,400,000 ミリ秒です。
//	 * 
//	 * @param date1    日付 java.util.Date
//	 * @param date2    日付 java.util.Date
//	 * @return    2つの日付の差
//	 */
//	public static int calc(Date date, Date sowStart1, Date sowEnd1, Date sowStart2, 
//			Date sowEnd2, Date sowStart3, Date sowEnd3) {
//	    long datetime = date.getTime();
//	    long SowStart1 = sowStart1.getTime();
//	    long SowStart2 = sowStart2.getTime();
//	    long SowStart3 = sowStart3.getTime();
//	    long one_date_time = 1000 * 60 * 60 * 24;
//	    long ret = 0;
//	    
//	    if((date.before(sowStart1) == true && date.after(sowEnd1) == true) || 
//	    		date.equals(sowStart1) == true || date.equals(sowEnd1) == true) {
//	    	long ss1 = (datetime - SowStart1) / one_date_time;
//	    	ret = ss1;
//	    } else if((date.before(sowStart2) == true && date.after(sowEnd2) == true) || 
//	    		date.equals(sowStart2) == true || date.equals(sowEnd2) == true) {
//	    	long ss2 = (datetime - SowStart2) / one_date_time;
//	    	ret = ss2;
//	    } else if((date.before(sowStart3) == true && date.after(sowEnd3) == true) || 
//	    		date.equals(sowStart3) == true || date.equals(sowEnd3) == true) {
//	    	long ss3 = (datetime - SowStart3) / one_date_time;
//		    ret = ss3; 
//	    }
//	    return (int) ret;
//	}
}
