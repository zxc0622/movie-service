package com.zxc.movie.impl.movie;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 星驰太帅了 on 2018/05/27.
 * 基础类,用来继承拿到spring容器的信息
 * 直接忽略也没关系,所以子类继承实现测试就行了,不过测试的时候可能得开着zookpeer,要不然就把跟dubbo相关的东西去掉也行,或者做一份专门来测试的配置文件
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml", "classpath:springmvc.xml"})
public class BaseTest {
}
