package com.bowling.game;

public interface GameService {
	void clearGame();
	void printGame();
	String getFRAME_SEPARATOR();
	void setFRAME_SEPARATOR(String sep);
	String getBOWLER_NAME();
	void setBOWLER_NAME(String bowler);
	int getNUM_OF_FRAMES();
	int scoreGame();
	void submitGame(String bowler, String scorecard);
	boolean validateScoreCard(String scorecard);
}
