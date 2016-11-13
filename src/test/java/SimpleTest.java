/**
 * Created by Jacek on 2015-08-01.
 */

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleTest {

    private static WebDriver driver;

    private static final String URL = "http://dist2016z.vm.wmi.amu.edu.pl:8080/registrationform/";
    private static final String PATH = "build//libs//chromedriver.exe";

    @Before
    public void openBrowserAndSetData(){
    	System.setProperty("webdriver.chrome.driver", PATH);
        driver = new ChromeDriver();       
        driver.get(URL);
        setData();
    }

    private void setData() {
    	driver.findElement(By.name("firstName")).clear();
    	driver.findElement(By.name("firstName")).sendKeys("Marek");
	}

	@Test
    public void checkIfCorrectPageHasBeenLoaded() {
        String title = driver.getTitle();
        assertEquals("Rule Financial Registration Form", title);
    }
	
	@Test
	public void checkIfCorrectDataHasBeenEntered() {
		String checked = driver.findElement(By.name("firstName")).getAttribute("value");
		assertEquals("Marek", checked);
	}

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
