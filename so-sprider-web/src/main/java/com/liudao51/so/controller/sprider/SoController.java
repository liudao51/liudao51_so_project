package com.liudao51.so.controller.sprider;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String search(Model model) {
        String keyword = "java开发";
        model.addAttribute("wd", keyword);

        return "search";
    }
}

