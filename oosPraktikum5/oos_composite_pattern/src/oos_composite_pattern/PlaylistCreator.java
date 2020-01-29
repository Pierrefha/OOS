package oos_composite_pattern;

/*
 * this class uses the composite pattern to create songgroups and songs
 * both can be treated as songcomponents
 */
public class PlaylistCreator {
	
	public static void main(String args[]) {
		
		//create some Songs/SongLeafs
		SongLeaf sL1 = new SongLeaf("aurora");
		SongLeaf sL2 = new SongLeaf("astra");
		SongLeaf sL3 = new SongLeaf("regen");
		
		//create two different SongGroups
		SongGroupComposite sGC1 = new SongGroupComposite("etapp kyle music");
		SongGroupComposite sGC2 = new SongGroupComposite("tua music");
		
		//append songs to SongGroups
		SongGroupComposite sC1 = sGC1.add(sL1).add(sL2);
		SongGroupComposite sC2 = sGC2.add(sL3);
		
		//append SongGroups to one component
		SongComponent sGCResult = sC1.add(sC2);
	
		//return tree/list and its node count
		System.out.println(sGCResult.getPrefix());
		System.out.println("node count: "+sGCResult.getNodeCount());
	}
}
