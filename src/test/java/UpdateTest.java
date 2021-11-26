import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

public class UpdateTest {

    WebDriver driver;
    @Before
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "/home/marinex/Test/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8080/academia_war_exploded/login.html");
        WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
        SessionStorage storage = webStorage.getSessionStorage();
        storage.setItem("id","101");
        driver.navigate().to("http://127.0.0.1:8080/academia_war_exploded/update.html");
    }

    //valid input
    @Test
    public void updateTestcase1()
    {
        try
        {
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement desc =driver.findElement(By.className("desc"));
            desc.click();
            WebElement descField =driver.findElement(By.id("updatetxt"));
            setAttributeValue(driver,descField,"minlength","0");
            js.executeScript("arguments[0].required=false",descField);
            descField.sendKeys("Testcase1");
            WebElement submitBtn =driver.findElement(By.id("updateBill"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            submitBtn.click();
            Thread.sleep(3000);
            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");

            String expected = "display: none;";
            Assert.assertEquals("valid description",expected,actual);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    //empty string
    @Test
    public void updateTestcase2()
    {
        try
        {
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement desc =driver.findElement(By.className("desc"));
            desc.click();
            WebElement descField =driver.findElement(By.id("updatetxt"));
            setAttributeValue(driver,descField,"minlength","0");
            js.executeScript("arguments[0].required=false",descField);
            WebElement submitBtn =driver.findElement(By.id("updateBill"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            submitBtn.click();
            Thread.sleep(3000);
            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");

            String expected = "display: none;";
            Assert.assertEquals("invalid description",expected,actual);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTestcase3()
    {
        try
        {
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement desc =driver.findElement(By.className("amt"));
            desc.click();
            WebElement descField =driver.findElement(By.id("amttxt"));
            setAttributeValue(driver,descField,"min","0");
            js.executeScript("arguments[0].required=false",descField);
            descField.sendKeys("500");
            WebElement submitBtn =driver.findElement(By.id("updateBill"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            submitBtn.click();
            Thread.sleep(3000);
            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");

            String expected = "display: none;";
            Assert.assertEquals("amount valid",expected,actual);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    //empty string
    @Test
    public void updateTestcase4()
    {
        try
        {
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement desc =driver.findElement(By.className("amt"));
            desc.click();
            WebElement descField =driver.findElement(By.id("amttxt"));
            setAttributeValue(driver,descField,"min","0");
            js.executeScript("arguments[0].required=false",descField);
            WebElement submitBtn =driver.findElement(By.id("updateBill"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            submitBtn.click();
            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");

            String expected = "display: none;";
            Assert.assertEquals("amount empty",expected,actual);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTestcase5()
    {
        try
        {
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement desc =driver.findElement(By.className("amt"));
            desc.click();
            WebElement descField =driver.findElement(By.id("amttxt"));
            setAttributeValue(driver,descField,"minlength","0");
            setAttributeValue(driver,descField,"type","text");
            js.executeScript("arguments[0].required=false",descField);
            WebElement submitBtn =driver.findElement(By.id("updateBill"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            descField.sendKeys("hello");
            submitBtn.click();
            Thread.sleep(3000);

            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");
            System.out.println(actual);
            String expected = "display: block;";
            Assert.assertEquals("amount as string",expected,actual);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTestcase6()
    {
        try
        {
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement desc =driver.findElement(By.className("amt"));
            desc.click();
            WebElement descField =driver.findElement(By.id("amttxt"));
            setAttributeValue(driver,descField,"min","-123");

            js.executeScript("arguments[0].required=false",descField);
            WebElement submitBtn =driver.findElement(By.id("updateBill"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            descField.sendKeys("0");
            submitBtn.click();
            Thread.sleep(3000);

            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");
            System.out.println(actual);
            String expected = "display: block;";
            Assert.assertEquals("amount 0",expected,actual);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTestcase7()
    {
        try
        {
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement desc =driver.findElement(By.className("amt"));
            desc.click();
            WebElement descField =driver.findElement(By.id("amttxt"));
            setAttributeValue(driver,descField,"min","-123");

            js.executeScript("arguments[0].required=false",descField);
            WebElement submitBtn =driver.findElement(By.id("updateBill"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            descField.sendKeys("-1");
            submitBtn.click();
            Thread.sleep(3000);

            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");
            System.out.println(actual);
            String expected = "display: block;";
            Assert.assertEquals("negative amount",expected,actual);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTestcase8()
    {
        try
        {
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement desc =driver.findElement(By.className("dead"));
            desc.click();
            WebElement descField =driver.findElement(By.id("updatecalender"));
            setAttributeValue(driver,descField,"minlength","0");
            js.executeScript("arguments[0].required=false",descField);
            descField.sendKeys("11/30/2022");
            WebElement submitBtn =driver.findElement(By.id("updateBill"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            submitBtn.click();
            Thread.sleep(3000);
            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");

            String expected = "display: none;";
            Assert.assertEquals("valid deadline",expected,actual);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTestcase9()
    {
        try
        {
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement desc =driver.findElement(By.className("dead"));
            desc.click();
            WebElement descField =driver.findElement(By.id("updatecalender"));
            setAttributeValue(driver,descField,"minlength","0");
            js.executeScript("arguments[0].required=false",descField);
            descField.sendKeys("11/30/2022");
            WebElement submitBtn =driver.findElement(By.id("updateBill"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            submitBtn.click();
            Thread.sleep(3000);
            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");

            String expected = "display: none;";
            Assert.assertEquals("valid deadline",expected,actual);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTestcase10()
    {
        try
        {
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement desc =driver.findElement(By.className("dead"));
            desc.click();
            WebElement descField =driver.findElement(By.id("updatecalender"));
            setAttributeValue(driver,descField,"minlength","0");
            setAttributeValue(driver,descField,"type","text");
            js.executeScript("arguments[0].required=false",descField);
            descField.sendKeys("hello");
            WebElement submitBtn =driver.findElement(By.id("updateBill"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            submitBtn.click();
            Thread.sleep(3000);
            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");

            String expected = "display: block;";
            Assert.assertEquals("valid deadline",expected,actual);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTestcase11()
    {
        try
        {
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement desc =driver.findElement(By.className("desc"));
            WebElement amt =driver.findElement(By.className("amt"));
            WebElement dead =driver.findElement(By.className("dead"));
            desc.click();
            WebElement descField =driver.findElement(By.id("updatetxt"));
            WebElement amtField =driver.findElement(By.id("amttxt"));
            WebElement calField =driver.findElement(By.id("updatecalender"));
            setAttributeValue(driver,descField,"minlength","0");
            js.executeScript("arguments[0].required=false",descField);
            setAttributeValue(driver,amtField,"minlength","0");
            js.executeScript("arguments[0].required=false",amtField);
            setAttributeValue(driver,calField,"minlength","0");
            js.executeScript("arguments[0].required=false",calField);
            js.executeScript("arguments[0].style.display='block'",amtField);
            js.executeScript("arguments[0].style.display='block'",calField);

            descField.sendKeys("Testcase2");
            amtField.sendKeys("500");
            calField.sendKeys("11/22/201");
            WebElement submitBtn =driver.findElement(By.id("updateBill"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            submitBtn.click();
            Thread.sleep(3000);
            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");

            String expected = "display: none;";
            Assert.assertEquals("valid ",expected,actual);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTestcase12()
    {
        try
        {
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement desc =driver.findElement(By.className("desc"));
            WebElement amt =driver.findElement(By.className("amt"));
            WebElement dead =driver.findElement(By.className("dead"));
            amt.click();
            WebElement descField =driver.findElement(By.id("updatetxt"));
            WebElement amtField =driver.findElement(By.id("amttxt"));
            WebElement calField =driver.findElement(By.id("updatecalender"));
            setAttributeValue(driver,descField,"minlength","0");
            js.executeScript("arguments[0].required=false",descField);
            setAttributeValue(driver,amtField,"minlength","0");
            js.executeScript("arguments[0].required=false",amtField);
            setAttributeValue(driver,calField,"minlength","0");
            js.executeScript("arguments[0].required=false",calField);
            js.executeScript("arguments[0].style.display='block'",descField);
            js.executeScript("arguments[0].style.display='block'",calField);

            descField.sendKeys("testcase 3");
            amtField.sendKeys("500");
            calField.sendKeys("11/22/201");
            WebElement submitBtn =driver.findElement(By.id("updateBill"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            submitBtn.click();
            Thread.sleep(3000);
            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");

            String expected = "display: none;";
            Assert.assertEquals("valid ",expected,actual);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTestcase13()
    {
        try
        {
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement desc =driver.findElement(By.className("desc"));
            WebElement amt =driver.findElement(By.className("amt"));
            WebElement dead =driver.findElement(By.className("dead"));
            dead.click();
            WebElement descField =driver.findElement(By.id("updatetxt"));
            WebElement amtField =driver.findElement(By.id("amttxt"));
            WebElement calField =driver.findElement(By.id("updatecalender"));
            setAttributeValue(driver,descField,"minlength","0");
            js.executeScript("arguments[0].required=false",descField);
            setAttributeValue(driver,amtField,"minlength","0");
            js.executeScript("arguments[0].required=false",amtField);
            setAttributeValue(driver,calField,"minlength","0");
            js.executeScript("arguments[0].required=false",calField);
            js.executeScript("arguments[0].style.display='block'",amtField);
            js.executeScript("arguments[0].style.display='block'",descField);

            descField.sendKeys("Testcase2");
            amtField.sendKeys("500");
            calField.sendKeys("11/22/201");
            WebElement submitBtn =driver.findElement(By.id("updateBill"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            submitBtn.click();
            Thread.sleep(3000);
            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");

            String expected = "display: none;";
            Assert.assertEquals("valid ",expected,actual);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTestcase14()
    {
        try
        {
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement desc =driver.findElement(By.className("desc"));
            WebElement amt =driver.findElement(By.className("amt"));
            WebElement dead =driver.findElement(By.className("dead"));
            amt.click();

            WebElement amtField =driver.findElement(By.id("amttxt"));
            WebElement calField =driver.findElement(By.id("updatecalender"));

            setAttributeValue(driver,amtField,"minlength","0");
            js.executeScript("arguments[0].required=false",amtField);
            setAttributeValue(driver,calField,"minlength","0");
            js.executeScript("arguments[0].required=false",calField);

            js.executeScript("arguments[0].style.display='block'",calField);


            amtField.sendKeys("5020");
            calField.sendKeys("11/22/2022");
            WebElement submitBtn =driver.findElement(By.id("updateBill"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            submitBtn.click();
            Thread.sleep(3000);
            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");

            String expected = "display: none;";
            Assert.assertEquals("valid description",expected,actual);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTestcase15()
    {
        try
        {
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement desc =driver.findElement(By.className("desc"));
            WebElement amt =driver.findElement(By.className("amt"));
            WebElement dead =driver.findElement(By.className("dead"));
            dead.click();

            WebElement amtField =driver.findElement(By.id("amttxt"));
            WebElement calField =driver.findElement(By.id("updatecalender"));

            setAttributeValue(driver,amtField,"minlength","0");
            js.executeScript("arguments[0].required=false",amtField);
            setAttributeValue(driver,calField,"minlength","0");
            js.executeScript("arguments[0].required=false",calField);

            js.executeScript("arguments[0].style.display='block'",amtField);


            amtField.sendKeys("5020");
            calField.sendKeys("11/22/2022");
            WebElement submitBtn =driver.findElement(By.id("updateBill"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            submitBtn.click();
            Thread.sleep(3000);
            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");

            String expected = "display: none;";
            Assert.assertEquals("valid description",expected,actual);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }







    @After
    public void finish()
    {
        driver.quit();
    }
    public void setAttributeValue(WebDriver driver,WebElement elem, String attr,String value){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",elem,attr,value);
    }

}
