package user;

import java.io.Serializable;

public class Bean implements Serializable {
	 private static final long serialVersionUID = 1L;
	private String userId = null;
	
	
	public Bean() {}
	public Bean(String id ) {
		
		this.setUserId(id);
		
	}
	
	public void setUserId(String id) { this.userId = id; }
	public String getUserId() { return this.userId; }
	
	
	
}
//