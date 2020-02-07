package oos_adapter_pattern;

/*
 * the poor dude that has to figure out what the dumb client 
 * actually wanted to say and pass information to his coworker(Adaptee)
 */
public class TranslatedChatAdapter implements CluelessIdiotTarget {
	
	public LuckyCoworkerAdaptee lca;

	TranslatedChatAdapter(){
		this.lca = new LuckyCoworkerAdaptee();
	}
	
	@Override
	public String theLongYellowSweetFruity() {
		return lca.getBanana();
	}

	@Override
	public double wasLesdePrais() {
		return lca.getPrice();
	}

	@Override
	public String theGreenRoundDoctorAwayKeeper() {
		return lca.getApple();
	}
	
	
}
