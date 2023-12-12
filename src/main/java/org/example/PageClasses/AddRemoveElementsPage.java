package org.example.PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddRemoveElementsPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//button[@onclick='addElement()']")
    WebElement addElementBtn;

    public AddRemoveElementsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickAddElementBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(addElementBtn));
        addElementBtn.click();
    }

    public WebElement getAddElementBtn() {
        return addElementBtn;
    }
}
