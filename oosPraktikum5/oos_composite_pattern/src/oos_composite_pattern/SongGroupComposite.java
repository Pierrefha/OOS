package oos_composite_pattern;

import java.util.ArrayList;

public class SongGroupComposite extends SongComponent {
	

	//create collection that contains a Component (either leaf or composite)
	ArrayList<SongComponent> allSongComponents = new ArrayList<SongComponent>();
	
	//create SongComponent which is a SongGroup and has an empty songComponentsList
	SongGroupComposite(String styleDescription) {
		super(styleDescription);
		System.out.println("which is a SongGroup with description: "+this.styleDescription);
	}
	
	//
	@Override
	public String getDescription() {
		return this.styleDescription;
	}

	@Override
	public String getBandName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDescription(String styleDescription) {
		this.styleDescription=styleDescription;
	}

	@Override
	public void setBandName(String bandName) {
		// TODO Auto-generated method stub
		
	}
	
	//implement standard add and remove methods which return the Composite
	public SongGroupComposite add(SongComponent sC) {
		this.allSongComponents.add(sC);
		return this;
	}
	
	public SongGroupComposite remove(SongComponent sC) {
		this.allSongComponents.remove(sC);
		return this;
	}
	
	//implement standard getChild method which returns the Component
	public SongComponent getChild(int index) {
		return this.allSongComponents.get(index);
	}

	//we are a Composite so we iterate through our collection and return result
	@Override
	public String getPrefix() {
		String output=this.styleDescription+" ";
		for (SongComponent songComponent : allSongComponents) {
			//remember to get prefix here, so we can also print 
			//complete composites inside a composite
			output+=songComponent.getPrefix();
		}
		return output;
	}

	//we are a composite so we return 1 and add all children
	@Override
	public int getNodeCount() {
		int count=1;
		for(SongComponent songComponent : allSongComponents) {
			count+=songComponent.getNodeCount();
		}
		return count;
	}
	
	
}
