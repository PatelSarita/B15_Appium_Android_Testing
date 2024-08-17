package com.mobile.tests.day02;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TC1_Calculator {

    AppiumDriver<MobileElement> driver;
    @Test
    public void t01_connectToCalculator() throws MalformedURLException {
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

        driver=new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

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

    }
    @Test
    public void t02_multiplyTest() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        //2. way
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.VERSION,"11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"pixel_2");
        capabilities.setCapability("appPackage","com.google.android.calculator");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");

        driver=new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        MobileElement digit_6= driver.findElement(By.id("com.google.android.calculator:id/digit_6"));
        MobileElement multiply_Btn= driver.findElement(By.id("com.google.android.calculator:id/op_mul"));
        MobileElement digit_8= driver.findElement(By.id("com.google.android.calculator:id/digit_8"));
        MobileElement eq_Btn= driver.findElement(By.id("com.google.android.calculator:id/eq"));
        // digit_6.click();
        getDigit(6).click();
        multiply_Btn.click();
        //digit_8.click();
        getDigit(8).click();
        eq_Btn.click();

        MobileElement result_final= driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        String actualResult=result_final.getText();
        Assert.assertEquals("48",actualResult);
        driver.closeApp();

    }

    /*
        Homework
        Create a method, it accept int
        And return type is Mobile element
        When we call this method , which number we provide it will return that number's mobile element
     */

    public MobileElement getDigit(int digit){
        return driver.findElement(By.id("com.google.android.calculator:id/digit_" + digit));
    }

}
