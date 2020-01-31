package oos_proxy_pattern;

/*
 * Class the client actually calls that checks for correct rights before using methods
 */
public class DatabaseExecuterProxy implements DatabaseExecuterSubject {

	boolean ifAdmin;
	DatabaseExecuterRealSubject dbRS;
	
	/*
	 * determine whether user is worthy to query exec shell rm -r ./*
	 */
	DatabaseExecuterProxy(String name, String password){
		if(name.equals("Admin") && (password.equals("password"))){
			this.ifAdmin=true;
		}
		this.dbRS = new DatabaseExecuterRealSubject();
	}
	
	
	/*
	 * check how to handle method call depending on user state
	 */
	@Override
	public void executeDatabase(String query) throws Exception {
		if(ifAdmin) {
			dbRS.executeDatabase(query);
		}
		else {
			if(query.equals("DROP")){
				throw new Exception("YOU WONT DROP MY DATABASE BRO.");
			}
			else {
				dbRS.executeDatabase(query);
			}
		}
	}

}
