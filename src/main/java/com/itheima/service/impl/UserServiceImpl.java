package com.itheima.service.impl;

import com.itheima.mapper.BrandMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.User;
import com.itheima.service.BrandService;
import com.itheima.service.UserService;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author 帅才
 * @version 1.0
 */
public class UserServiceImpl implements UserService {

    @Override
    public List<Brand> selectAll() {
        return null;
    }

    @Override
    public void add(Brand brand) {

    }
}
