package com.zxc.aop.test;

import com.zxc.movie.impl.movie.BaseTest;
import com.zxc.movie.service.MovieService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 星驰太帅了 on 2018/06/01.
 */
@Ignore
public class AopTest extends BaseTest {

    @Autowired
    private MovieService movieService;

    @Test
    public void testBefore() {
        System.out.println(movieService.getById(31));
    }
}
