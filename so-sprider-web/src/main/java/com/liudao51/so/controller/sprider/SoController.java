package com.liudao51.so.controller.sprider;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 搜索结果页 前端控制器
 * </p>
 *
 * @author Jewel
 * @since 2020-12-24
 */
@Controller
@RequestMapping("/")
public class SoController {

    @GetMapping("/s")
    public String search(HttpServletRequest request, Model model) {
        String wd = request.getParameter("wd");
        //返回参数：关键词
        model.addAttribute("wd", wd);

        //返回参数：文章列表


        return "search";
    }
}

