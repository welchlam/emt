package com.welch.emt.util;

import com.welch.emt.repository.FormConfigurationRepository;

/**
 * Created by Administrator on 2017-6-10.
 */
public class EmtInitializer {

    public static void initEmtForms(FormConfigurationRepository formConfigurationRepository){
        DbConfigurationLoader.loadForms(formConfigurationRepository, true);
    }
}
