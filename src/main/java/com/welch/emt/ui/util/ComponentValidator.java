package com.welch.emt.ui.util;

import com.vaadin.server.Page;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;

import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2017-6-4.
 */
public class ComponentValidator {

    public static boolean validate(LinkedHashMap<TextField, String> components){
        for(TextField textField: components.keySet()){
            String value = textField.getValue();
            if(value==null || value.trim().equals("")){
                new Notification("错误",components.get(textField)).show(Page.getCurrent());
                return false;
            }
        }
        return true;
    }
}
