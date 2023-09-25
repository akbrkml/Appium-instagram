package tests;

import java.util.HashMap;
import java.util.Map;

public class TestUtils {

    public Map<String, Object> setupInstagramParameter(String deviceName) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("deviceName", deviceName);
        parameter.put("platformName", "Android");
        parameter.put("automationName", "UiAutomator2");
        parameter.put("appPackage", "com.instagram.android");
        parameter.put("appActivity", "com.instagram.mainactivity.MainActivity");
        parameter.put("noReset", true);
        return parameter;
    }

    public Map<String, Object> setupFacebookParameter() {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("deviceName", "emulator-5554");
        parameter.put("platformName", "Android");
        parameter.put("automationName", "UiAutomator2");
        parameter.put("appPackage", "com.facebook.katana");
        parameter.put("appActivity", "com.facebook.mainactivity.MainActivity");
        parameter.put("noReset", true);
        return parameter;
    }

}
