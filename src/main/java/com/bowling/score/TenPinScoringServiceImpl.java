package com.bowling.score;

import com.bowling.frame.FrameServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;



public class TenPinScoringServiceImpl implements ScoringService {

	private int score;
	
	private final int VALUE_OF_SPARE = 10;
	private final int VALUE_OF_STRIKE = 10;
	
	private HashMap<String, Integer> scoringKey = new HashMap<String, Integer>(11);
	
	private ArrayList<FrameServiceImpl> FRAMES;
	private final int MAX_NUM_OF_FRAMES = 10;
	
	public TenPinScoringServiceImpl() {
		init();
	}
	
	public void computeScore() {
		for (int i=0; i<FRAMES.size(); i++) {
			int frameNumber = i+1;
			// Feed each roll through the calculateScore method
			String[] tmp = FRAMES.get(i).getAllRolls();
			for (int j=0; j<tmp.length; j++) {
				calculateScore(frameNumber, tmp[j].charAt(0));
			}
		}
	}
	
	private void calculateScore(int frameNo, char pins) {
			switch (pins){
			case('X'):
				addStrike(frameNo);
				break;
			case('/'):
				addSpare(frameNo);
				break;
			default:
				addPins(frameNo, pins);
				break;
			}
	}
	

	private void addPins(int frameNum, char pinCount) {
		if ( frameNum <= MAX_NUM_OF_FRAMES)
			score = score + Integer.parseInt(String.valueOf(pinCount));
	}
	
	private void addSpare(int frameNum) {
		// We pass in the actual frame number, but the variable frameNum is used for a zero-based
		// ArrayList, so we reduce the frame number by one to account for this.
		frameNum -= 1;
		
		// Scoring for the first 10 frames
		if ( frameNum < MAX_NUM_OF_FRAMES) {
		score -= Integer.parseInt(scoringKey.get(FRAMES.get(frameNum).getRoll(1)).toString());
		score += VALUE_OF_SPARE + Integer.parseInt(scoringKey.get(FRAMES.get(frameNum+1).getRoll(1)).toString());
		} else {
			score -= Integer.parseInt(FRAMES.get(frameNum).getRoll(1));
		}
	}

	private void addStrike(int frameNum) {
		if ( frameNum < MAX_NUM_OF_FRAMES) {
			score += VALUE_OF_STRIKE + Integer.parseInt(scoringKey.get(FRAMES.get(frameNum).getRoll(1)).toString());
			if ( FRAMES.get(frameNum).getAllRolls().length > 1) {
				score += Integer.parseInt(scoringKey.get(FRAMES.get(frameNum).getRoll(2)).toString());
			} else {
				score += Integer.parseInt(scoringKey.get(FRAMES.get(frameNum+1).getRoll(1)).toString());
			}
		} else if ( frameNum == MAX_NUM_OF_FRAMES) {
			score += VALUE_OF_STRIKE + Integer.parseInt(scoringKey.get(FRAMES.get(frameNum).getRoll(1)).toString())+Integer.parseInt(scoringKey.get(FRAMES.get(frameNum).getRoll(2)).toString());
		}
	}

	public int getFinalScore() {
		return score;
	}
	
	void init() {
		scoringKey.put("X", 10);
		scoringKey.put("/", 10);
		scoringKey.put("9", 9);
		scoringKey.put("8", 8);
		scoringKey.put("7", 7);
		scoringKey.put("6", 6);
		scoringKey.put("5", 5);
		scoringKey.put("4", 4);
		scoringKey.put("3", 3);
		scoringKey.put("2", 2);
		scoringKey.put("1", 1);
		scoringKey.put("0", 0);
	}

	public void clearScore() {
		score = 0;
	}
	public int getVALUE_OF_SPARE() {
		return VALUE_OF_SPARE;
	}

	public int getVALUE_OF_STRIKE() {
		return VALUE_OF_STRIKE;
	}

	public int getMAX_NUM_OF_FRAMES() {
		return MAX_NUM_OF_FRAMES;
	}

	public ArrayList<FrameServiceImpl> getFRAMES() {
		return FRAMES;
	}

	public void setFRAMES(ArrayList fRAMES) {
		FRAMES = fRAMES;
	}
}
