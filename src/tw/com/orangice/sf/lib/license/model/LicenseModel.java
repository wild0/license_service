package tw.com.orangice.sf.lib.license.model;

import org.json.JSONException;
import org.json.JSONObject;

public class LicenseModel {
	int maxCurrentUser = 0;
	public int getMaxCurrentUser() {
		return maxCurrentUser;
	}
	public void setMaxCurrentUser(int maxCurrentUser) {
		this.maxCurrentUser = maxCurrentUser;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	String clientName = "";
	String macAddress = "";
	
	
	public String toString(){
		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put("max_current_user", maxCurrentUser);
			jsonObj.put("client_name", clientName);
			jsonObj.put("mac_address", macAddress);
			return jsonObj.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
