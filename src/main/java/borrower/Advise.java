package borrower;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Advise implements Serializable {
	private int id = 0;
	private int id1 = 0;
	private String name1 = null;
	private int id2 = 0;
	private String name2 = null;
	private int id3 = 0;
	private String name3 = null;
	private String sowStart = null;
	private String sowEnd = null;
	private String plantingStart = null;
	private String plantingEnd = null;
	private String harvestStart = null;
	private String harvestEnd = null;
	private boolean date = false;
	
	public Advise() {}
	public Advise(int id, int id1, String name1, int id2, String name2, int id3, String name3, boolean date) {
		this.id = id;
		this.id1 = id1;
		this.name1 = name1;
		this.id2 = id2;
		this.name2 = name2;
		this.id3 = id3;
		this.name3 = name3;
	}
	public Advise(int id, int id1, String name1, int id2, String name2, int id3, String name3, 
			String sowStart, String sowEnd, String plantingStart, String plantingEnd, 
			String harvestStart, String harvestEnd) {
		this.id = id;
		this.id1 = id1;
		this.name1 = name1;
		this.id2 = id2;
		this.name2 = name2;
		this.id3 = id3;
		this.name3 = name3;
		this.sowStart = sowStart;
		this.sowEnd = sowEnd;
		this.plantingStart = plantingStart;
		this.plantingEnd = plantingEnd;
		this.harvestStart = harvestStart;
		this.harvestEnd = harvestEnd;
	}
	
	public int getId() { return this.id; }
	public int getId1() { return this.id1; }
	public String getName1() { return this.name1; }
	public int getId2() { return this.id2; }
	public String getName2() { return this.name2; }
	public int getId3() { return this.id3; }
	public String getName3() { return this.name3; }
	public String getSowStart() { return this.sowStart; }
	public String getSowEnd() { return this.sowEnd; }
	public String getPlantingStart() { return this.plantingStart; }
	public String getPlantingEnd() { return this.plantingEnd; }
	public String getHarvestStart() { return this.harvestStart; }
	public String getHarvestEnd() { return this.harvestEnd; }
	public boolean getDate() { return this.date; }
	
	public boolean Comparison(String strDate, String SowStart, String SowEnd, String PlantingStart, String PlantingEnd) {
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
 						this.date = true;
 						return this.getDate();
 					} else {
 						this.date = false;
 						return this.getDate();
 					}
 				} else {
 					if(start_date.equals(sowStart) == true) {
 						this.date = true;
 						return this.getDate();
 					} else {
 						this.date = false;
 						return this.getDate();
 					}
 				}
 			} else {
 				if(start_date.after(plantingStart) == true) {
 					if(start_date.before(plantingEnd) == true) {
 						this.date = true;
 						return this.getDate();
 					} else {
 						this.date = false;
 						return this.getDate();
 					}
 				} else {
 					if(start_date.equals(plantingStart) == true) {
 						this.date = true;
 						return this.getDate();
 					} else {
 						this.date = false;
 						return this.getDate();
 					}
 				}
 			}
 			
 		} catch (ParseException e) {
 			e.printStackTrace();
 			this.date = false;
 			return this.getDate();
 		}
	}
}