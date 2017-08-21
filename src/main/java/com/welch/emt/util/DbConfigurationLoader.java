package com.welch.emt.util;

import com.welch.emt.model.FormConfiguration;
import com.welch.emt.repository.FormConfigurationRepository;

import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2017-6-10.
 */
public class DbConfigurationLoader {
    private static LinkedHashMap<String, LinkedHashMap<String, FormConfiguration>> FORMS = null;

    public static void loadForms(FormConfigurationRepository formConfigurationRepository, boolean force){
        if(force || FORMS==null){
            FORMS = new LinkedHashMap<>();
            formConfigurationRepository.findAllByOrderBySeqAsc().forEach(formConfiguration -> {
                //System.out.println(formConfiguration.getFieldName());
                if(FORMS.get(formConfiguration.getFormName())==null){
                    FORMS.put(formConfiguration.getFormName(), new LinkedHashMap<>());
                }
                FORMS.get(formConfiguration.getFormName()).put(formConfiguration.getFieldName(), formConfiguration);
            });
        }
    }

    public static LinkedHashMap<String, LinkedHashMap<String, FormConfiguration>> getForms(FormConfigurationRepository formConfigurationRepository){
        if(FORMS==null)
            loadForms(formConfigurationRepository, true);
        return FORMS;
    }
}
