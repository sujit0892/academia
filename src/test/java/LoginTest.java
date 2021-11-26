import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import java.time.Duration;


public class LoginTest {
//	public static void main(String[] args) {
//    	
//    }

    @Test
    public void TestCase1() {

        System.setProperty("webdriver.chrome.driver", "/home/marinex/Test/chromedriver");
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("http://127.0.0.1:8080/academia_war_exploded/login.html");


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

        } finally {
            driver.quit();
        }
    }

    @Test
    public void TestCase2() {
        System.setProperty("webdriver.gecko.driver", "/home/marinex/Test/geckodriver");
//		FirefoxOptions options = new FirefoxOptions();
//		options.setCapability("marionette", true);
        System.setProperty("webdriver.chrome.driver", "/home/marinex/Test/chromedriver");
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("http://127.0.0.1:8080/academia_war_exploded/login.html");


            WebElement username = driver.findElement(By.id("email"));


            WebElement password = driver.findElement(By.id("password"));

            WebElement login = driver.findElement(By.id("login"));
            setAttributeValue(driver,username,"type","text");
            setAttributeValue(driver,password,"minlength","0");

            System.out.println("TYPE "+username.getAttribute("type"));
            username.sendKeys("1234");
            password.sendKeys("123");
            login.click();
            String actualUrl = "http://127.0.0.1:8080/academia_war_exploded/create.html";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
            Thread.sleep(2000);
            String expectedUrl = driver.getCurrentUrl();
            System.out.println(expectedUrl);

            //Assert.assertEquals(loggedInUser.getText(),"PAVEL007");
            Assert.assertEquals(expectedUrl,actualUrl);


        } catch (Exception e) {

        } finally {
            driver.quit();
        }
    }

    @Test
    public void TestCase3() {
        System.setProperty("webdriver.gecko.driver", "/home/marinex/Test/geckodriver");
//		FirefoxOptions options = new FirefoxOptions();
//		options.setCapability("marionette", true);
        System.setProperty("webdriver.chrome.driver", "/home/marinex/Test/chromedriver");
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("http://127.0.0.1:8080/academia_war_exploded/login.html");


            WebElement username = driver.findElement(By.id("email"));


            WebElement password = driver.findElement(By.id("password"));

            WebElement login = driver.findElement(By.id("login"));
            setAttributeValue(driver,username,"type","text");
            setAttributeValue(driver,password,"minlength","0");

            System.out.println("TYPE "+username.getAttribute("type"));
            username.sendKeys("placemet<");
            password.sendKeys("123");
            login.click();
            String actualUrl = "http://127.0.0.1:8080/academia_war_exploded/create.html";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
            Thread.sleep(2000);
            String expectedUrl = driver.getCurrentUrl();
            System.out.println(expectedUrl);

            //Assert.assertEquals(loggedInUser.getText(),"PAVEL007");
            Assert.assertEquals(expectedUrl,actualUrl);
        } catch (Exception e) {

        } finally {
            driver.quit();
        }
    }

    @Test
    public void TestCase4() {
        System.setProperty("webdriver.gecko.driver", "/home/marinex/Test/geckodriver");
//		FirefoxOptions options = new FirefoxOptions();
//		options.setCapability("marionette", true);
        System.setProperty("webdriver.chrome.driver", "/home/marinex/Test/chromedriver");
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("http://127.0.0.1:8080/academia_war_exploded/login.html");


            WebElement username = driver.findElement(By.id("email"));


            WebElement password = driver.findElement(By.id("password"));

            WebElement login = driver.findElement(By.id("login"));
            setAttributeValue(driver,username,"type","text");
            setAttributeValue(driver,password,"minlength","0");
            System.out.println("TYPE "+username.getAttribute("type"));
            username.sendKeys("placemet OR '1'='1'");
            password.sendKeys("123 OR '1'='1'");
            login.click();
            String actualUrl = "http://127.0.0.1:8080/academia_war_exploded/create.html";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
            Thread.sleep(2000);
            String expectedUrl = driver.getCurrentUrl();
            System.out.println(expectedUrl);

            //Assert.assertEquals(loggedInUser.getText(),"PAVEL007");
            Assert.assertEquals(expectedUrl,actualUrl);

        } catch (Exception e) {

        } finally {
            driver.quit();
        }
    }
    public void setAttributeValue(WebDriver driver,WebElement elem, String attr,String value){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",elem,attr,value);
    }




}