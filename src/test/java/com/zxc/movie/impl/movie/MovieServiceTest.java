package com.zxc.movie.impl.movie;

import com.zxc.movie.beans.Movie;
import com.zxc.movie.common.MovieStatus;
import com.zxc.movie.service.MovieService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by 星驰太帅了 on 2018/05/27.
 */
@Ignore
public class MovieServiceTest extends BaseTest {

    @Autowired
    private MovieService movieService;

    @Test
    public void testInsert() {
        Movie movie = getMovie(10);
        movie.setUpdateDate(LocalDateTime.now());
        int count = movieService.add(movie);
        System.out.println(count);
    }

    @Test
    public void testGetById() {
        System.out.println(movieService.getById(5));
     //   Assert.assertNotNull(movieService.getById(1));
    }

    @Test
    public void testInsertAndGet() throws Exception{
        Movie movie = getMovie(20);
        int count = movieService.add(movie);
        System.out.println(count);
        System.out.println(movie.getId());
        //一定可以插入,测试Insert方法
        Assert.assertTrue(count > 0);
        //获取刚刚插入的数据,一定可以获取，为了避免网路问题,休眠一下再查询
        Thread.sleep(2000l);
        Assert.assertNotNull(movieService.getById(movie.getId()));
    }

    private Movie getMovie (int count) {
        Movie movie = new Movie();
        movie.setMovieUrl("zxc" + count);
        movie.setMovieName("zxc" + count);
        movie.setCreateDate(LocalDateTime.now());
        movie.setMovieDesc("zxcxcad" + count);
        movie.setKeepCunt(100);
        movie.setPhoto("ldhh" + count);
        movie.setMovieStatus(MovieStatus.ON_LINE_AND_LINK);
        movie.setShowDate(LocalDate.now());
        return movie;
    }
}
