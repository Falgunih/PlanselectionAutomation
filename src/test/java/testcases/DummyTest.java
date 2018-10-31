package testcases;
import org.testng.annotations.Test;
import commonActions.TestTemplate;

public class DummyTest extends TestTemplate {

	@Test
	public void printLocator(){
		dummy.printLocator();
	}
}
