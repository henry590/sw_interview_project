package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckBoxPage;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

import java.util.concurrent.TimeUnit;

public class CheckBoxPageTest {
    CheckBoxPage checkBoxPage = new CheckBoxPage();

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("urlCheckBox"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Driver.getDriver().findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).click();
    }


    @Test
    public void checkboxTest() {
        checkBoxPage.allExamplesDropdown("Input Forms");
        checkBoxPage.subMenuDropdown("Checkbox Demo");
        Assert.assertEquals(checkBoxPage.singleCheckList(), "Success - Check box is checked");
    }

    @Test
    public void multiCheckBoxTest() {
        checkBoxPage.allExamplesDropdown("Input Forms");
        checkBoxPage.subMenuDropdown("Checkbox Demo");
        checkBoxPage.selectFromMultipleCheckList("Option 1");
        WebElement button = Driver.getDriver().findElement(By.xpath("//input[@id='check1']"));
        Assert.assertTrue(button.getAttribute("value").equals("Check All"));
    }

    @AfterMethod
    public void tearDown() {

        Driver.getDriver().close();
    }
}
