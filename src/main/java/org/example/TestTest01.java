package main.java.org.example;

import com.alibaba.fastjson2.JSONObject;
import org.testng.annotations.Test;

import java.awt.*;

public class TestTest01 {
    // C1
    @Test
    public void Test_Case_Title() {
        Toolkit Toolkit1 = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit1.getScreenSize();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("wide", screenSize.width);
        jsonObject.put("height", screenSize.height);
        System.out.println(jsonObject.get("wide"));
        System.out.println(jsonObject.get("height"));
    }
}
