package com.zxc.movie.impl.movie;

import com.zxc.movie.beans.Movie;
import com.zxc.movie.service.MovieService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 星驰太帅了 on 2018/05/27.
 */
@Ignore
public class MovieServiceTest extends BaseTest {

    @Autowired
    private MovieService movieService;


    @Test
    public void testGetById() {
        System.out.println(movieService.getById(21));
        Assert.assertNotNull(movieService.getById(21));
    }

    @Test
    public void testInsert() throws Exception{
        Movie movie = new Movie();
        movie.setMovieName("i am good");
        movie.setMovieUrl("www.zxc.com");
        movie.setStatus(2);
        int count = movieService.add(movie);
        System.out.println(count);
        System.out.println(movie.getId());
        //一定可以插入,测试Insert方法
        Assert.assertTrue(count > 0);
        //获取刚刚插入的数据,一定可以获取，为了避免网路问题,休眠一下再查询
        Thread.sleep(2000l);
        Assert.assertNotNull(movieService.getById(movie.getId()));
    }
}
