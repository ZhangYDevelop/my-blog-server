package com.zy.blog.server.core;

import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 基本操作接口（CRUD）
 */
@Service
public interface IBaseService<T> {

    List<T> selectAll();

    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int batchDelete(List<String> list, String property, Class<T> clazz);

    int batchDeleteByKey(List<String> list, Class<T> clazz);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);

    List<T> selectByRecord(T entity);

}