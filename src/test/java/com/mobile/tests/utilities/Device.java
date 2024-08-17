package com.mobile.tests.utilities;

public enum Device {

    PIXEL2("emulator-5554",
            "11.0",
            "pixel_2",
            "Android"),
    SAMSUNG_NQ("RCZT7890MY",
            "5.0",
            "My Phone",
            "Android");
    public String udid;
    public String version;
    public String deviceName;
    public String platformName;

    Device(String udid, String version, String deviceName, String platformName) {
        this.udid=udid;
        this.version=version;
        this.deviceName=deviceName;
        this.platformName=platformName;
    }
}
