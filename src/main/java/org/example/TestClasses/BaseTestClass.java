package org.example.TestClasses;

import org.example.PageClasses.AddRemoveElementsPage;
import org.example.PageClasses.CheckboxesPage;
import org.example.PageClasses.Homepage;
import org.example.PageClasses.TextEditorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseTestClass {
    public WebDriver driver;
    Homepage homepage;
    AddRemoveElementsPage addRemoveElementsPage;
    CheckboxesPage checkboxesPage;
    TextEditorPage textEditorPage;
    public static final String BASE_URL = "https://the-internet.herokuapp.com/";

    @BeforeSuite
    public void setup(){
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        homepage = new Homepage(driver);
        addRemoveElementsPage = new AddRemoveElementsPage(driver);
        checkboxesPage = new CheckboxesPage(driver);
        textEditorPage = new TextEditorPage(driver);
    }

    @BeforeMethod
    public void precondition(){
        driver.get(BASE_URL);
    }

    @Test(priority = 1)
    public void elementsTest() throws InterruptedException {
        homepage.clickAddRemoveElements();
        for(int i = 0; i < 10; i++){
            addRemoveElementsPage.clickAddElementBtn();
        }

        //note: sleep for demo purpose only
        Thread.sleep(2500);
    }

    @Test(priority = 2)
    public void checkboxesTest() throws InterruptedException {
        //note: sleep for demo purpose only
        Thread.sleep(2500);

        homepage.clickCheckboxes();
        checkboxesPage.clickFirstCheckbox();

        Thread.sleep(2500);
    }

    @Test(priority = 3)
    public void textEditorTest() throws InterruptedException {
        homepage.clickEditor();
        textEditorPage.input("SELENIUM DEMO TESTING");

        //note: sleep for demo purpose only
        Thread.sleep(2500);
    }

    @AfterSuite
    public void teardown(){
        driver.quit();
    }
}
