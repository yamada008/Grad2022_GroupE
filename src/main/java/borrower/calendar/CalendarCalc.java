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
	public static List<CalendarDateBean> date(String strDate, Advise advise) 
	    throws ParseException {
		 SelectDAO dao = new SelectDAO();
		 dao.execSQL("DELETE FROM CALENDARTBL");
		
		// String型をDate型に変換する
		// 初期値を設定する
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    Date date = format.parse(strDate);
	    String name1 = advise.getName1();
	    String name2 = advise.getName2();
	    String name3 = advise.getName3();
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
	    // 開始日の時間
	    long datetime = date.getTime();
	    // 作業期間内の時間
	    long sowDif1 = -1;
	    long sowDif2 = -1;
	    long sowDif3 = -1;
	    long plantingDif1 = -1;
	    long plantingDif2 = -1;
	    long plantingDif3 = -1;
	    long harvestDif1 = -1;
	    long harvestDif2 = -1;
	    long harvestDif3 = -1;
	    // 作業開始日から選択した開始日の時間
	    long sow1 = -1;
    	long sow2 = -1;
    	long sow3 = -1; 
    	long planting1 = -1;
    	long planting2 = -1;
    	long planting3 = -1;
    	long harvest1 = -1;
    	long harvest2 = -1;
    	long harvest3 = -1;
    	// 1日の時間
	    long one_date_time = 1000 * 60 * 60 * 24;
	    // long型の最小値を設定
	    long max = Long.MIN_VALUE;
	    
	    // 種まきを行う場合
		if(advise.getSowStart1() != null) {
			sowStart1 = format.parse(advise.getSowStart1());
			sowEnd1 = format.parse(advise.getSowEnd1());
			
			long StartTime = sowStart1.getTime();
		    long EndTime = sowEnd1.getTime();
		    // 作業期間を求める
		    sowDif1 = (EndTime - StartTime) / one_date_time;
		    // 作業の開始日と選択した開始日の差を求める
		    sow1 = (datetime - StartTime) / one_date_time;
		    // 選択した開始日が作業期間内だった場合、差をリストに入れる
	    	if(sow1 >= 0 && sow1 <= sowDif1) {
	    		list.add(sow1);
		    } else {
		    	sow1 = -1;
		    }
		}
		if(advise.getSowStart2() != null) {
			sowStart2 = format.parse(advise.getSowStart2());
		    sowEnd2 = format.parse(advise.getSowEnd2());
		    
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
		if(advise.getSowStart3() != null) {
			sowStart3 = format.parse(advise.getSowStart3());
		    sowEnd3 = format.parse(advise.getSowEnd3());
		    
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
		// 植付を行う場合
		if(advise.getPlantingStart1() != null) {
			plantingStart1 = format.parse(advise.getPlantingStart1());
		    plantingEnd1 = format.parse(advise.getPlantingEnd1());
		    
		    long StartTime = plantingStart1.getTime();
		    long EndTime = plantingEnd1.getTime();
		    plantingDif1 = (EndTime - StartTime) / one_date_time;
		    planting1 = (datetime - StartTime) / one_date_time;
		    if(planting1 <= 0 || planting1 >= sow1 || planting1 >= plantingDif1) {
		    	planting1 = -1;
		    }
		}
	    if(advise.getPlantingStart2() != null) {
	    	plantingStart2 = format.parse(advise.getPlantingStart2());
		    plantingEnd2 = format.parse(advise.getPlantingEnd2());
		    
		    long StartTime = plantingStart2.getTime();
		    long EndTime = plantingEnd2.getTime();
		    plantingDif2 = (EndTime - StartTime) / one_date_time;
		    planting2 = (datetime - StartTime) / one_date_time;
		    if(planting2 <= 0 || planting2 >= sow2 || planting2 >= plantingDif2) {
		    	planting2 = -1;
		    }
	    }
	    if(advise.getPlantingStart3() != null) {
	    	plantingStart3 = format.parse(advise.getPlantingStart3());
		    plantingEnd3 = format.parse(advise.getPlantingEnd3());
		    
		    long StartTime = plantingStart3.getTime();
		    long EndTime = plantingEnd3.getTime();
		    plantingDif3 = (EndTime - StartTime) / one_date_time;
		    planting3 = (datetime - StartTime) / one_date_time;
		    if(planting3 <= 0 || planting3 >= sow3 || planting3 >= plantingDif3) {
		    	planting3 = -1;
		    }
	    }
	    // 収穫を行う場合
	    if(advise.getHarvestStart1() != null) {
	    	harvestStart1 = format.parse(advise.getHarvestStart1());
		    harvestEnd1 = format.parse(advise.getHarvestEnd1());
		    
		    long StartTime = harvestStart1.getTime();
		    long EndTime = harvestEnd1.getTime();
		    harvestDif1 = (EndTime - StartTime) / one_date_time;
		    harvest1 = (datetime - StartTime) / one_date_time;
		    if(harvest1 <= 0 || harvest1 >= sow1 || harvest1 >= harvestDif1) {
		    	harvest1 = -1;
		    }
	    }
	    if(advise.getHarvestStart2() != null) {
	    	harvestStart2 = format.parse(advise.getHarvestStart2());
		    harvestEnd2 = format.parse(advise.getHarvestEnd2());
		    
		    long StartTime = harvestStart2.getTime();
		    long EndTime = harvestEnd2.getTime();
		    harvestDif2 = (EndTime - StartTime) / one_date_time;
		    harvest2 = (datetime - StartTime) / one_date_time;
		    if(harvest2 <= 0 || harvest2 >= sow2 || harvest2 >= harvestDif2) {
		    	harvest2 = -1;
		    }
	    }
	    if(advise.getHarvestStart3() != null) {
	    	harvestStart3 = format.parse(advise.getHarvestStart3());
		    harvestEnd3 = format.parse(advise.getHarvestEnd3());
		    
		    long StartTime = harvestStart3.getTime();
		    long EndTime = harvestEnd3.getTime();
		    harvestDif3 = (EndTime - StartTime) / one_date_time;
		    harvest3 = (datetime - StartTime) / one_date_time;
		    if(harvest3 <= 0 || harvest3 >= sow3 || harvest3 >= harvestDif3) {
		    	harvest3 = -1;
		    }
	    }
	    
	    // 作業期間と開始日の差が一番大きい値を出す
	    for(long i : list) {
	    	if(i >= max) {
				max = i;
			}
	    }
		
		Calendar cal = Calendar.getInstance();
	    
		if(sowStart1 != null) {
			cal.setTime(sowStart1);
		    if(sow1 != -1) {
		    	// 開始日が作業期間内だった場合
		    	cal.add(Calendar.DAY_OF_MONTH, (int) sow1);
		    } else if(sowDif1 >= max) {
		    	// 開始日が作業期間外で差が期間内だった場合
		    	cal.add(Calendar.DAY_OF_MONTH, (int) max);
		    }
		    // int型の変換する
		    int StartYear = cal.get(Calendar.YEAR);
		    int StartMonth = cal.get(Calendar.MONTH) + 1;
		    int StartDay = cal.get(Calendar.DATE);
		    cal.setTime(sowEnd1);
		    int EndYear = cal.get(Calendar.YEAR);
		    int EndMonth = cal.get(Calendar.MONTH) + 1;
		    int EndDay = cal.get(Calendar.DATE);
		    // 取得した値を選択した作物一覧に格納する
		    CalendarBean calendar = new CalendarBean(1, StartYear, StartMonth, StartDay, EndYear, 
		    		EndMonth, EndDay, "borrower", name1, "種まき","本文");
		    dao.create(calendar);
		} else {
			// データがない場合の値を選択した作物一覧に格納する
			CalendarBean calendar = new CalendarBean(1, 0, 0, 0, 0, 0, 0, "borrower", name1, "種まき", 
					"本文");
			dao.create(calendar);
		}
		if(plantingStart1 != null) {
			cal.setTime(plantingStart1);
			// 開始日が種まき期間内で差が期間内だった場合
		    if(sow1 != -1 && plantingDif1 >= sow1) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) sow1);
		    // 差が期間内だった場合
		    } else if(plantingDif1 >= max) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) max);
		    // 開始日が植付期間内だった場合
		    } else if(planting1 != -1) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) planting1);
		    }
		    int StartYear = cal.get(Calendar.YEAR);
		    int StartMonth = cal.get(Calendar.MONTH) + 1;
		    int StartDay = cal.get(Calendar.DATE);
		    cal.setTime(plantingEnd1);
		    int EndYear = cal.get(Calendar.YEAR);
		    int EndMonth = cal.get(Calendar.MONTH) + 1;
		    int EndDay = cal.get(Calendar.DATE);
		    CalendarBean calendar = new CalendarBean(2, StartYear, StartMonth, StartDay, EndYear, 
		    		EndMonth, EndDay, "borrower", name1, "植付","本文");
		    dao.create(calendar);
		} else {
			CalendarBean calendar = new CalendarBean(2, 0, 0, 0, 0, 0, 0, "borrower", name1, "植付", 
					"本文");
			dao.create(calendar);
		}
		if(harvestStart1 != null) {
			cal.setTime(harvestStart1);
		    if(sow1 != -1 && harvestDif1 >= sow1) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) sow1);
		    } else if(harvestDif1 >= max) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) max);
		    } else if(harvest1 != -1) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) harvest1);
		    }
		    int StartYear = cal.get(Calendar.YEAR);
		    int StartMonth = cal.get(Calendar.MONTH) + 1;
		    int StartDay = cal.get(Calendar.DATE);
		    cal.setTime(harvestEnd1);
		    int EndYear = cal.get(Calendar.YEAR);
		    int EndMonth = cal.get(Calendar.MONTH) + 1;
		    int EndDay = cal.get(Calendar.DATE);
		    CalendarBean calendar = new CalendarBean(3, StartYear, StartMonth, StartDay, EndYear, 
		    		EndMonth, EndDay, "borrower", name1, "収穫","本文");
		    dao.create(calendar);
		} else {
			CalendarBean calendar = new CalendarBean(3, 0, 0, 0, 0, 0, 0, "borrower", name1, "収穫", 
					"本文");
			dao.create(calendar);
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
		    CalendarBean calendar = new CalendarBean(4, StartYear, StartMonth, StartDay, EndYear, 
		    		EndMonth, EndDay, "borrower", name2, "種まき","本文");
		    dao.create(calendar);
		} else {
			CalendarBean calendar = new CalendarBean(4,  0, 0, 0, 0, 0, 0, "borrower", name2, "種まき", 
					"本文");
			dao.create(calendar);
		}
		if(plantingStart2 != null) {
			cal.setTime(plantingStart2);
		    if(sow2 != -1 && plantingDif2 >= sow2) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) sow2);
		    } else if(plantingDif2 >= max) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) max);
		    } else if(planting2 != -1) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) planting2);
		    }
		    int StartYear = cal.get(Calendar.YEAR);
		    int StartMonth = cal.get(Calendar.MONTH) + 1;
		    int StartDay = cal.get(Calendar.DATE);
		    cal.setTime(plantingEnd2);
		    int EndYear = cal.get(Calendar.YEAR);
		    int EndMonth = cal.get(Calendar.MONTH) + 1;
		    int EndDay = cal.get(Calendar.DATE);
		    CalendarBean calendar = new CalendarBean(5, StartYear, StartMonth, StartDay, EndYear, 
		    		EndMonth, EndDay, "borrower", name2, "植付","本文");
		    dao.create(calendar);
		} else {
			CalendarBean calendar = new CalendarBean(5,  0, 0, 0, 0, 0, 0, "borrower", name2, "植付", 
					"本文");
			dao.create(calendar);
		}
		if(harvestStart2 != null) {
			cal.setTime(harvestStart2);
		    if(sow2 != -1 && harvestDif2 >= sow2) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) sow2);
		    } else if(harvestDif2 >= max) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) max);
		    } else if(harvest2 != -1) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) harvest2);
		    }
		    int StartYear = cal.get(Calendar.YEAR);
		    int StartMonth = cal.get(Calendar.MONTH) + 1;
		    int StartDay = cal.get(Calendar.DATE);
		    cal.setTime(harvestEnd2);
		    int EndYear = cal.get(Calendar.YEAR);
		    int EndMonth = cal.get(Calendar.MONTH) + 1;
		    int EndDay = cal.get(Calendar.DATE);
		    CalendarBean calendar = new CalendarBean(6, StartYear, StartMonth, StartDay, EndYear, 
		    		EndMonth, EndDay, "borrower", name2, "収穫","本文");
		    dao.create(calendar);
		} else {
			CalendarBean calendar = new CalendarBean(6,  0, 0, 0, 0, 0, 0, "borrower", name2, "収穫", 
					"本文");
			dao.create(calendar);
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
		    CalendarBean calendar = new CalendarBean(7, StartYear, StartMonth, StartDay, EndYear, 
		    		EndMonth, EndDay, "borrower", name3, "種まき","本文");
		    dao.create(calendar);
		} else {
			CalendarBean calendar = new CalendarBean(7,  0, 0, 0, 0, 0, 0, "borrower", name3, "種まき", 
					"本文");
			dao.create(calendar);
		}
		if(plantingStart3 != null) {
			cal.setTime(plantingStart3);
		    if(sow3 != -1 && plantingDif3 >= sow3) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) sow3);
		    } else if(plantingDif3 >= max) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) max);
		    } else if(planting3 != -1) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) planting3);
		    }
		    int StartYear = cal.get(Calendar.YEAR);
		    int StartMonth = cal.get(Calendar.MONTH) + 1;
		    int StartDay = cal.get(Calendar.DATE);
		    cal.setTime(plantingEnd3);
		    int EndYear = cal.get(Calendar.YEAR);
		    int EndMonth = cal.get(Calendar.MONTH) + 1;
		    int EndDay = cal.get(Calendar.DATE);
		    CalendarBean calendar = new CalendarBean(8, StartYear, StartMonth, StartDay, EndYear, 
		    		EndMonth, EndDay, "borrower", name3, "植付","本文");
		    dao.create(calendar);
		} else {
			CalendarBean calendar = new CalendarBean(8,  0, 0, 0, 0, 0, 0, "borrower", name3, "植付", 
					"本文");
			dao.create(calendar);
		}
		if(harvestStart3 != null) {
			cal.setTime(harvestStart3);
		    if(sow3 != -1 && harvestDif3 >= sow3) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) sow3);
		    } else if(harvestDif3 >= max) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) max);
		    } else if(harvest3 != -1) {
		    	cal.add(Calendar.DAY_OF_MONTH, (int) harvest3);
		    }
		    int StartYear = cal.get(Calendar.YEAR);
		    int StartMonth = cal.get(Calendar.MONTH) + 1;
		    int StartDay = cal.get(Calendar.DATE);
		    cal.setTime(harvestEnd3);
		    int EndYear = cal.get(Calendar.YEAR);
		    int EndMonth = cal.get(Calendar.MONTH) + 1;
		    int EndDay = cal.get(Calendar.DATE);
		    CalendarBean calendar = new CalendarBean(9, StartYear, StartMonth, StartDay, EndYear, 
		    		EndMonth, EndDay, "borrower", name3, "収穫","本文");
		    dao.create(calendar);
		} else {
			CalendarBean calendar = new CalendarBean(9,  0, 0, 0, 0, 0, 0, "borrower", name3, "収穫", 
					"本文");
			dao.create(calendar);
		}
		
		// 開始日の日付を取得して、リストに入れる
		List<CalendarDateBean> dateList = new ArrayList<CalendarDateBean>();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
	    int day = cal.get(Calendar.DATE);
	    CalendarDateBean bean = new CalendarDateBean(year, month, day);
	    dateList.add(bean);
	    
	    return dateList;
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
}
