package com.zxc.movie.impl.movie;

import com.zxc.movie.beans.Movie;
import com.zxc.movie.dao.MovieMapper;
import com.zxc.movie.service.MovieService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 星驰太帅了 on 2018/05/27.
 */
//@Ignore
public class MovieServiceTest extends BaseTest {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieMapper movieMapper;

    @Test
    public void testGetById() {
        System.out.println(movieService.getById(21));
        Assert.assertNotNull(movieService.getById(21));
    }
    @Test
    public void testDelete() {
        int count = movieMapper.delete(21);
        System.out.println(count);
    }

    @Test
    public void testInsert() {
        Movie movie = new Movie();
        movie.setMovieName("i am good");
        movie.setMovieUrl("www.zxc.com");
        movie.setStatus(2);
        int count = movieService.add(movie);
        System.out.println(count);
        System.out.println(movie.getId());
//        Assert.assertTrue(count > 0);
        //Assert.assertNotNull(movieService.getById(movie.getId()));
    }
}
