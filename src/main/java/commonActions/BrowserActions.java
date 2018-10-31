package commonActions;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class BrowserActions{
	 WebDriver selenium;
	 String alertText;
	 String actualTitle;
	 String  currentUrl;
	 String filePath = "C:\\Users\\gs-0985\\Screenshots\\";
	 int currentYear, currentAge;
	 TestDataFunctions data = new TestDataFunctions();
	 SoftAssert s_assert = new SoftAssert();
	 String loginLocatorsPath = System.getProperty("user.dir")+"\\src\\main\\java\\objectRepository\\LoginPage.properties";
	 ObjectMap objMap = new ObjectMap(loginLocatorsPath);
	 //Actions action = new Actions(selenium);

	/** This method opens a new browser instance depending upon browser name given.. 
	 * Maximizes the browser window and wait for mentioned implicit wait before executing next expected condition.
	 */
	public void openBrowserInstance(){
	Properties config = data.getPropertiesFileData();
	String browser = config.getProperty("browser");
	Log.info("Launching "+browser+" browser. ");
	if (browser.equalsIgnoreCase("firefox")){
		System.setProperty("webdriver.gecko.driver", (System.getProperty("user.dir")+"\\drivers\\geckodriver.exe"));
		 selenium = new FirefoxDriver();
 } else if (browser.equalsIgnoreCase("chrome")){
	    System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+"\\drivers\\chromedriver.exe"));
	    selenium = new ChromeDriver();
 } else if (browser.equalsIgnoreCase("ie")){
	   System.setProperty("webdriver.ie.driver", (System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe"));
	    selenium = new InternetExplorerDriver();
}else if (browser.equalsIgnoreCase("edge")){
	   System.setProperty("webdriver.edge.driver", (System.getProperty("user.dir")+"\\drivers\\MicrosoftWebDriver.exe"));
	    selenium = new EdgeDriver();
} else{
	 try {
         throw new IllegalArgumentException();
     } catch (Exception t){
         Log.exception("The Browser Type " +browser+ " is Undefined", t);
     }
 }
selenium.manage().window().maximize();
selenium.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

/** This method goes to the mentioned url. 
 * The url is taken from parameters in testng file for some cases, otherwise it is imported from excel sheet.
 * @param url
 */
public void goToUrl(String environment){
	Properties config = data.getPropertiesFileData();
	switch(environment){
	case "qa":
		selenium.get(config.getProperty("qa"));
	break;
	
	case "dev":
		selenium.get(config.getProperty("dev"));
	break;

	case "devQa":
		selenium.get(config.getProperty("devQa"));
	break;
		
	case "demo250":
		selenium.get(config.getProperty("demo250"));
	break;

    default:
	        // Log.error("The  " + environment+ " is not valid environment");
	         //return;
	  //       System.exit(1);
    	Log.fatal("The  " + environment+ " is not valid environment");
	     }
	Log.info("Opening "+environment+ " url");
	}

public void getPageTitle(String expectedTitle){
	actualTitle = selenium.getTitle();
	s_assert.assertEquals(actualTitle, expectedTitle);
	Log.info("The expected title is " +expectedTitle + " and the actual title is " +actualTitle);
}

/** This method closes the browser window that the driver has focus of
 */
	public void closeDriver(){
	try {
		Thread.sleep(1000);
		Log.info("Closing current browser window....");
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	selenium.close();
	}
	
/** Closes all windows associated to the test and ends the web driver session.
 */
public void quitDriver(){
	threadSleepWait(1000);
//	Log.info("Ending test execution and quitting browser......");
	selenium.quit();
	}

/** Refresh the web page
 */
public void refreshpage(){
	Log.info("Refreshing web page");
	selenium.navigate().refresh();
	threadSleepWait(5000);
}

/** This method gets the page title and returns it.
 * @return it returns page title
 */
public void verifyPageTitle(String expectedTitle){
	actualTitle = selenium.getTitle();
	try{
	s_assert.assertEquals(actualTitle, expectedTitle);
	} catch(Exception e){
		Log.exception("The title "+actualTitle+" is not Expected Title", e);
	}
	}

/**This method switches to the located frame in a web page.  
 * @param by Takes the locator from page class
 */
public void frameSwitch(By by){
	selenium.switchTo().frame(selenium.findElement(By.tagName("iframe")));
	}

/** This method clicks on the located element. Before clicking, web driver waits for element to be present and to be clickable.
 * After that it waits for wait mentioned in thread sleep and clicks on element. 
 * @param by Takes the locator from page class
 */
public void click(By by){
	try{
		//Actions action = new Actions(selenium);
		waitForPresenceOfElement(by);
		waitForElementToBeClickable(by);
		//mouseOver(by);
		selenium.findElement(by).click();
		Log.info("Clicking on " +by+" element");
	} catch (Exception e){
		Log.exception("The element is not found. The exception occured is  " , e);
		throw(e);
	}
	}

/** This method writes the text in located element. Before writing, it waits for that element to be present and clickable.
 * Then it clears that field and fill up with new value.
 * @param by takes locator from page class
 * @param text value to enter in text field
 */
public void type(By by, String text){
	waitForElementToBeVisible(by);
	waitForElementToBeClickable(by);
	selenium.findElement(by).clear();
	selenium.findElement(by).sendKeys(text);
	Log.info("Entering " +text+ " into " + by + " element");
	}

public void clearField(By by){
	selenium.findElement(by).clear();
}

/** This method waits for element to be present.    
 * @param by locator of element from page class
 */
public boolean waitForPresenceOfElement(By by){
	WebDriverWait myWait = (new WebDriverWait(selenium, 10));
	Log.info("Waiting for " + by + " element to be present");
	myWait.until(ExpectedConditions.presenceOfElementLocated(by));
	Boolean isPresent = selenium.findElements(by).size() > 0;
	return  isPresent;
	}

/** This method waits for element to be clickable. 
 * @param by locator of element from page class
 */
public void waitForElementToBeClickable(By by){
	WebDriverWait wait = new WebDriverWait(selenium, 5);
	 wait.until(ExpectedConditions.elementToBeClickable(by));
	}

/**
 * @param by locator of element from page class
 */
public void jScriptClick(By by){
	JavascriptExecutor executor = (JavascriptExecutor)selenium;
	Log.info("Executing JavaScript for clicking on " + by + " element");
	executor.executeScript("arguments[0].click();",selenium.findElement(by));
	}

/** This method causes web driver to wait for element to be visible till mentioned timeout
 * @param by locator of element from page class	
 */
public void waitForElementToBeVisible(By by){					// Not using currently
	WebDriverWait wait = new WebDriverWait(selenium, 15);
	Log.info("Waiting for " + by + " element to be visible");
	wait.until(ExpectedConditions.visibilityOfElementLocated(by)); 
	}

/** This method causes web driver to wait for mentioned time period. If web driver can not find element in starting,
 *  it will wait for specified time duration without searching for element during wait period.
 *  Once wait is over, web driver will try to find an element for last time before throwing exception.
 */
public void implicitWait(){
	Log.info("Calling Implicit wait");
	selenium.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

/** This method forces web driver to wait for mentioned time period. This wait should be used in worst case. 
 */
public void threadSleepWait(int timeInMiliSeconds){
	try {
		Log.info("Waiting for "+timeInMiliSeconds+" miliseconds");
		Thread.sleep(timeInMiliSeconds);
	} catch (InterruptedException e) {
		Log.exception("The exception occurred is ", e);
		e.printStackTrace();
	}
	}

/** This method gets text of link present on the UI. It first finds element using locator and captures the text in it.
 * @param by locator of element from page class
 * @return returns the text contained in the link on the UI.
 */
public String getText(By by) {
		waitForPresenceOfElement(by);
		Log.info("Getting text of " +by+ " element");
		 String text = selenium.findElement(by).getText();
		 Log.info("The text of element is '"+text+"'");
		 return text;
		}

public void assertText(By by, String str){
	try{
	s_assert.assertEquals(getText(by), str);
	}catch(Exception e){
		Log.exception("The "+getText(by)+" is not equal to expected text", e);
	}
}

/** This method get the attribute value 
 * @param by
 * @return
 */
public String getValue(By by) {
	WebElement getElement = selenium.findElement(by);
	waitForPresenceOfElement(by);
	return getElement.getAttribute("value");
	}

/** This method returns HTML content of an element
 * @param by locator of element from page class
 * @return html content
 */
public String getPopUpText(By by){
	String popUpText = selenium.findElement(by).getAttribute("innerHTML");
	Log.info("The text inside "+by+" popup is "+popUpText);
	return popUpText;
	}

/** This method hovers the cursor on the located element.
 * Here it is used for locating first and second plan on the home page.
 * @param by locator of element from page class
 */
public void mouseOver(By by){
	WebElement move = selenium.findElement(by);
	Actions action = new Actions(selenium);
	Log.info("Moving mouse cursor to "+by);
	action.moveToElement(move).perform();
	threadSleepWait(100);
	}

public void webTableElements(By by1, By by2){
	WebElement htmlTable = selenium.findElement(by1);
	List <WebElement> rows = htmlTable.findElements(by2);
	for (int rownumber = 0; rownumber < rows.size(); rownumber++){
		Log.info("The size of the table elements is "+rows.size());
	}
}

/** This method hovers the cursor on web element.
 * @param by locator of element from page class
 */
public void mouseHoverToElement(WebElement by){
	Actions action = new Actions(selenium);
	Log.info("Moving mouse cursor to "+by);
	action.moveToElement(by).perform();
	threadSleepWait(1000);
	}
 
/** This method performs mouse click on the located element.
 * @param by locator of element from page class
 */
public void moveFocusAndClick(By by){
	WebElement move = selenium.findElement(by);
	Actions action = new Actions(selenium);
	Log.info("Moving focus and clicking on  "+by);
	action.moveToElement(move).click().perform();
	}

/** This method clicks on the keyboard's ESC Key.
 */
public void pressEscKey(){
	Actions action = new Actions(selenium);
	Log.info("Pressing ESC key");
	action.sendKeys(Keys.ESCAPE).build().perform();
}

/** This method takes the screen shot of the page and stores it in .jpg file in the project. 
 * The file is visible after refreshing the project.
 */
public void takeScreenshot(String methodName){
	 	File getImage = ((TakesScreenshot)selenium).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(getImage, new File(filePath+methodName+".png"));
			Log.info("***Placed screenshot in "+filePath+" ***");
		} catch (IOException e) {
			Log.exception("The exception ocurred for placing screenshot " , e);
		}
		}

/** This method selects drop down option by matching with text. 
 * @param by Locates the drop down box
 * @param option Passes text to select from drop down
 */
public void selectDropDownMenu(By by, String option){
			 WebElement element=selenium.findElement(by);
			 Log.info("Selecting dropdown option by visible text");
		    	Select se= new Select(element);
				se.selectByVisibleText(option);
				implicitWait();
	}

/** This method selects drop down option by matching with value.
 * @param by locator of drop down menu
 * @param index Defines the value of the element to be selected
 */
public void selectDropDownMenuByValue(By by, String index){
	 WebElement element=selenium.findElement(by);
	 Log.info("Selecting dropdown option by index");
		Select se= new Select(element);
		se.selectByValue(index);
}

/** This method gets the text of browser alert and accepts alert. 
 */
public void getAlertWindowDetails(){
		threadSleepWait(500);
		Alert alert = selenium.switchTo().alert();
		alertText = alert.getText();
		Log.info("The text of alert window is "+alertText);
		alert.accept();
		}
	
/** Returns text of browser alert
 * @return alert text
 */
public String returnAlertText(){
			return alertText;
	}
	
/** This method takes text in alert and dismisses it.
 */
public void dismissAlert(){
		Alert alert = selenium.switchTo().alert();
		alertText = alert.getText();
		Log.info("Dismissing browser alert ");
		alert.dismiss();
	}

/** In this method, web driver reads the current page Url
 * @return the page Url
 */
public String getCurrentPageUrl(){
		return currentUrl = selenium.getCurrentUrl();
	}
	
public void scrollUp(){
	JavascriptExecutor jse = (JavascriptExecutor)selenium;
	Log.info("Scrolling up page");
	jse.executeScript("scroll(0, -450);");
}

/** This method scrolls down web page by 250 pixels.
 */
public void scrollDown(){
		JavascriptExecutor jse = (JavascriptExecutor)selenium;
		Log.info("Scrolling down page");
		jse.executeScript("scroll(0, 250);");
	}

/** This method waits for page to load till mentioned timeout.
 * Before waiting it verifies whether page is in complete state.
 * @param timeOutInSeconds seconds to wait for page to load
 */
public void waitForPageToLoad(int timeOutInSeconds){
		  JavascriptExecutor js = (JavascriptExecutor)selenium;
		  String command = "return document.readyState";
		  //Check the readyState before doing any waits
		  if (js.executeScript(command).toString().equals("complete")){
		   return;
		  }

		  for (int i=0; i<timeOutInSeconds; i++){
		   try {
		    Thread.sleep(1000);
		    if (js.executeScript(command).toString().equals("complete")){
		     break;
		    }
		   } catch (InterruptedException e) {}
		  }
		 }

/** This method navigates to back page by clicking browser back button
 */
public void browserBackButton(){
	Log.info("Clicking browser back button");
	selenium.navigate().back();
	threadSleepWait(1000);
}

/** This method verifies whether element is displayed or not and returns true or false
 * @param by locator of element from page class
 * @return True or False
 */
public boolean isElementDisplayed(By by){
	boolean value=false;
	try{
		Log.info("Verifying "+by+" element is displayed or not");
	  value= selenium.findElement(by).isDisplayed();
	 }catch(Exception e){
		 Log.exception("The element is not displayed", e);
	 }
	return value;
}

/** This method verifies whether web element is displayed or not. It returns true / false
 * @param w  It takes web element as parameter
 * @return true if web element is displayed
 */
public boolean isWebElementDisplayed(WebElement w){
	  return w.isDisplayed();
	 }

/** This method verifies whether element is present or not and returns true or false
 * @param by locator of element from page class
 * @return True or False
 */
public boolean isElementPresent(By by){
	boolean value=false;
	try{
		Log.info("Verifying "+by+" element is present or not");
	  value= selenium.findElements(by).size() != 0;
	 }catch(Exception e){
		 Log.exception("The element is not displayed", e);
	 }
	return value;
	  //return selenium.findElements(by).isEmpty();
	 }
						
/** This method finds the web elements present by given locator.
 * 
 * @param by locator of element from page class
 * @return list of elements present by given locator
 */
public List<WebElement> getListOfElements(By by){
	List<WebElement> myElement = selenium.findElements(by);
	return myElement;
	}																													

/** This method locates subsequent elements of a parent class
 * @param by1 Parent class web element
 * @param by2 Child class web element
 * @return Subsequent element's list of parent class elements
 */
public List<WebElement> getElementList(WebElement by1, By by2){
	return by1.findElements(by2);
}

/** This method waits for element to become invisible on UI. 
 * Currently it is used for Loading symbol.
 * @param by locator of element from page class
 * @param seconds wait time in seconds
 * @return
 */
public boolean waitForElementToBeInvisible(By by, int seconds){
	Log.info("Waiting for element to become invisible after "+seconds);
	    WebDriverWait wait = new WebDriverWait(selenium, seconds);
	    return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

/** This method calculates current age based on entered birth year of a member.
 * @param primaryBirthYear birth year of primary and spouse 
 * @return current age of a member
 */
public int getCurrentAge(String primaryBirthYear){
	Calendar cal = Calendar.getInstance();
     currentYear = cal.get(Calendar.YEAR); 
     int birthYear = Integer.parseInt(primaryBirthYear);
     currentAge = currentYear - birthYear;
     return currentAge;
}

/** This method handles the loading symbol state. If it is displayed in starting, it will wait for it to be invisible for mentioned timeout.
 * If not then it will wait for 2 seconds and go to next step.
 * @param by loading symbol
 * @param Seconds timeout to wait 
 */
public void loadingSymbolState(By by, int Seconds){
	if(isElementDisplayed(by)){
		waitForElementToBeInvisible(by, Seconds);
	}
	else{
	threadSleepWait(2000);
	}
}

public void selectJcfDropdownValue(By by, String option){
	click(by);
	Log.info("Selecting " +option+" from drodown");
	By applicationValue = By.xpath("//span[contains(text(),'"+option+"')]");
	click(applicationValue);
}

public void logoutAfterTest(By by){
	Log.info("Logging out of application");
	click(by);
}

public void assertObject(By by){
	threadSleepWait(200);
	s_assert.assertEquals(isElementDisplayed(by), true);
}

public void assertPresence(By by){
	threadSleepWait(200);
	s_assert.assertEquals(isElementPresent(by), true);
}

public void assertObjectAbsence(By by){
	s_assert.assertEquals(isElementDisplayed(by), false);
}

/** This method checks for new tab opened after clicking on web element. Asserts the page title and closes the new tab.
 * @param expected the title to be verified
 */
public void checkNewTab(){

	List<String> browserTabs = new ArrayList<String> (selenium.getWindowHandles());
	selenium.switchTo().window(browserTabs .get(1));
	Log.info("The new tab opened is ' "+selenium.getTitle()+" '");
	threadSleepWait(4000);
	closeDriver();
	selenium.switchTo().window(browserTabs.get(0));
	Log.info("The application tab is ' "+selenium.getTitle()+" '");
	threadSleepWait(2000);
}

public void waitForLoadingPlans(By by){
	if(isElementPresent(by)){
		waitForElementToBeInvisible(by, 10);
	} else{
		threadSleepWait(2000);
	}
}

public void checkRadioButtonStatus(By by){
	WebElement r = selenium.findElement(by);
	Boolean radio = r.isEnabled();
	if(radio.booleanValue()==true){
		System.out.println("The " + by + "Radio button is selected");
	}else{
		System.out.println("The " + by + "Radio button is not selected");
	}
}
}
