package game;

public enum Score {
	AS(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), VALET(11), DAME(12), ROI(13);
	
	private Integer length;

	private Score(Integer leng) { 
		this.length = leng; 
		}
}
