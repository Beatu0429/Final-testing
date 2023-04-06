package com.example.beatriznieves.extentReport;

import com.aventstack.extentreports.ExtentReports;

public class ExtentFactory {

    public static ExtentReports getInstance(){
        ExtentReports extent = new ExtentReports();
        extent.setSystemInfo("Selenium Version",  "4.3.0");
        extent.setSystemInfo("OS", "Windows");
        return extent;
    }
}
