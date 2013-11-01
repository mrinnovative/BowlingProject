package com.bowling.frame;

public class FrameServiceImpl implements FrameService {

	private int MAX_NUM_OF_ROLLS;

	private String[] frameArray = new String[MAX_NUM_OF_ROLLS];
	private int FRAME_NO = 1;
	
	public FrameServiceImpl() {}
	
	public FrameServiceImpl(int frameNo, String[] frame) {
		frameArray = frame.clone();
		FRAME_NO = frameNo;
	}
	
	public boolean isValid() {
		return true;
	}

	public int getMAX_NUM_OF_ROLLS() {
		return MAX_NUM_OF_ROLLS;
	}

	public void setMAX_NUM_OF_ROLLS(int mAX_NUM_OF_ROLLS) {
		MAX_NUM_OF_ROLLS = mAX_NUM_OF_ROLLS;
	}

	public int getFRAME_NO() {
		return FRAME_NO;
	}

	public void setFRAME_NO(int fRAME_NO) {
		FRAME_NO = fRAME_NO;
	}

	public String[] getFrameArray() {
		return frameArray;
	}

	public void setFrameArray(String[] frameArray) {
		this.frameArray = frameArray;
	}

	public String toString() {
		String roll = "";
		for ( int i=0; i<frameArray.length;i++) {
			roll += frameArray[i];
		}
		return FRAME_NO +"->"+roll;
	}
	
	public String[] getAllRolls() {
		return frameArray;
	}
	
	public String getRoll(int rollNumber) {
		return frameArray[rollNumber - 1];
	}
	
}
