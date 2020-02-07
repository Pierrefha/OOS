/**
 * 
 */
package oos_composite_pattern;

/**
 * @author xddq
 * Component Class which enables us to treat a single object
 *  and a group of objects the same way
 */
public abstract class SongComponent {
	
	String styleDescription;
	
	public SongComponent(String styleDescription) {
		this.styleDescription = styleDescription;
		System.out.println("created a SongComponent");
	}
	
	//getters for Leaf and Composite
	public abstract String getDescription();
	public abstract String getBandName();
	
	//setters for Leaf and Composite
	public abstract void setDescription(String styleDescription);
	public abstract void setBandName(String bandName);

	//methods which iterates through composite
	public abstract String getPrefix();
	public abstract int getNodeCount();
	
}
