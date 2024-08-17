package com.mobile.tests.day02;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TC2_Set_Service {
    AppiumDriver<MobileElement> driver;

    AppiumDriverLocalService service;
    @Test
    public void t03_appium_localService() throws MalformedURLException {

        service=new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                //.usingPort(1111)
                .usingAnyFreePort()
                .build();

        service.start();




        DesiredCapabilities capabilities=new DesiredCapabilities();
        //device info
        capabilities.setCapability("appium:udid","emulator-5554");
        capabilities.setCapability("appium:version","11.0");
        capabilities.setCapability("appium:deviceName","pixel_2");
        capabilities.setCapability("platformName","Android");

        //app info
        /** to take app info
         * open emulator
         * open app
         * open command line
         * type =>  adb shell + enter
         * type => dumpsys window | grep -E mCurrentFocus + enter
         * mCurrentFocus=Window{6e3b0dd u0 com.google.android.calculator/com.android.calculator2.Calculator}
         */
        capabilities.setCapability("appPackage","com.google.android.calculator");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");

        driver=new AppiumDriver<MobileElement>(service.getUrl(),capabilities);

        MobileElement digit_5= driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        MobileElement plus_Btn= driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        MobileElement digit_9= driver.findElement(By.id("com.google.android.calculator:id/digit_9"));
        MobileElement eq_Btn= driver.findElement(By.id("com.google.android.calculator:id/eq"));
        digit_5.click();
        plus_Btn.click();
        digit_9.click();
        eq_Btn.click();

        MobileElement result_final= driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        String actualResult=result_final.getText();
        Assert.assertEquals("14",actualResult);
        driver.closeApp();
        service.stop();

    }
}

