package org.example.PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homepage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[text()='Add/Remove Elements']")
    WebElement addRemoveElements;

    @FindBy(xpath = "//a[text()='Checkboxes']")
    WebElement checkboxes;

    @FindBy(xpath = "//a[text()='WYSIWYG Editor']")
    WebElement editor;

    public Homepage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickAddRemoveElements(){
        wait.until(ExpectedConditions.elementToBeClickable(addRemoveElements));
        addRemoveElements.click();
    }

    public void clickCheckboxes(){
        wait.until(ExpectedConditions.elementToBeClickable(checkboxes));
        checkboxes.click();
    }

    public void clickEditor(){
        wait.until(ExpectedConditions.elementToBeClickable(editor));
        editor.click();
    }

    public WebElement getAddRemoveElements() {
        return addRemoveElements;
    }

    public WebElement getCheckboxes() {
        return checkboxes;
    }

    public WebElement getEditor() {
        return editor;
    }
}
