package com.bowling.frame;

public interface FrameService {
	String[] getAllRolls();
	String getRoll(int num);
	boolean isValid();
	int getFRAME_NO();
	int getMAX_NUM_OF_ROLLS();
	void setFRAME_NO(int num);
	void setMAX_NUM_OF_ROLLS(int num);
    void setFrameArray(String[] frameArray);
}
