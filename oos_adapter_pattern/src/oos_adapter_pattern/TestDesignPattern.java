package oos_adapter_pattern;

public class TestDesignPattern {

	public static void main(String args[]) {
		/*
		 * create cluelessIdiotTarget that the client is calling 
		 * and transfer it using the adapter pattern
		 */
		TranslatedChatAdapter tca = new TranslatedChatAdapter();
		/*
		 * use adapter to translate idiot to normal speech
		 */
		System.out.println("theLongYellowSweetFruity uses: "+tca.theLongYellowSweetFruity());
		System.out.println("theGreenRoundDoctorAwayKeeper uses: "+tca.theGreenRoundDoctorAwayKeeper());
		System.out.println("wasLesdePrais uses: "+tca.wasLesdePrais());

	}
}
