package org.example.PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckboxesPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    WebElement firstCheckbox;

    public CheckboxesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickFirstCheckbox(){
        wait.until(ExpectedConditions.elementToBeClickable(firstCheckbox));
        firstCheckbox.click();
    }

    public WebElement getFirstCheckbox() {
        return firstCheckbox;
    }
}
