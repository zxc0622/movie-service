package com.zxc.movie.impl.movie;

import com.zxc.movie.aop.annotation.Log;
import com.zxc.movie.aop.annotation.LogIgnore;
import com.zxc.movie.beans.Movie;
import com.zxc.movie.dao.MovieMapper;
import com.zxc.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 星驰太帅了 on 2018/05/26.
 *  MovieService 基本实现类
 */
@Service("movieService")
@Log
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Override
    @LogIgnore
    public Movie getById(Integer id) {
        return movieMapper.getById(id);
    }

    @Override
    public int add(Movie movie) {
        return movieMapper.insert(movie);
    }
}
