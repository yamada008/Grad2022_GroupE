package borrower;

import java.io.Serializable;

public class Produce implements Serializable {
	private int id = 0;
	private String name = null;
	private String sowStart = null;
	private String sowEnd = null;
	private String plantingStart = null;
	private String plantingEnd = null;
	private String harvestStart = null;
	private String harvestEnd = null;
	
	public Produce() {}
	public Produce(int id, String name, String sowStart, String sowEnd, 
			String plantingStart, String plantingEnd, String harvestStart, String harvestEnd) {
		this.id = id;
		this.name = name;
		this.sowStart = sowStart;
		this.sowEnd = sowEnd;
		this.plantingStart = plantingStart;
		this.plantingEnd = plantingEnd;
		this.harvestStart = harvestStart;
		this.harvestEnd = harvestEnd;
	}
	
	void setId(int id) { this.id = id; }
	public int getId() { return this.id; }
	void setName(String name) { this.name = name; }
	public String getName() { return this.name; }
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