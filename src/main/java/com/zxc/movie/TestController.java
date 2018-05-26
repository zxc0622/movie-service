package com.zxc.movie;

import com.zxc.movie.beans.Movie;
import com.zxc.movie.dao.MovieMapper;
import com.zxc.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 星驰太帅了 on 2018/05/26.
 */
@RestController
public class TestController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/test2/{id}")
    public Movie test2 (@PathVariable(value = "id") Integer id) {
        return movieService.getById(id);
    }

    @RequestMapping("/test")
    public List<String> test () {
        return Arrays.asList("a","b","c");
    }

}
