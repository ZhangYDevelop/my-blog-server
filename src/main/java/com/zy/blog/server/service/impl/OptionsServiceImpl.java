package com.zy.blog.server.service.impl;

import com.zy.blog.server.entity.Options;
import com.zy.blog.server.mapper.OptionsMapper;
import com.zy.blog.server.service.OptionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author zhangyu
 * @date 2017/9/7
 */
@Service
public class OptionsServiceImpl implements OptionsService {

    private Logger log = LoggerFactory.getLogger(OptionsServiceImpl.class);

    @Autowired(required = false)
    private OptionsMapper optionsMapper;

    @Override
    @Cacheable(value = "default", key = "'options'")
    public Options getOptions() {
        return optionsMapper.getOptions();
    }

    @Override
    @CacheEvict(value = "default", key = "'options'")
    public void insertOptions(Options options) {
        optionsMapper.insert(options);
    }

    @Override
    @CacheEvict(value = "default", key = "'options'")
    public void updateOptions(Options options) {
        optionsMapper.update(options);
    }
}
