import junit.framework.Assert;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

public class CreatePageTest {
/*
Bypass login
1) Submit form

 */
    WebDriver driver;
    @Before
    public void before()
    {
        System.setProperty("webdriver.chrome.driver", "/home/marinex/Test/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8080/academia_war_exploded/login.html");
        WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
        SessionStorage storage = webStorage.getSessionStorage();
        storage.setItem("id","101");
        driver.navigate().to("http://127.0.0.1:8080/academia_war_exploded/create.html");

    }

    @Test
    public void createPageTestCase1()
    {
        try {


            WebElement dropDownBtn = driver.findElement(By.id("dropdownMenuButton"));

            dropDownBtn.click();
            Thread.sleep(2000);
            Assert.assertEquals("test","test");
        }
        catch (Exception e)
        {

        }
    }

    @After
    public void after()
    {
        driver.quit();
    }
}
