/**
 * 
 */
package testcases;

import org.testng.annotations.Test;

import commonActions.TestTemplate;

/**
 * @author GS-0985 Mayuri Wavhal
 *
 */
public class SanityTest extends TestTemplate{

	@Test
	public void addNewEmployer(String organization, String assignedName, String password, String email, String zip, String singleFSA, String familyFSA, String singleHSA, String familyHSA){
		emp.addNewEmployerGroup(organization, assignedName, password, email, zip, singleFSA, familyFSA, singleHSA, familyHSA);
	}
	
	@Test
	public void assignPlansToEmployerGroup(){
		
	}
}
