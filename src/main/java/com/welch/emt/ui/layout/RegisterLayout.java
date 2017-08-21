package com.welch.emt.ui.layout;

import com.welch.emt.ui.EmtUI;
import com.welch.emt.ui.window.RegisterWindow;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-6-10.
 */
public class RegisterLayout extends FormLayout{
    private EmtUI emtUI = null;
    private RegisterWindow registerWindow = null;

    public RegisterLayout(EmtUI emtUI, RegisterWindow registerWindow){
        this.emtUI = emtUI;
        this.registerWindow = registerWindow;
        this.init();
    }

    private void init(){
        this.setSizeFull();
        this.setSpacing(true);
        this.setMargin(true);
        this.initForm();
    }

    private void initForm(){
        TextField userNameField = new TextField("用户名");
        PasswordField passwordField = new PasswordField("密码");
        TextField actualNameField = new TextField("真实姓名");
        ComboBox<String> genderField = new ComboBox<>("性别");
        List<String> genders = new ArrayList<>();
        genders.add("男");
        genders.add("女");
        genderField.setItems(genders);
        //genderField.setData(new String[]{"男","女"});
        TextField emailNameField = new TextField("邮箱");
        TextField mobileNameField = new TextField("手机");

        Button registerButton = new Button("注册");
        Button loginButton = new Button("去登陆");
        loginButton.setDescription("已有账户，去登陆");
        loginButton.addStyleName(ValoTheme.BUTTON_LINK);
        loginButton.addStyleName(ValoTheme.TABLE_SMALL);
        loginButton.addClickListener(clickEvent -> {
           this .registerWindow.close();
           //this.getUI().getCurrent().addWindow(new LoginWindow(this.emtUI));
        });

        this.addComponents(userNameField, passwordField, actualNameField, genderField, emailNameField, mobileNameField, registerButton, loginButton);
        //this.setComponentAlignment(registerButton, Alignment.BOTTOM_RIGHT);
    }
}
