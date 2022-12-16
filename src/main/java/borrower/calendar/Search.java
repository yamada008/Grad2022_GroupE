package borrower.calendar;

import java.io.Serializable;

public class Search implements Serializable {
	private int id = 0;
	private int produceId = 0;
	private String name = null;
	private String sowStart = null;
	private String plantingStart = null;
	private String harvestStart = null;
	
	public Search() {}
	public Search(int id, int produceId, String name, String sowStart, String plantingStart, 
			String harvestStart) {
		this.id = id;
		this.produceId = produceId;
		this.name = name;
		this.sowStart = sowStart;
		this.plantingStart = plantingStart;
		this.harvestStart = harvestStart;
	}
	
	void setId(int id) { this.id = id; }
	public int getId() { return this.id; }
	void setProduceId(int produceId) { this.produceId = produceId; }
	public int getProduceId() { return this.produceId; }
	void setName(String name) { this.name = name; }
	public String getName() { return this.name; }
	void setSowStart(String sowStart) { this.sowStart = sowStart; }
	public String getSowStart() { return this.sowStart; }
	void setPlantingStart1(String plantingStart) { this.plantingStart = plantingStart; }
	public String getPlantingStart() { return this.plantingStart; }
	void setHarvestStart1(String harvestStart) { this.harvestStart = harvestStart; }
	public String getHarvestStart() { return this.harvestStart; }
}