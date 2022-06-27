package com.itheima.web.Servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * @author 帅才
 * @version 1.0
 */
@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {

    private BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1.调用service查询
        List<Brand> brands = brandService.selectAll();
        //2.转为json
        String jsonString = JSON.toJSONString(brands);
        //3.响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1.接收用户数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();//json字符串
        //转为Brand对象
        Brand brand = JSON.parseObject(s, Brand.class);

        //2.调用service添加
        brandService.add(brand);
        //3.响应成功的标识
        response.getWriter().write("success");
    }

    /**
     * 修改
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1.接收用户数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();//json字符串
        //转为Brand对象
        Brand brand = JSON.parseObject(s, Brand.class);

        //2.调用service添加
        brandService.update(brand);
        //3.响应成功的标识
        response.getWriter().write("success");

    }

    /**
     * 批量删除
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1.接收用户数据【1,2,3】
        BufferedReader reader = request.getReader();
        String s = reader.readLine();//json字符串

        //转为int[]
        int[] ids = JSON.parseObject(s, int[].class);

        //2.调用service批量删除
        brandService.deleteByIds(ids);
        //3.响应成功的标识
        response.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1.
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //2.调用service查询
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);

        // 3.转为json
        String jsonString = JSON.toJSONString(pageBean);
        //4.响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 条件分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");

        //1.
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取条件brand对象
        BufferedReader reader = request.getReader();
        String s = reader.readLine();//json字符串

        //转为brand
        Brand brand = JSON.parseObject(s, Brand.class);



        //2.调用service查询
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize,brand);

        // 3.转为json
        String jsonString = JSON.toJSONString(pageBean);
        //4.响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
