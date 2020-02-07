package oos_proxy_pattern;

/*
 * target class the client wants to execute and get results of
 */
public class DatabaseExecuterRealSubject implements DatabaseExecuterSubject {

	/*
	 * implementation of realSubject
	 */
	@Override
	public void executeDatabase(String query) throws Exception {
		System.out.println("Going to execute query: "+query);
	}
}
