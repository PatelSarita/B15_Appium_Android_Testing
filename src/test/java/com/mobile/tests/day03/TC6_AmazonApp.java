package com.mobile.tests.day03;

import com.mobile.tests.utilities.App;
import com.mobile.tests.utilities.Device;
import com.mobile.tests.utilities.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.List;

import static com.mobile.tests.utilities.Utils.openApp;

public class TC6_AmazonApp {
    /*
        Open the amazon app
        click skip sign in
        Search app watch series
     */
    AppiumDriver<MobileElement> driver;
    Device device=Device.PIXEL2;
    App app=App.AMAZON;
    @Before
    public void setUp() {
        driver= openApp(device,app);
    }

    @After
    public void tearDown() {
        driver.closeApp();
        Driver.stopService();
    }

    @Test
    public void t09_amazonSearch() throws InterruptedException {

        List<MobileElement> dontRemind = driver.findElements(By.id("com.amazon.mShop.android.shopping:id/checkBox"));

        if(dontRemind.size()>0){
            driver.findElement(By.id("com.amazon.mShop.android.shopping:id/checkBox")).click();
        }
        Thread.sleep(2000);

        //*[text()='Skip sign in']--> Selenium UI syntax
        //*[@text='Skip sign in']--> Selenium UI syntax

        MobileElement skipSignInBtn = driver.findElement(By.xpath("//*[@text='Skip sign in']"));
        skipSignInBtn.click();
        Thread.sleep(2000);
        MobileElement searchBox= driver.findElement(By.xpath("//*[@text='Search Amazon']"));
        searchBox.click();

        try {
            searchBox.sendKeys("apple watch series"+ Keys.ENTER);
        }catch (StaleElementReferenceException s){
            searchBox= driver.findElement(By.xpath("//*[@text='Search Amazon']"));
            searchBox.sendKeys("apple watch series"+Keys.ENTER);

        }
        Thread.sleep(2000);
    }
}