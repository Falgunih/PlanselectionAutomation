package commonActions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import org.openqa.selenium.By;

public class ObjectMap {
	Properties prop;
	public static By locator;
	public static By locatorObject;
	HashMap<String, By> map = new HashMap<String, By>();

	public ObjectMap (String filePath) {
	prop = new Properties();
	map.clear();
	try {
		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);
		fis.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	getLocator();
	}	

	public HashMap<String, By> getLocator(){
		Enumeration keys = prop.keys();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			String locate = prop.getProperty(key);
			String[] objLocator=new String[2];
			objLocator = locate.split(":", 2);
			String locateBy = objLocator[0].toLowerCase();
			String locatorValue = objLocator[1];
        
        switch (locateBy){
        case "id":
        	locator  = By.id(locatorValue);
        	break;
        	
        case "name":
        	locator = By.name(locatorValue);
        	break;
        	
        case "classname":
        	locator = By.className(locatorValue);
        	break;
        	
        case "partiallinktext":
        	locator = By.partialLinkText(locatorValue);
        	break;
        	
        case "cssselector":
        	locator = By.cssSelector(locatorValue);
        	break;
        	
        case "xpath":
        	locator = By.xpath(locatorValue);
        	break;
        }
        map.put(key, locator);
        }
		return map;
	}
	
	public By getValue(String key){
	//	System.out.println(map.get(key));
		return map.get(key);
	}
}

