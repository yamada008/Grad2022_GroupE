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
	public Produce(int id, String name) {
		this.id = id;
		this.name = name;
	}
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
	
	public int getId() { return this.id; }
	public String getName() { return this.name; }
	public String getSowStart() { return this.sowStart; }
	public String getSowEnd() { return this.sowEnd; }
	public String getPlantingStart() { return this.plantingStart; }
	public String getPlantingEnd() { return this.plantingEnd; }
	public String getHarvestStart() { return this.harvestStart; }
	public String getHarvestEnd() { return this.harvestEnd; }
}