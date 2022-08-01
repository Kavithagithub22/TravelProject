package com.Reusable;

import com.Baseclass.Browserfactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;


public class SeleniumReusable extends Browserfactory {
    public SeleniumReusable(WebDriver driver) {
        this.driver = driver;
    }


    public void To_Take_Screenshot(String path) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void get_Title() {
        System.out.println(driver.getTitle());

    }


    public void get_Current_url() {
        System.out.println(driver.getCurrentUrl());
    }


    public void Threadwait() throws InterruptedException {
        Thread.sleep(5000);
    }


    public void enter(WebElement element, String text) {
        element.sendKeys(text);
    }


    // 1. Wait for the element to be clickable ignoring the StaleElementReferenceException

    public boolean waitForElementToBeClickableBool(WebDriver driver, By attributeValue, int waitTime) {
        boolean flag = false;
        try {
            new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(attributeValue));
            flag = true;
            return flag;

        } catch (Exception Ex) {
            return flag;
        }
    }

    //  2. Wait for the Alert present ignoring the StaleElementReferenceException

    public boolean waitForAlertPresent(WebDriver driver, int waitTime) {
        boolean flag = false;
        new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.alertIsPresent());
        try {
            driver.switchTo().alert();
            return flag = true;
        } catch (Exception Ex) {
            return flag;
        }
    }



    //6. Move to Element and Click Action in Selenium

    public void MouseClickActionMoveToElement(WebDriver driver, By attributeValue) {
        try {
            int maxTimeout;
            if
                //The below method is defined above
            (waitForElementToBeClickableBool(driver, attributeValue, maxTimeout)) {
                WebElement element = driver.findElement(attributeValue);
                //element.click();
                Actions builder = new Actions(driver);
                builder.moveToElement(element).click().build().perform();
                System.out.println("Able to locate and click to element !")

            } else {
                System.out.println("Not able to locate the element !")
            }
        } catch (Exception Ex) {
            System.out.println("Exception occured");
        }
    }


       // 7. Get text from the element and return as string

        public String getTextFromElement(WebDriver driver, By locator) {
            String text = null;
            try {
                if (waitForElementToBePresentBool(driver, locator, maxTimeout)) {
                    WebElement element = driver.findElement(locator);
                    text = element.getText();
                    System.out.println("Element Text is: "+ text);

                } else {
                    System.out.println("Element not present !");

                }
            } catch (Exception Ex) {
                System.out.println("Exception occured");

            }
            return text;
        }


    //8. Get current system time

    public static int getcurrenttime() {
        long currentDateMS = new Date().getTime();
        int seconds = (int) ((currentDateMS / 1000) % 3600);
        return seconds;
    }

    //10. Select a value in dropdown by Text

    public static void dropDownSelectionByText(WebDriver driver, By dropDownID, String dropDownValue) {
        try {
            WebElement element = null;
            new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(dropDownID));
            element = driver.findElement(dropDownID);
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(dropDownValue);
        }
        catch (StaleElementReferenceException ex) {
            System.out.println("Exception while selecting a value from dropdown" + ex.getMessage());
        }
    }

        //11. Select a value in dropdown by Value

    public static void dropDownSelectionByValue(WebDriver driver, By dropDownID, String dropDownValue) {
        try {
            WebElement element = null;
            new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(dropDownID));
            element = driver.findElement(dropDownID);
            Select dropDown = new Select(element);
            dropDown.selectByValue(dropDownValue);
        }
        catch (StaleElementReferenceException ex) {
            System.out.println("Exception while selecting a value from dropdown" + ex.getMessage());
        }
    }


    //12. Select a value in dropdown by Index

    public static void dropDownSelectionByIndex(WebDriver driver, By dropDownID, int dropDownValue) {
        try {
            WebElement element = null;
            new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(dropDownID));
            element = driver.findElement(dropDownID);
            Select dropDown = new Select(element);
            dropDown.selectByIndex(dropDownValue);
        }
        catch (StaleElementReferenceException ex) {
            System.out.println("Exception while selecting a value from dropdown" + ex.getMessage());
        }
    }

    //16. This function will Canceling pop-up in Selenium-WebDriver

    public static String cancelPopupMessageBox(final WebDriver driver) {
        String message = null;
        try {
            Alert alert = driver.switchTo().alert();
            message = alert.getText();
            alert.dismiss();
        } catch (Exception e) {
            message = null;
        }
        return message;
    }

    //17. Selecting Radio Button in Selenium-WebDriver

    public static void selectRadioButton(WebDriver driver, By locator, String value){ List select = driver.findElements(locator);
        for (WebElement element : select)
        {
            if (element.getAttribute("value").equalsIgnoreCase(value)){
                element.click();
            }
        }

        //18. Selecting CheckBox in Selenium-WebDriver

        public static void selectCheckboxes(WebDriver driver, By locator,String value)
        {
            List abc = driver.findElements(locator);
            List list = new ArrayListArrays.asList(value.split(",")));
            for (String check : list){
                for (WebElement chk : abc){
                    if(chk.getAttribute("value").equalsIgnoreCase(check)){
                        chk.click();
                    }}}}


        //28. Drag and Drop action in Selenium Webdriver

        WebElement element = driver.findElement(By.name("source"));
        WebElement target = driver.findElement(By.name("target"));
        (new Actions(driver)).dragAndDrop(element, target).perform();


       // 29. Handling iFrame In Selenium WebDriver

            //Selecting index

        public void selectIFrameUsingIndex(WebDriver driver, int index) {

            driver.switchTo().frame(index);
        }

            //Using iframe name

        public void selectIFrameUsingIndex(WebDriver driver, String name) {

            driver.switchTo().frame(name);
        }

            //Using WebElement

        public void selectIFrameUsingIndex(WebDriver driver, WebElement element) {

            driver.switchTo().frame(element);
        }

 }

}

