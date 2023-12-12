package org.example.PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextEditorPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "mce_0_ifr")
    WebElement textEditorIFrame;

    @FindBy(xpath = "//body[@id='tinymce']")
    WebElement textEditor;

    public TextEditorPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void input(String s){
        wait.until(ExpectedConditions.visibilityOf(textEditorIFrame));
        driver.switchTo().frame(textEditorIFrame);
        wait.until(ExpectedConditions.elementToBeClickable(textEditor));
        textEditor.click();
        textEditor.sendKeys(s);
    }

    public WebElement getTextEditor() {
        return textEditor;
    }

    public WebElement getTextEditorIFrame() {
        return textEditorIFrame;
    }
}
