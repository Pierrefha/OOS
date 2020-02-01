package oos_proxy_pattern;

/*
 * class to test the design pattern
 */
public class TestDesignPattern {

	public static void main(String args[]) throws Exception {
		/*
		 * client logs into account and wants to execute queries
		 * one client is admin the other is useless std User
		 */
		DatabaseExecuterProxy keinAdmin = new DatabaseExecuterProxy("stdUser", "xyz");
		DatabaseExecuterProxy admin = new DatabaseExecuterProxy("Admin","password");

		//execute query
		keinAdmin.executeDatabase("SELECT * FROM user");
		admin.executeDatabase("SELECT * FROM user");
		
		//execute drop query
		keinAdmin.executeDatabase("DROP");
		admin.executeDatabase("DROP");
		
		
		
	}
}
