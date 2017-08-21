package com.welch.emt.ui.window;

import com.welch.emt.service.UserService;
import com.welch.emt.ui.EmtUI;
import com.welch.emt.ui.util.ComponentValidator;
import com.welch.emt.ui.util.UIHelper;
import com.vaadin.event.ShortcutAction;
import com.vaadin.shared.Position;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2017-6-4.
 */
@Component
@Scope("prototype")
public class LoginWindow extends Window {
    private static Logger Logger = LoggerFactory.getLogger(LoginWindow.class);

    private EmtUI emtUI = null;

    @Autowired
    private UserService userService;

    @Autowired
    private RegisterWindow registerWindow;

    public LoginWindow init(EmtUI emtUI){
        this.emtUI = emtUI;
        this.setCaption("请登录");
        this.setClosable(false);
        this.setModal(true);
        this.setDraggable(false);
        this.setResizable(false);
        this.setWidth("350px");
        this.setHeight("250px");
        this.center();
        this.addLoginForm();
        return this;
    }

    /*public void setEmtUI(EmtUI emtUI){
        this.emtUI = emtUI;
    }*/

    private void addLoginForm(){
        FormLayout loginForm = new FormLayout();
        loginForm.setSizeFull();
        loginForm.setSpacing(true);
        loginForm.setMargin(true);

        final TextField userNameField = new TextField("用户名");
        userNameField.setRequiredIndicatorVisible(true);

        final PasswordField passwordField = new PasswordField("密码");
        passwordField.setRequiredIndicatorVisible(true);

        Button loginButton = new Button("登陆");
        loginButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        Button registerButton = new Button("去注册");
        registerButton.setStyleName(ValoTheme.BUTTON_LINK);
        registerButton.setDescription("新用户，请注册");

        loginForm.addComponent(userNameField);
        loginForm.addComponent(passwordField);
        loginForm.addComponent(loginButton);
        loginForm.addComponent(registerButton);

        LinkedHashMap<TextField, String> components = new LinkedHashMap();
        components.put(userNameField, "请输入用户名");
        components.put(passwordField, "请输入密码");
        loginButton.addClickListener(clickEvent -> {
            System.out.println("***************************************************************************************************************************");
            System.out.println("userName = " + userNameField.getValue());
            System.out.println("password = " + passwordField.getValue());
            System.out.println("***************************************************************************************************************************");
            if(ComponentValidator.validate(components)){
                if(this.login(userNameField.getValue(), passwordField.getValue())){
                    this.close();
                    this.emtUI.welcome();
                }else{
                    UIHelper.showErrorNotification("登陆失败","用户名或密码错误", Position.BOTTOM_RIGHT);
                }
            }
        });
        registerButton.addClickListener(clickEvent -> {
            this.close();
            this.getUI().getCurrent().addWindow(this.registerWindow.init(this));
        });
        this.setContent(loginForm);
    }

    private boolean login(String userName, String password){
        if(this.userService.login(userName, password)){
            UI.getCurrent().getSession().setAttribute("user", userName);
            Logger.info("User login successfully " + userName);
            return true;
        }else{
            Logger.error("User login failed " + userName);
            return false;
        }
    }
}
