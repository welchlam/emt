package com.welch.emt.service;

import com.welch.emt.dao.FormConfigurationDao;
import com.welch.emt.model.FormConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2017-6-11.
 */
@Service
public class FormConfigurationService {
    @Autowired
    private FormConfigurationDao formConfigurationDao;

    public LinkedHashMap<String, LinkedHashMap<String, FormConfiguration>> getForms(){
        return this.formConfigurationDao.getForms();
    }

    public void refreshForms(){
        this.formConfigurationDao.refreshForms();
    }
}
