package Transaction;

public class Transaction {
	private String userInfo;
	private int userID;
	private String actionInfo;
	
	public Transaction() {
		this.userInfo = null;
		this.userID = 0;
	}
	
	public Transaction(String userInfo, int userID, String actionInfo) {
		this.userInfo = userInfo;
		this.userID = userID;
		this.actionInfo = actionInfo;
	}
	
	public void setUserInfo(String newUserInfo) {
		this.userInfo = newUserInfo;
	}
	
	public void setUserID(int newUserID) {
		this.userID = newUserID;
	}
	
	public void setActionInfo(String actionInfo) {
		this.actionInfo = actionInfo;
	}
	
	public String getUserInfo() {
		return this.userInfo;
	}
	
	public int getUserID() {
		return this.userID;
	}
	
	public String getActionInfo() {
		return this.actionInfo;
	}
	
	public Transaction getPackedTransaction() {
		return this;
	}

	@Override
	public String toString() {
		return this.userInfo + "_" + this.userID + ":" + this.actionInfo;
	}
	
}
