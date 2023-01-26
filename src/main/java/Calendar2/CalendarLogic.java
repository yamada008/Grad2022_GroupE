package Calendar2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarLogic {
	//カレンダーインスタンスを生成するメソッド(int...は可変長引数)
	public List<CalendarBean> createMyCalendar() {
		//マイカレンダーインスタンス生成
		CalendarBean mc=new CalendarBean();
		//現在日時でカレンダーインスタンス生成
		Calendar cal=Calendar.getInstance();
		//2つの引数が来ていたら
//		if(args.length==2) {
//			//最初の引数で年を設定
//			cal.set(Calendar.YEAR, args[0]);
//			//次の引数で月を設定
//			cal.set(Calendar.MONTH, args[1]-1);
//		}
		
		List<CalendarBean> CalendarList = new ArrayList<CalendarBean>();
		
//		マイカレンダーに年を設定
		mc.setd_year(cal.get(Calendar.YEAR));
		//マイカレンダーの元号の設定
//		if(mc.getd_year() > 2018) {
//			mc.setGengou("令和"+(mc.getd_year()-2018));
//		}else if(mc.getd_year() >1988 ) {
//			mc.setGengou("平成"+(mc.getYear()-1988));
//		}else if(mc.getd_year() > 1925) {
//			mc.setGengou("昭和"+(mc.getYear()-1925));
//		}else if(mc.getYear() > 1911) {
//			mc.setGengou("大正"+(mc.getYear()-1911));
//		}else {
//			mc.setGengou(""+mc.getd_year());
//		}
		//マイカレンダーに月の設定
		mc.setd_month(cal.get(Calendar.MONTH)+1);
		mc.setd_dat(cal.get(Calendar.DATE));
		for(int i = 1;i <= 12;i++) {
			//その月の1日が何曜日かを調べる為に日付を1日にする
			cal.set(Calendar.DATE, 1);
			//カレンダーの最初の空白の数
			int before=cal.get(Calendar.DAY_OF_WEEK)-1;
			//カレンダーの日付の数
			int daysCount=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			//その月の最後の日が何曜日かを調べるために日付を最終日にする
			cal.set(Calendar.DATE, daysCount);
			//最後の日後の空白の数
			int after=7-cal.get(Calendar.DAY_OF_WEEK);
			//すべての要素数
			int total=before+daysCount+after;
			for(int d = 1;d <= total;d++) {
				
					for(int bef = 1; bef <= before;bef++) {
						String str = "";
						CalendarBean calendar = new CalendarBean(i, str);
						CalendarList.add(calendar);
					}
					for(int count = 1;count <= daysCount;count++) {
						String str = String.valueOf(count);
						CalendarBean calendar = new CalendarBean(i, str);
						CalendarList.add(calendar);
					}
					for(int af = 1;af <= after;af++) {
						String str = "";
						CalendarBean calendar = new CalendarBean(i, str);
						CalendarList.add(calendar);
				}
			}
		}
			


		//その要素数を幅7個の配列に入れていった場合何行になるか
//		int rows=total/7;
//		//その行数で2次元配列を生成
//		String[][] data=new String[rows][7];
//		//今見ているカレンダーが今月かどうかを調べるために、この瞬間の日付情報をもつもう一つのインスタンス作成しておく
////		Calendar now=Calendar.getInstance();
//		for(int i=0;i<rows;i++) {
//			for(int j=0;j<7;j++) {
//				if(i==0 && j<before || i==rows-1 && j>=(7-after)) {
//					//カレンダーの前後に入る空白の部分は空文字
//					data[i][j]="";
//				}else {
//					//カウンター変数と実際の日付の変換
//					int date=i*7+j+1 - before;
//					//配列に日付を入れる
//					data[i][j]=String.valueOf(date);
//					//今作業しているマイカレンダーが今月のカレンダーだったら今日の日付の先頭に*を付与する
//					if(now.get(Calendar.DATE)== date && now.get(Calendar.MONTH)==mc.getMonth()-1  && now.get(Calendar.YEAR)==mc.getYear()) {
//						data[i][j]="*"+data[i][j];
//					}
//				}
//			}
//		}
		//作成した2次元配列をマイカレンダーにセットする。
//		mc.setData(data);
		return CalendarList;
	}
}