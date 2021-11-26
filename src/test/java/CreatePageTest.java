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
    //Correct input
    @Test
    public void createPageTestCase1()
    {
        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement dropDownBtn = driver.findElement(By.id("dropdownMenuButton"));

            dropDownBtn.click();
            WebElement studentBtn = driver.findElement(By.id("student"));
            studentBtn.click();
            WebElement descriptionField = driver.findElement(By.id("desc_t"));
            WebElement domainField = driver.findElement(By.id("domainid"));
            WebElement rollField = driver.findElement(By.id("rollno"));
            WebElement amountField = driver.findElement(By.id("amount"));
            WebElement deadlineField = driver.findElement(By.id("deadline"));

            setAttributeValue(driver,rollField,"minlength","0");
            setAttributeValue(driver,amountField,"min","0");
            setAttributeValue(driver,descriptionField,"minlength","0");
            js.executeScript("arguments[0].required=false",descriptionField);

            rollField.sendKeys("MT2020106");
            descriptionField.sendKeys("Testcase");
            amountField.sendKeys("1000");
            deadlineField.sendKeys("11/30/2021");

            WebElement submitBtn = driver.findElement(By.id("submit"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            submitBtn.click();
            Thread.sleep(2000);
            WebElement dangerTag = driver.findElement(By.id("alert"));
            String actual = dangerTag.getAttribute("style");

            String expected = "display: block;";
            Assert.assertEquals("correct input",actual,expected);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    //Description empty
    @Test
    public void createPageTestCase2()
    {
        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement dropDownBtn = driver.findElement(By.id("dropdownMenuButton"));

            dropDownBtn.click();
            WebElement studentBtn = driver.findElement(By.id("student"));
            studentBtn.click();
            WebElement descriptionField = driver.findElement(By.id("desc_t"));
            WebElement domainField = driver.findElement(By.id("domainid"));
            WebElement rollField = driver.findElement(By.id("rollno"));
            WebElement amountField = driver.findElement(By.id("amount"));
            WebElement deadlineField = driver.findElement(By.id("deadline"));

            setAttributeValue(driver,rollField,"minlength","0");
            setAttributeValue(driver,amountField,"min","0");
            setAttributeValue(driver,descriptionField,"minlength","0");
            js.executeScript("arguments[0].required=false",descriptionField);

            rollField.sendKeys("MT2020106");
            amountField.sendKeys("1000");
            deadlineField.sendKeys("11/30/2021");

            WebElement submitBtn = driver.findElement(By.id("submit"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            submitBtn.click();
            Thread.sleep(2000);
            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");

            String expected = "display: block;";
            Assert.assertEquals("description empty",actual,expected);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    //Roll no empty
    @Test
    public void createPageTestCase3()
    {
        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement dropDownBtn = driver.findElement(By.id("dropdownMenuButton"));

            dropDownBtn.click();
            WebElement studentBtn = driver.findElement(By.id("student"));
            studentBtn.click();
            WebElement descriptionField = driver.findElement(By.id("desc_t"));
            WebElement domainField = driver.findElement(By.id("domainid"));
            WebElement rollField = driver.findElement(By.id("rollno"));
            WebElement amountField = driver.findElement(By.id("amount"));
            WebElement deadlineField = driver.findElement(By.id("deadline"));

            setAttributeValue(driver,rollField,"minlength","0");
            setAttributeValue(driver,amountField,"min","0");
            setAttributeValue(driver,descriptionField,"minlength","0");
            js.executeScript("arguments[0].required=false",descriptionField);


            descriptionField.sendKeys("Testcase");
            amountField.sendKeys("1000");
            deadlineField.sendKeys("11/30/2021");

            WebElement submitBtn = driver.findElement(By.id("submit"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            submitBtn.click();
            Thread.sleep(2000);
            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");

            String expected = "display: block;";
            Assert.assertEquals("roll no empty",actual,expected);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    //amount empty
    @Test
    public void createPageTestCase4()
    {
        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement dropDownBtn = driver.findElement(By.id("dropdownMenuButton"));

            dropDownBtn.click();
            WebElement studentBtn = driver.findElement(By.id("student"));
            studentBtn.click();
            WebElement descriptionField = driver.findElement(By.id("desc_t"));
            WebElement domainField = driver.findElement(By.id("domainid"));
            WebElement rollField = driver.findElement(By.id("rollno"));
            WebElement amountField = driver.findElement(By.id("amount"));
            WebElement deadlineField = driver.findElement(By.id("deadline"));

            setAttributeValue(driver,rollField,"minlength","0");
            setAttributeValue(driver,amountField,"min","0");
            setAttributeValue(driver,descriptionField,"minlength","0");
            js.executeScript("arguments[0].required=false",descriptionField);

            rollField.sendKeys("MT2020106");
            descriptionField.sendKeys("Testcase");

            deadlineField.sendKeys("11/30/2021");

            WebElement submitBtn = driver.findElement(By.id("submit"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            submitBtn.click();
            Thread.sleep(2000);
            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");

            String expected = "display: block;";
            Assert.assertEquals("amount empty",actual,expected);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    //deadline empty
    @Test
    public void createPageTestCase5()
    {
        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement dropDownBtn = driver.findElement(By.id("dropdownMenuButton"));

            dropDownBtn.click();
            WebElement studentBtn = driver.findElement(By.id("student"));
            studentBtn.click();
            WebElement descriptionField = driver.findElement(By.id("desc_t"));
            WebElement domainField = driver.findElement(By.id("domainid"));
            WebElement rollField = driver.findElement(By.id("rollno"));
            WebElement amountField = driver.findElement(By.id("amount"));
            WebElement deadlineField = driver.findElement(By.id("deadline"));

            setAttributeValue(driver,rollField,"minlength","0");
            setAttributeValue(driver,amountField,"min","0");
            setAttributeValue(driver,descriptionField,"minlength","0");
            js.executeScript("arguments[0].required=false",descriptionField);

            rollField.sendKeys("MT2020106");
            descriptionField.sendKeys("Testcase");
            amountField.sendKeys("1000");

            WebElement submitBtn = driver.findElement(By.id("submit"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            submitBtn.click();
            Thread.sleep(2000);
            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");

            String expected = "display: block;";
            Assert.assertEquals("deadline empty",actual,expected);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    //amount negative
    @Test
    public void createPageTestCase6()
    {
        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement dropDownBtn = driver.findElement(By.id("dropdownMenuButton"));

            dropDownBtn.click();
            WebElement studentBtn = driver.findElement(By.id("student"));
            studentBtn.click();
            WebElement descriptionField = driver.findElement(By.id("desc_t"));
            WebElement domainField = driver.findElement(By.id("domainid"));
            WebElement rollField = driver.findElement(By.id("rollno"));
            WebElement amountField = driver.findElement(By.id("amount"));
            WebElement deadlineField = driver.findElement(By.id("deadline"));

            setAttributeValue(driver,rollField,"minlength","0");
            setAttributeValue(driver,amountField,"min","-123");
            setAttributeValue(driver,descriptionField,"minlength","0");
            js.executeScript("arguments[0].required=false",descriptionField);

            rollField.sendKeys("MT2020106");
            descriptionField.sendKeys("Testcase");
            amountField.sendKeys("-1");
            deadlineField.sendKeys("11/30/2021");

            WebElement submitBtn = driver.findElement(By.id("submit"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            submitBtn.click();
            Thread.sleep(2000);
            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");

            String expected = "display: block;";
            Assert.assertEquals("amount negative",actual,expected);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    //string in amount
    @Test
    public void createPageTestCase7()
    {
        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement dropDownBtn = driver.findElement(By.id("dropdownMenuButton"));

            dropDownBtn.click();
            WebElement studentBtn = driver.findElement(By.id("student"));
            studentBtn.click();
            WebElement descriptionField = driver.findElement(By.id("desc_t"));
            WebElement domainField = driver.findElement(By.id("domainid"));
            WebElement rollField = driver.findElement(By.id("rollno"));
            WebElement amountField = driver.findElement(By.id("amount"));
            WebElement deadlineField = driver.findElement(By.id("deadline"));

            setAttributeValue(driver,rollField,"minlength","0");
            setAttributeValue(driver,amountField,"min","0");
            setAttributeValue(driver,descriptionField,"minlength","0");
            setAttributeValue(driver,amountField,"type","text");
            js.executeScript("arguments[0].required=false",descriptionField);

            rollField.sendKeys("MT2020106");
            descriptionField.sendKeys("Testcase");
            amountField.sendKeys("hello");
            deadlineField.sendKeys("11/30/2021");

            WebElement submitBtn = driver.findElement(By.id("submit"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            submitBtn.click();
            Thread.sleep(2000);
            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");

            String expected = "display: block;";
            Assert.assertEquals("amount string",actual,expected);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    //deadline string
    @Test
    public void createPageTestCase8()
    {
        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement dropDownBtn = driver.findElement(By.id("dropdownMenuButton"));

            dropDownBtn.click();
            WebElement studentBtn = driver.findElement(By.id("student"));
            studentBtn.click();
            WebElement descriptionField = driver.findElement(By.id("desc_t"));
            WebElement domainField = driver.findElement(By.id("domainid"));
            WebElement rollField = driver.findElement(By.id("rollno"));
            WebElement amountField = driver.findElement(By.id("amount"));
            WebElement deadlineField = driver.findElement(By.id("deadline"));

            setAttributeValue(driver,rollField,"minlength","0");
            setAttributeValue(driver,amountField,"min","0");
            setAttributeValue(driver,descriptionField,"minlength","0");
            js.executeScript("arguments[0].required=false",descriptionField);
            setAttributeValue(driver,deadlineField,"type","text");
            rollField.sendKeys("MT2020106");
            descriptionField.sendKeys("Testcase");
            amountField.sendKeys("1000");
            deadlineField.sendKeys("hello");

            WebElement submitBtn = driver.findElement(By.id("submit"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            submitBtn.click();
            Thread.sleep(2000);
            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");

            String expected = "display: block;";
            Assert.assertEquals("deadline string",actual,expected);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }









    //domain valid input
    @Test
    public void createPageTestCase9()
    {
        try
        {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement descriptionField = driver.findElement(By.id("desc_t"));
        WebElement domainField = driver.findElement(By.id("domainid"));
        WebElement rollField = driver.findElement(By.id("rollno"));
        WebElement amountField = driver.findElement(By.id("amount"));
        WebElement deadlineField = driver.findElement(By.id("deadline"));

        setAttributeValue(driver,rollField,"minlength","0");
        setAttributeValue(driver,amountField,"min","0");
        setAttributeValue(driver,descriptionField,"minlength","0");
        setAttributeValue(driver,amountField,"type","text");
        js.executeScript("arguments[0].required=false",descriptionField);

        domainField.sendKeys("MT2020");
        descriptionField.sendKeys("Testcase");
        amountField.sendKeys("1000");
        deadlineField.sendKeys("11/30/2021");

        WebElement submitBtn = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].disabled=false",submitBtn);
        js.executeScript("arguments[0].style.opacity=1",submitBtn);
        submitBtn.click();
        Thread.sleep(2000);
        WebElement dangerTag = driver.findElement(By.id("alert"));
        String actual = dangerTag.getAttribute("style");

        String expected = "display: block;";
        Assert.assertEquals("domain valid input",actual,expected);
         }
        catch (Exception e)
        {
        System.out.println(e.getMessage());
        }
    }

    //domain invalid input
    @Test
    public void createPageTestCase10()
    {
        try
        {

            JavascriptExecutor js = (JavascriptExecutor) driver;

            WebElement descriptionField = driver.findElement(By.id("desc_t"));
            WebElement domainField = driver.findElement(By.id("domainid"));
            WebElement rollField = driver.findElement(By.id("rollno"));
            WebElement amountField = driver.findElement(By.id("amount"));
            WebElement deadlineField = driver.findElement(By.id("deadline"));

            setAttributeValue(driver,rollField,"minlength","0");
            setAttributeValue(driver,amountField,"min","0");
            setAttributeValue(driver,descriptionField,"minlength","0");
            setAttributeValue(driver,amountField,"type","text");
            js.executeScript("arguments[0].required=false",descriptionField);

            domainField.sendKeys("1223");
            descriptionField.sendKeys("inavlid input");
            amountField.sendKeys("1000");
            deadlineField.sendKeys("11/30/2021");

            WebElement submitBtn = driver.findElement(By.id("submit"));
            js.executeScript("arguments[0].disabled=false",submitBtn);
            js.executeScript("arguments[0].style.opacity=1",submitBtn);
            submitBtn.click();
            Thread.sleep(2000);
            WebElement dangerTag = driver.findElement(By.id("danger"));
            String actual = dangerTag.getAttribute("style");

            String expected = "display: block;";
            Assert.assertEquals("domain invalid input",actual,expected);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }







    public void setAttributeValue(WebDriver driver,WebElement elem, String attr,String value){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",elem,attr,value);
    }

    @After
    public void after()
    {

        driver.quit();
    }
}
