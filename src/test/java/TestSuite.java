import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value=org.junit.runners.Suite.class)
@SuiteClasses(value={com.bowling.frame.FrameServiceImplTest.class,
					 com.bowling.game.GameServiceImplTest.class,
					 com.bowling.score.TenPinScoringServiceImplTest.class})
public class TestSuite {

}
