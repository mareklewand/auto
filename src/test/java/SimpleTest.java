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

    private static final String URL = "http://orange.pl";
    private static final String PATH = "build//libs//chromedriver.exe";
    private static final String TITLE = "Orange - najlepsze okazje na internet, telefon i telewizję | Orange Polska";

    @Before
    public void openBrowserAndSetData(){
    	System.setProperty("webdriver.chrome.driver", PATH);
        driver = new ChromeDriver();       
        driver.get(URL);
    }


	@Test
    public void checkIfCorrectPageHasBeenLoaded() {
        String title = driver.getTitle();
        assertEquals(TITLE, title);
    }


    @After
    public void closeBrowser(){
        driver.quit();
    }
}
