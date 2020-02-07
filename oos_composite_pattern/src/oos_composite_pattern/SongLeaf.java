package oos_composite_pattern;

/*
 * Leaf class describes a single, not combined, component.
 */
public class SongLeaf extends SongComponent {
		
	//call construct of component
	SongLeaf(String styleDescription) {
		super(styleDescription);
		System.out.println("which is a SongLeaf with description:"+styleDescription);
		}
	
	//getter for every attribute
	@Override
	public String getDescription() {
				return this.styleDescription;
	}
	@Override
	public String getBandName() {
		return null;
	}
	
	//setter for every attribute
	@Override
	public void setDescription(String styleDescription) {
		this.styleDescription = styleDescription;
	}
	@Override
	public void setBandName(String bandName) {
	}

	//we are a leaf so we just print our description
	@Override
	public String getPrefix() {
		return this.styleDescription+" ";
	}

	//we are a leaf so we return 1
	@Override
	public int getNodeCount() {
		return 1;
	}
	
	
}
