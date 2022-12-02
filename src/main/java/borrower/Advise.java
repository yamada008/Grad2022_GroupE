package borrower;

import java.io.Serializable;

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
	
	public Advise() {}
	public Advise(int id, int id1, String name1, int id2, String name2, int id3, String name3) {
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
	
	void setId(int id) { this.id = id; }
	public int getId() { return this.id; }
	void setId1(int id1) { this.id1 = id1; }
	public int getId1() { return this.id1; }
	void setName1(String name1) { this.name1 = name1; }
	public String getName1() { return this.name1; }
	void setId2(int id2) { this.id2 = id2; }
	public int getId2() { return this.id2; }
	void setName2(String name2) { this.name2 = name2; }
	public String getName2() { return this.name2; }
	void setId3(int id3) { this.id3 = id3; }
	public int getId3() { return this.id3; }
	void setName3(String name3) { this.name3 = name3; }
	public String getName3() { return this.name3; }
	void setSowStart(String sowStart) { this.sowStart = sowStart; }
	public String getSowStart() { return this.sowStart; }
	void setSowEnd(String sowEnd) { this.sowEnd = sowEnd; }
	public String getSowEnd() { return this.sowEnd; }
	void setPlantingStart(String plantingStart) { this.plantingStart = plantingStart; }
	public String getPlantingStart() { return this.plantingStart; }
	void setPlantingEnd(String plantingEnd) { this.plantingEnd = plantingEnd; }
	public String getPlantingEnd() { return this.plantingEnd; }
	void setHarvestStart(String harvestStart) { this.harvestStart = harvestStart; }
	public String getHarvestStart() { return this.harvestStart; }
	void setHarvestEnd(String harvestEnd) { this.harvestEnd = harvestEnd; }
	public String getHarvestEnd() { return this.harvestEnd; }
}