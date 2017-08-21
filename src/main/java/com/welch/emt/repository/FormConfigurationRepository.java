package com.welch.emt.repository;

import com.welch.emt.model.FormConfiguration;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017-6-10.
 */
public interface FormConfigurationRepository extends CrudRepository<FormConfiguration, Long> {
    public Iterable<FormConfiguration> findAllByOrderBySeqAsc();
}
