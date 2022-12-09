package borrower.calendar;

import java.io.Serializable;
import java.util.Date;

public class Search implements Serializable {
	private int id = 0;
	private String type = null;
	private int id1 = 0;
	private String name1 = null;
	private int id2 = 0;
	private String name2 = null;
	private int id3 = 0;
	private String name3 = null;
	private Date sowStart1 = null;
	private Date sowEnd1 = null;
	private Date sowStart2 = null;
	private Date sowEnd2 = null;
	private Date sowStart3 = null;
	private Date sowEnd3 = null;
	private Date plantingStart1 = null;
	private Date plantingEnd1 = null;
	private Date plantingStart2 = null;
	private Date plantingEnd2 = null;
	private Date plantingStart3 = null;
	private Date plantingEnd3 = null;
	private Date harvestStart1 = null;
	private Date harvestEnd1 = null;
	private Date harvestStart2 = null;
	private Date harvestEnd2 = null;
	private Date harvestStart3 = null;
	private Date harvestEnd3 = null;
	
	public Search() {}
	public Search(int id, String type, int id1, String name1, int id2, String name2, int id3, String name3, 
			Date sowStart1, Date sowEnd1, Date sowStart2, Date sowEnd2, Date sowStart3, Date sowEnd3, 
			Date plantingStart1, Date plantingEnd1, Date plantingStart2, Date plantingEnd2, 
			Date plantingStart3, Date plantingEnd3, Date harvestStart1, Date harvestEnd1, 
			Date harvestStart2, Date harvestEnd2, Date harvestStart3, Date harvestEnd3) {
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
	void setSowStart1(Date sowStart1) { this.sowStart1 = sowStart1; }
	public Date getSowStart1() { return this.sowStart1; }
	void setSowEnd1(Date sowEnd1) { this.sowEnd1 = sowEnd1; }
	public Date getSowEnd1() { return this.sowEnd1; }
	void setSowStart2(Date sowStart2) { this.sowStart2 = sowStart2; }
	public Date getSowStart2() { return this.sowStart2; }
	void setSowEnd2(Date sowEnd2) { this.sowEnd2 = sowEnd2; }
	public Date getSowEnd2() { return this.sowEnd2; }
	void setSowStart3(Date sowStart3) { this.sowStart3 = sowStart3; }
	public Date getSowStart3() { return this.sowStart3; }
	void setSowEnd3(Date sowEnd3) { this.sowEnd3 = sowEnd3; }
	public Date getSowEnd3() { return this.sowEnd3; }
	void setPlantingStart1(Date plantingStart1) { this.plantingStart1 = plantingStart1; }
	public Date getPlantingStart1() { return this.plantingStart1; }
	void setPlantingEnd1(Date plantingEnd1) { this.plantingEnd1 = plantingEnd1; }
	public Date getPlantingEnd1() { return this.plantingEnd1; }
	void setPlantingStart2(Date plantingStart2) { this.plantingStart2 = plantingStart2; }
	public Date getPlantingStart2() { return this.plantingStart2; }
	void setPlantingEnd2(Date plantingEnd2) { this.plantingEnd2 = plantingEnd2; }
	public Date getPlantingEnd2() { return this.plantingEnd2; }
	void setPlantingStart3(Date plantingStart3) { this.plantingStart3 = plantingStart3; }
	public Date getPlantingStart3() { return this.plantingStart3; }
	void setPlantingEnd3(Date plantingEnd3) { this.plantingEnd3 = plantingEnd3; }
	public Date getPlantingEnd3() { return this.plantingEnd3; }
	void setHarvestStart1(Date harvestStart1) { this.harvestStart1 = harvestStart1; }
	public Date getHarvestStart1() { return this.harvestStart1; }
	void setHarvestEnd1(Date harvestEnd1) { this.harvestEnd1 = harvestEnd1; }
	public Date getHarvestEnd1() { return this.harvestEnd1; }
	void setHarvestStart2(Date harvestStart2) { this.harvestStart2 = harvestStart2; }
	public Date getHarvestStart2() { return this.harvestStart2; }
	void setHarvestEnd2(Date harvestEnd2) { this.harvestEnd2 = harvestEnd2; }
	public Date getHarvestEnd2() { return this.harvestEnd2; }
	void setHarvestStart3(Date harvestStart3) { this.harvestStart3 = harvestStart3; }
	public Date getHarvestStart3() { return this.harvestStart3; }
	void setHarvestEnd3(Date harvestEnd3) { this.harvestEnd3 = harvestEnd3; }
	public Date getHarvestEnd3() { return this.harvestEnd3; }
}