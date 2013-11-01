package com.bowling.game;

import com.bowling.frame.FrameServiceImpl;
import com.bowling.score.ScoringService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class GameServiceImpl implements GameService {

	private int NUM_OF_FRAMES;
	private ArrayList<FrameServiceImpl> framesList = new ArrayList<FrameServiceImpl>(NUM_OF_FRAMES+1);
	private String SCORECARD;
	private String FRAME_SEPARATOR;
	private String BOWLER_NAME;

    private ScoringService ss;

	public GameServiceImpl() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ScoringService.xml");
		ss = (ScoringService) ctx.getBean("ten_pin_scoring_system");
	}

	public void submitGame(String bowler, String scoreCard) {
		BOWLER_NAME = bowler;
		SCORECARD = scoreCard;


		if ( validateScoreCard(scoreCard) ) {
            StringTokenizer st = new StringTokenizer(scoreCard, FRAME_SEPARATOR);
            Integer frameNo = 1;

			while (st.hasMoreTokens()) {

				String frame = st.nextToken();
				String[] tmpFrmHolder = new String[frame.length()];

				for (int i=0; i<frame.length(); i++) {
					tmpFrmHolder[i] = String.valueOf(frame.charAt(i));
				}
				framesList.add(new FrameServiceImpl(frameNo, tmpFrmHolder));
				frameNo++;
			}
		}
	}

	public boolean validateScoreCard(String scoreCard) {
        boolean valid = (scoreCard.length() > 0) ? true : false;
		return valid;
	}
	public void clearGame() {
		framesList.clear();
		ss. clearScore();
	}

	public void printGame() {
		System.out.println(SCORECARD);
	}

	public int scoreGame() {
		ss.setFRAMES(framesList);
		ss.computeScore();
		return ss.getFinalScore();
	}

	public int getNUM_OF_FRAMES() {
		return NUM_OF_FRAMES;
	}

	public void setNUM_OF_FRAMES(int nUM_OF_FRAMES) {
		NUM_OF_FRAMES = nUM_OF_FRAMES;
	}

	public String getFRAME_SEPARATOR() {
		return FRAME_SEPARATOR;
	}

	public void setFRAME_SEPARATOR(String fRAME_SEPERATOR) {
		FRAME_SEPARATOR = fRAME_SEPERATOR;
	}

	public String getBOWLER_NAME() {
		return BOWLER_NAME;
	}

	public void setBOWLER_NAME(String bOWLER_NAME) {
		BOWLER_NAME = bOWLER_NAME;
	}
}
