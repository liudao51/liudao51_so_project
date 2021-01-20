package com.liudao51.so.controller.sprider;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.liudao51.so.common.util.ObjectUtilsX;
import com.liudao51.so.entity.vo.ArticleSearchResultVo;
import com.liudao51.so.facade.IArticleSearchService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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

    @DubboReference
    private IArticleSearchService articleSearchService;

    @GetMapping("/s")
    public String searchArticle(HttpServletRequest request, Model model) throws Exception {
        String wd = request.getParameter("wd");
        //返回参数：关键词
        model.addAttribute("wd", wd);

        //返回参数：文章列表
        Map<String, Object> params = new HashMap<>();
        params.put("keyword", wd);
        IPage<ArticleSearchResultVo> articleSearchPage = articleSearchService.getArticleSearchPage(1, 10, params);
        System.out.println(articleSearchPage);

        if (!ObjectUtilsX.isEmpty(articleSearchPage)) {
            model.addAttribute("articleSearchPage", articleSearchPage);
        }

        return "search";
    }
}

