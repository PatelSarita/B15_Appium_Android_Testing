package com.mobile.tests.day03;

import com.mobile.tests.utilities.App;
import com.mobile.tests.utilities.Device;
import com.mobile.tests.utilities.Driver;
import com.mobile.tests.utilities.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.mobile.tests.utilities.Utils.*;

public class TC5_OpenApp implements ILocator {
    /*
    By l_digit_0=By.id("com.google.android.calculator:id/digit_0");
    By l_digit_1=By.id("com.google.android.calculator:id/digit_1");
    By l_digit_2=By.id("com.google.android.calculator:id/digit_2");
    By l_digit_3=By.id("com.google.android.calculator:id/digit_3");
    By l_digit_4=By.id("com.google.android.calculator:id/digit_4");
    By l_digit_5=By.id("com.google.android.calculator:id/digit_5");
    By l_digit_6=By.id("com.google.android.calculator:id/digit_6");
    By l_digit_7=By.id("com.google.android.calculator:id/digit_7");
    By l_digit_8=By.id("com.google.android.calculator:id/digit_8");
    By l_digit_9=By.id("com.google.android.calculator:id/digit_9");
    By l_op_add=By.id("com.google.android.calculator:id/op_add");
    By l_op_sub=By.id("com.google.android.calculator:id/op_sub");
    By l_op_mul=By.id("com.google.android.calculator:id/op_mul");
    By l_op_div=By.id("com.google.android.calculator:id/op_div");
    By l_eq=By.id("com.google.android.calculator:id/eq");
    By l_result_final=By.id("com.google.android.calculator:id/result_final");
    */
    AppiumDriver<MobileElement> driver;
    Device device=Device.PIXEL2;
    App app=App.CALCULATOR;

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
    public void t07_click_divide(){
        click(l_digit_7);
        click(l_digit_7);
        click(l_op_div);
        click(l_digit_1);
        click(l_digit_1);
        click(l_eq);
        Assert.assertEquals("7",getText(l_result_final));
    }

    @Test
    public void t08_click_sub(){
        getDigit(8).click();
        getDigit(1).click();
        click(l_op_sub);
        getDigit(5).click();
        getDigit(9).click();
        click(l_eq);
        Assert.assertEquals("22",getText(l_result_final));
    }



}