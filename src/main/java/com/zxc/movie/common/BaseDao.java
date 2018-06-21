package com.zxc.movie.common;

import java.util.List;

/**
 * Created by 星驰太帅了 on 2018/05/26.
 * 基本的DAO层,实现了基本的CRUD操作
 */
public interface BaseDao <T>{

    //插入一个对象
    public Integer insert(T t);

    //修改一个对象
    public Integer update(T t);

    //删除一个对象
    public Integer delete(Long id);

    //获取一个对象
    public T getById(Long id);

    //获取所有的对象
    public List<T> getAll();
}
