package borrower.advise;

import java.io.Serializable;

public class Advise implements Serializable {
	private int id = 0;
	private String type = null;
	private int id1 = 0;
	private String name1 = null;
	private int id2 = 0;
	private String name2 = null;
	private int id3 = 0;
	private String name3 = null;
	private String sowStart1 = null;
	private String sowEnd1 = null;
	private String sowStart2 = null;
	private String sowEnd2 = null;
	private String sowStart3 = null;
	private String sowEnd3 = null;
	private String plantingStart1 = null;
	private String plantingEnd1 = null;
	private String plantingStart2 = null;
	private String plantingEnd2 = null;
	private String plantingStart3 = null;
	private String plantingEnd3 = null;
	private String harvestStart1 = null;
	private String harvestEnd1 = null;
	private String harvestStart2 = null;
	private String harvestEnd2 = null;
	private String harvestStart3 = null;
	private String harvestEnd3 = null;
	
	public Advise() {}
	public Advise(int id, String type, int id1, String name1, int id2, String name2, int id3, String name3, 
			String sowStart1, String sowEnd1, String sowStart2, String sowEnd2, String sowStart3, 
			String sowEnd3, String plantingStart1, String plantingEnd1, String plantingStart2, 
			String plantingEnd2, String plantingStart3, String plantingEnd3, String harvestStart1, 
			String harvestEnd1, String harvestStart2, String harvestEnd2, String harvestStart3, 
			String harvestEnd3) {
		this.id = id;
		this.type = type;
		this.id1 = id1;
		this.name1 = name1;
		this.id2 = id2;
		this.name2 = name2;
		this.id3 = id3;
		this.name3 = name3;
		this.sowStart1 = sowStart1;
		this.sowEnd1 = sowEnd1;
		this.sowStart2 = sowStart2;
		this.sowEnd2 = sowEnd2;
		this.sowStart3 = sowStart3;
		this.sowEnd3 = sowEnd3;
		this.plantingStart1 = plantingStart1;
		this.plantingEnd1 = plantingEnd1;
		this.plantingStart2 = plantingStart2;
		this.plantingEnd2 = plantingEnd2;
		this.plantingStart3 = plantingStart3;
		this.plantingEnd3 = plantingEnd3;
		this.harvestStart1 = harvestStart1;
		this.harvestEnd1 = harvestEnd1;
		this.harvestStart2 = harvestStart2;
		this.harvestEnd2 = harvestEnd2;
		this.harvestStart3 = harvestStart3;
		this.harvestEnd3 = harvestEnd3;
	}
	
	void setId(int id) { this.id = id; }
	public int getId() { return this.id; }
	void setType(String type) { this.type = type; }
	public String getType() { return this.type; }
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
	void setSowStart1(String sowStart1) { this.sowStart1 = sowStart1; }
	public String getSowStart1() { return this.sowStart1; }
	void setSowEnd1(String sowEnd1) { this.sowEnd1 = sowEnd1; }
	public String getSowEnd1() { return this.sowEnd1; }
	void setSowStart2(String sowStart2) { this.sowStart2 = sowStart2; }
	public String getSowStart2() { return this.sowStart2; }
	void setSowEnd2(String sowEnd2) { this.sowEnd2 = sowEnd2; }
	public String getSowEnd2() { return this.sowEnd2; }
	void setSowStart3(String sowStart3) { this.sowStart3 = sowStart3; }
	public String getSowStart3() { return this.sowStart3; }
	void setSowEnd3(String sowEnd3) { this.sowEnd3 = sowEnd3; }
	public String getSowEnd3() { return this.sowEnd3; }
	void setPlantingStart1(String plantingStart1) { this.plantingStart1 = plantingStart1; }
	public String getPlantingStart1() { return this.plantingStart1; }
	void setPlantingEnd1(String plantingEnd1) { this.plantingEnd1 = plantingEnd1; }
	public String getPlantingEnd1() { return this.plantingEnd1; }
	void setPlantingStart2(String plantingStart2) { this.plantingStart2 = plantingStart2; }
	public String getPlantingStart2() { return this.plantingStart2; }
	void setPlantingEnd2(String plantingEnd2) { this.plantingEnd2 = plantingEnd2; }
	public String getPlantingEnd2() { return this.plantingEnd2; }
	void setPlantingStart3(String plantingStart3) { this.plantingStart3 = plantingStart3; }
	public String getPlantingStart3() { return this.plantingStart3; }
	void setPlantingEnd3(String plantingEnd3) { this.plantingEnd3 = plantingEnd3; }
	public String getPlantingEnd3() { return this.plantingEnd3; }
	void setHarvestStart1(String harvestStart1) { this.harvestStart1 = harvestStart1; }
	public String getHarvestStart1() { return this.harvestStart1; }
	void setHarvestEnd1(String harvestEnd1) { this.harvestEnd1 = harvestEnd1; }
	public String getHarvestEnd1() { return this.harvestEnd1; }
	void setHarvestStart2(String harvestStart2) { this.harvestStart2 = harvestStart2; }
	public String getHarvestStart2() { return this.harvestStart2; }
	void setHarvestEnd2(String harvestEnd2) { this.harvestEnd2 = harvestEnd2; }
	public String getHarvestEnd2() { return this.harvestEnd2; }
	void setHarvestStart3(String harvestStart3) { this.harvestStart3 = harvestStart3; }
	public String getHarvestStart3() { return this.harvestStart3; }
	void setHarvestEnd3(String harvestEnd3) { this.harvestEnd3 = harvestEnd3; }
	public String getHarvestEnd3() { return this.harvestEnd3; }
}