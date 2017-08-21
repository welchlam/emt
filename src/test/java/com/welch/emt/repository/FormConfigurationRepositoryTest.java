package com.welch.emt.repository;

import com.welch.emt.model.FormConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017-6-10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = {"classpath:test.application.properties"})
public class FormConfigurationRepositoryTest {
    @Autowired
    private FormConfigurationRepository formConfigurationRepository;

    @Test
    public void testSave(){
        FormConfiguration formConfiguration = new FormConfiguration();
        formConfiguration.setFormName("RegisterForm");
        formConfiguration.setFieldName("用户名");
        formConfiguration.setFieldType("TextField");
        formConfiguration.setSeq(1);
        formConfiguration.setRequiredError("请输入用户名");
        this.formConfigurationRepository.save(formConfiguration);
    }

    @Test
    public void testFindAll(){
        this.formConfigurationRepository.findAllByOrderBySeqAsc().forEach(formConfiguration -> {
            System.out.println(formConfiguration.getSeq());
        });
    }
}
