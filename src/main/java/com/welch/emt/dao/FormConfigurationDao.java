package com.welch.emt.dao;

import com.welch.emt.model.FormConfiguration;
import com.welch.emt.repository.FormConfigurationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2017-6-11.
 */
@Component
public class FormConfigurationDao {
    private static Logger Logger = LoggerFactory.getLogger(FormConfigurationDao.class);

    @Autowired
    private FormConfigurationRepository formConfigurationRepository;

    private static LinkedHashMap<String, LinkedHashMap<String, FormConfiguration>> FORMS = null;

    public LinkedHashMap<String, LinkedHashMap<String, FormConfiguration>> getForms(){
        if(FORMS==null){
            this.refreshForms();
        }
        return FORMS;
    }

    public void refreshForms(){
        FORMS = new LinkedHashMap<>();
        formConfigurationRepository.findAllByOrderBySeqAsc().forEach(formConfiguration -> {
            if(FORMS.get(formConfiguration.getFormName())==null){
                FORMS.put(formConfiguration.getFormName(), new LinkedHashMap<>());
            }
            FORMS.get(formConfiguration.getFormName()).put(formConfiguration.getFieldName(), formConfiguration);
        });
    }
}
