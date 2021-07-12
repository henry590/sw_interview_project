package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.Driver;

public class CheckBoxPage {

    public void allExamplesDropdown(String value) {
        Driver.getDriver().findElement(By.xpath("//li[@class='tree-branch']//a[contains(text(),'" + value + "')]")).click();
    }

    public void subMenuDropdown(String value) {
        Driver.getDriver().findElement(By.xpath("//li[@class='tree-branch']//a[contains(text(),'" + value + "')]")).click();
    }

    public String singleCheckList() {
        WebElement singleCheckbox = Driver.getDriver().findElement(By.id("isAgeSelected"));
        WebElement checkmessage = Driver.getDriver().findElement(By.id("txtAge"));
        if (!singleCheckbox.isSelected()) {
            singleCheckbox.click();
        }
        return checkmessage.getText();

    }

    public void selectFromMultipleCheckList(String value) {
        Driver.getDriver().findElement(By.xpath("//label[text()='" + value + "']")).click();
    }




}