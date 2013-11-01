import com.bowling.game.GameService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ScoreGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("GameService.xml");
		GameService gs = (GameService)ctx.getBean("bowling_game");
		
		String scorecard_1 = "X-X-X-X-X-X-X-X-X-X-XX";
		String scorecard_2 = "45-54-36-27-09-63-81-18-90-72";
		String scorecard_3 = "5/-5/-5/-5/-5/-5/-5/-5/-5/-5/-5";
		String scorecard_4 = "45-54-36-27-09-63-81-18-90-7/-5";
		String scorecard_5 = "9/-9/-9/-9/-9/-9/-9/-9/-9/-9/-9";
		
		gs.submitGame("John Smith", scorecard_1);
		gs.printGame();
		System.out.println(gs.getBOWLER_NAME()+" scored: " + gs.scoreGame());
		
		gs.clearGame();
		gs.submitGame("Mary Smith", scorecard_2);
		gs.printGame();
		System.out.println(gs.getBOWLER_NAME()+" scored: " + gs.scoreGame());
		
		gs.clearGame();
		gs.submitGame("William James", scorecard_3);
		gs.printGame();
		System.out.println(gs.getBOWLER_NAME()+" scored: " + gs.scoreGame());
		
		gs.clearGame();
		gs.submitGame("Barbara Johnson", scorecard_4);
		gs.printGame();
		System.out.println(gs.getBOWLER_NAME()+" scored: " + gs.scoreGame());
		
		gs.clearGame();
		gs.submitGame("Susan Jones", scorecard_5);
		gs.printGame();
		System.out.println(gs.getBOWLER_NAME()+" scored: " + gs.scoreGame());

	}

}
