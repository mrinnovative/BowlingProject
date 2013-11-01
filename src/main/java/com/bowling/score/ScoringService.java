package com.bowling.score;

import java.util.ArrayList;

public interface ScoringService {
	void clearScore();
	void computeScore();
	void setFRAMES(ArrayList arrayOfFrames);
	int getFinalScore();
}
