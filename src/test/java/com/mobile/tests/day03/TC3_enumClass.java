package com.mobile.tests.day03;

import com.mobile.tests.utilities.App;
import com.mobile.tests.utilities.Device;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class TC3_enumClass {
    AppiumDriver<MobileElement> driver;

    AppiumDriverLocalService service;
    Device device=Device.PIXEL2;
    App app=App.CALCULATOR;
    @Test
    public void t04_appium_localService() throws MalformedURLException {

        service=new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                //.usingPort(1111)
                .usingAnyFreePort()
                .build();

        service.start();




        DesiredCapabilities capabilities=new DesiredCapabilities();
        //device info
        capabilities.setCapability("appium:udid",device.udid);
        capabilities.setCapability("appium:version",device.version);
        capabilities.setCapability("appium:deviceName",device.deviceName);
        capabilities.setCapability("platformName",device.platformName);

        //app info
        capabilities.setCapability("appPackage",app.appPackage);
        capabilities.setCapability("appActivity",app.appActivity);

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