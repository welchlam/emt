package com.welch.emt.ui.layout;

import com.welch.emt.model.FormConfiguration;
import com.vaadin.ui.*;
import com.vaadin.ui.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Administrator on 2017-6-10.
 */
public class ConfigurableFormLayout extends FormLayout {

    LinkedHashMap<String, FormConfiguration> form = null;
    private LinkedHashMap<Component, String> components = new LinkedHashMap<>();

    public ConfigurableFormLayout(LinkedHashMap<String, FormConfiguration> form){
        this.form = form;
        this.init();
    }

    private void init(){
        this.setSizeFull();
        this.setSpacing(true);
        this.setMargin(true);
        this.initForm();
    }

    private void initForm(){
        this.form.values().forEach(formConfiguration -> {
            //System.out.println(formConfiguration.getFieldName());
            switch (formConfiguration.getFieldType()){
                case "TextField" : {
                    TextField textField = new TextField(formConfiguration.getFieldName());
                    textField.setRequiredIndicatorVisible(formConfiguration.isRequired());
                    textField.setValue(formConfiguration.getDefaultValue());
                    textField.setDescription(formConfiguration.getDescription());
                    this.components.put(textField, formConfiguration.getRequiredError());
                    this.addComponent(textField);
                    break;
                }
                case "PasswordField" : {
                    PasswordField passwordField = new PasswordField(formConfiguration.getFieldName());
                    passwordField.setRequiredIndicatorVisible(formConfiguration.isRequired());
                    passwordField.setDescription(formConfiguration.getDescription());
                    this.components.put(passwordField, formConfiguration.getRequiredError());
                    this.addComponent(passwordField);
                    break;
                }
                case "ComboBox" : {
                    ComboBox<String> comboBox = new ComboBox<>(formConfiguration.getFieldName());
                    comboBox.setRequiredIndicatorVisible(formConfiguration.isRequired());
                    comboBox.setValue(formConfiguration.getDefaultValue());
                    comboBox.setDescription(formConfiguration.getDescription());
                    List<String> list = new ArrayList<>();
                    Arrays.stream(formConfiguration.getSrcValues().split("\\|")).forEach(s -> {
                        list.add(s);
                    });
                    comboBox.setItems(list);
                    this.components.put(comboBox, formConfiguration.getRequiredError());
                    this.addComponent(comboBox);
                    break;
                }
                case "Button" : {
                    Button button = new Button(formConfiguration.getFieldName());
                    button.setDescription(formConfiguration.getDescription());
                    Arrays.stream(formConfiguration.getStyles().split("\\|")).forEach(s -> {
                        button.addStyleName(s);
                    });
                    this.components.put(button, formConfiguration.getRequiredError());
                    this.addComponent(button);
                    break;
                }
                default : {
                    break;
                }
            }
        });
    }

    public LinkedHashMap<Component, String> getComponents() {
        return this.components;
    }
}
