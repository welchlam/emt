package com.welch.emt.ui.window;

import com.welch.emt.service.FormConfigurationService;
import com.welch.emt.ui.layout.ConfigurableFormLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Window;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017-6-10.
 */
@Component
@Scope("prototype")
public class RegisterWindow extends Window {

    private static Logger Logger = LoggerFactory.getLogger(RegisterWindow.class);

    @Autowired
    private FormConfigurationService formConfigurationService;

    public RegisterWindow init(LoginWindow loginWindow){
        this.setCaption("请注册");
        this.setClosable(false);
        this.setModal(true);
        this.setDraggable(false);
        this.setResizable(false);
        this.setWidth(30, Unit.PERCENTAGE);
        this.setHeight(50, Unit.PERCENTAGE);
        this.center();

        ConfigurableFormLayout registerLayout = new ConfigurableFormLayout(this.formConfigurationService.getForms().get("UserRegisterForm"));
        this.setContent(registerLayout);
        registerLayout.getComponents().keySet().forEach(component -> {
            if(component.getCaption().equals("去登陆")){
                ((Button) component).addClickListener(clickEvent -> {
                    this.close();
                    this.getUI().getCurrent().addWindow(loginWindow);
                });
            }
        });
        return this;
    }
}
