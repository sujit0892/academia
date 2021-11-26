import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import java.time.Duration;


public class LoginTest {

    WebDriver driver;
    @Before
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "/home/marinex/Test/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8080/academia_war_exploded/login.html");
    }
    /*
    constraint:
    Email : email validity
    Password: minlength = 8
     */

    //Normal Login
    @Test
    public void LoginTestCase1() {


        try {



            WebElement username = driver.findElement(By.id("email"));


            WebElement password = driver.findElement(By.id("password"));

            WebElement login = driver.findElement(By.id("login"));
            setAttributeValue(driver,username,"type","text");
            setAttributeValue(driver,password,"minlength","0");
            System.out.println("TYPE "+username.getAttribute("type"));
            username.sendKeys("placement@iiitb.org");
            password.sendKeys("12345678");
            login.click();
            String actualUrl = "http://127.0.0.1:8080/academia_war_exploded/create.html";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
            Thread.sleep(2000);
            String expectedUrl = driver.getCurrentUrl();
            System.out.println(expectedUrl);

            //Assert.assertEquals(loggedInUser.getText(),"PAVEL007");
            Assert.assertEquals(expectedUrl,actualUrl);

        } catch (Exception e) {

        }
    }

    // voilates email constaraint
    // voilates password constrant
    @Test
    public void LoginTestCase2() {

        try {


            WebElement username = driver.findElement(By.id("email"));


            WebElement password = driver.findElement(By.id("password"));

            WebElement login = driver.findElement(By.id("login"));
            setAttributeValue(driver,username,"type","text");
            setAttributeValue(driver,password,"minlength","0");

            System.out.println("TYPE "+username.getAttribute("type"));
            username.sendKeys("1234");
            password.sendKeys("123");
            login.click();
            String actualUrl = "http://127.0.0.1:8080/academia_war_exploded/login.html";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
            Thread.sleep(2000);
            String expectedUrl = driver.getCurrentUrl();
            System.out.println(expectedUrl);

            //Assert.assertEquals(loggedInUser.getText(),"PAVEL007");
            Assert.assertEquals(expectedUrl,actualUrl);


        } catch (Exception e) {

        }
    }



    //invalid character
    @Test
    public void LoginTestCase3() {

        try {

            WebElement username = driver.findElement(By.id("email"));


            WebElement password = driver.findElement(By.id("password"));

            WebElement login = driver.findElement(By.id("login"));
            setAttributeValue(driver,username,"type","text");
            setAttributeValue(driver,password,"minlength","0");

            System.out.println("TYPE "+username.getAttribute("type"));
            username.sendKeys("placemet,>");
            password.sendKeys("123");
            login.click();
            String actualUrl = "http://127.0.0.1:8080/academia_war_exploded/login.html";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
            Thread.sleep(2000);
            String expectedUrl = driver.getCurrentUrl();
            System.out.println(expectedUrl);

            //Assert.assertEquals(loggedInUser.getText(),"PAVEL007");
            Assert.assertEquals(expectedUrl,actualUrl);
        } catch (Exception e) {

        }
    }

    //sql injection
    @Test
    public void LoginTestCase4() {

        try {



            WebElement username = driver.findElement(By.id("email"));


            WebElement password = driver.findElement(By.id("password"));

            WebElement login = driver.findElement(By.id("login"));
            setAttributeValue(driver,username,"type","text");
            setAttributeValue(driver,password,"minlength","0");
            System.out.println("TYPE "+username.getAttribute("type"));
            username.sendKeys("placemet OR '1'='1'");
            password.sendKeys("123 OR '1'='1'");
            login.click();
            String actualUrl = "http://127.0.0.1:8080/academia_war_exploded/login.html";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
            Thread.sleep(2000);
            String expectedUrl = driver.getCurrentUrl();
            System.out.println(expectedUrl);

            //Assert.assertEquals(loggedInUser.getText(),"PAVEL007");
            Assert.assertEquals(expectedUrl,actualUrl);

        } catch (Exception e) {

        }
    }

    @Test
    public void LoginTestCase5()
    {
        System.setProperty("webdriver.chrome.driver", "/home/marinex/Test/chromedriver");
        driver = new ChromeDriver();



        driver.get("http://127.0.0.1:8080/academia_war_exploded/login.html");
        WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
        SessionStorage storage = webStorage.getSessionStorage();
        storage.setItem("id","101");
        driver.navigate().to("http://127.0.0.1:8080/academia_war_exploded/create.html");



        try{

            String actualUrl = "http://127.0.0.1:8080/academia_war_exploded/login.html";
            Thread.sleep(2000);
            String expectedUrl = driver.getCurrentUrl();
            Assert.assertEquals(expectedUrl,actualUrl);
        }catch (Exception e)
        {

        }




    }
    public void setAttributeValue(WebDriver driver,WebElement elem, String attr,String value){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",elem,attr,value);
    }


//
   @After
    public void quit()
    {
        driver.quit();
    }




}