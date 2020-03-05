package com.google.instrumenttest;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class UIActivityTest {
    private static final String PACKAGE_ESPRESSOTESTS = "me.shihao.espressotests";
    private static final String PACKAGE_SETTING = "com.android.settings";

    @Test
    public void testEspressoTestsApp() throws Exception {
        //初始化一个UiDevice对象
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        // 点击home键，回到home界面
        mDevice.pressHome();
        String launcherPackage = mDevice.getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), 3);

        // 启动espressotests App
//        Context context = InstrumentationRegistry.getContext();
//        Intent intent = context.getPackageManager().getLaunchIntentForPackage(PACKAGE_ESPRESSOTESTS);
//        // 清除以前的实例
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        context.startActivity(intent);
//
//        // 等待应用程序启动
//        mDevice.wait(Until.hasObject(By.pkg(PACKAGE_ESPRESSOTESTS).depth(0)), 3);
//        //通过id找到输入框一
//        UiObject edt1 = mDevice.findObject(new UiSelector().resourceId("me.shihao.espressotests:id/editText")
//                .className(EditText.class));
//        //往里面输入字符2
//        edt1.setText("2");
//        //通过id找到输入框二
//        UiObject edt2 = mDevice.findObject(new UiSelector().resourceId("me.shihao.espressotests:id/editText2")
//                .className(EditText.class));
//        //往里面输入5
//        edt2.setText("5");
//        //通过文本"计算"找到按钮
//        UiObject btn = mDevice.findObject(new UiSelector().text("计算").className(Button.class));
//        //执行点击事件，计算结果
//        btn.click();
//        //通过id找到显示结果的textview
//        UiObject tvResult = mDevice.findObject(new UiSelector().resourceId("me.shihao.espressotests:id/textView")
//                .className(TextView.class));
//        //判断结果与预期是否匹配
//        assertEquals(tvResult.getText(), "计算结果：7");
//        //通过文本"RecycleView"找到按钮
//        UiObject btnRecycleView = mDevice.findObject(new UiSelector().text("RecycleView").className(Button.class));
//        //执行点击事件跳转到另一个界面
//        btnRecycleView.click();
//        //通过id找到recycleview
//        UiScrollable recycleview = new UiScrollable(new UiSelector()
//                .className(RecyclerView.class)
//                .resourceId("me.shihao.espressotests:id/recycleview"));
//        //滑动到底部
//        recycleview.flingForward();
//        //滑动到顶部
//        recycleview.flingBackward();
//        UiObject item5 = recycleview.getChild(new UiSelector().text("Item 5"));
//        //点击Item 5，然后会弹出一个对话框
//        item5.click();
//        //通过文本"确定"找到对话框中的确定按钮
//        UiObject btnConfirm = mDevice.findObject(new UiSelector().text("确定").className(Button.class));
//        //点击确定关闭对话框
//        btnConfirm.click();
//        //另外一种方式找到Item 2
//        UiObject item = mDevice.findObject(new UiSelector()
//                .className(RecyclerView.class)
//                .resourceId("me.shihao.espressotests:id/recycleview")
//                .childSelector(new UiSelector().text("Item 2")));
//        //点击弹出对话框
//        item.click();
//        //点击返回关闭对话框
//        mDevice.pressBack();
    }


    @Test
    public void testSettingApp() throws Exception {
        //初始化一个UiDevice对象
        Context context = InstrumentationRegistry.getContext();
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        //回到home界面
        mDevice.pressHome();
        // 启动设置
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(PACKAGE_SETTING);
        //清除以前的实例
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        //通过id找到scrollview
        UiScrollable scrollview = new UiScrollable(new UiSelector().className(RecyclerView.class).resourceId("com.android.settings:id/dashboard_container"));
        //滑动到底部
        scrollview.flingToEnd(10);
        //通过文本找到系统
        UiObject systemPhone = scrollview.getChild(new UiSelector().text("系统"));
        //点击跳转到手机信息界面
        systemPhone.click();
        //通过description找到向上返回的ImageButton
        UiObject ibtnBack = mDevice.findObject(new UiSelector().className(ImageButton.class).description("向上导航"));
        //点击返回
        ibtnBack.click();
        //点击home键
        mDevice.pressHome();
        //点击最近应用键
        mDevice.pressRecentApps();
        //通过类名找到显示最近app的控件TaskStackView
        UiScrollable taskStackView = new UiScrollable(new UiSelector().className("com.android.systemui.recents.views" +
                ".TaskStackView"));
        //返回
        mDevice.pressBack();
    }

    @Test
    public void apps() {
        UiDevice mDevice = UiDevice.getInstance(getInstrumentation());
        mDevice.pressHome();
// Bring up the default launcher by searching for a UI component
// that matches the content description for the launcher button.
        UiObject allAppsButton = mDevice
                .findObject(new UiSelector().description("Apps"));

// Perform a click on the button to load the launcher.
        try {
            allAppsButton.clickAndWaitForNewWindow();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
    }
}
