package oos_proxy_pattern;

/*
 * give every user the ability to execute queries
 */
public interface DatabaseExecuterSubject {
	public void executeDatabase(String query) throws Exception;
}
