import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liudao51.so.entity.po.Article;
import com.liudao51.so.facade.IArticleService;
import com.liudao51.so.service.sprider.SpriderServiceApp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 参考：
 * SpringBoot系列: 单元测试: https://www.cnblogs.com/harrychinese/p/springboot_unittesting.html
 * Spring Boot Junit 单元测试：https://blog.csdn.net/qq_35915384/article/details/80227297
 */
/*
//使用：Junit 4
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpriderServiceApp.class, SpriderServiceTestApp.class})
 */
//使用：Junit 5
@SpringBootTest(classes = {SpriderServiceApp.class, SpriderServiceTestApp.class})
public class SpriderServiceTestApp {

    @Autowired
    private IArticleService articleServerImpl;

    @Test
    public void testHello() {
        System.out.println("hello");
    }

    @Test
    public void testGetList() {
        Page<Article> articlePage = articleServerImpl.getArticleList(2, 1);
        System.out.println(articlePage);
    }

    @Test
    public void testGetObj() {
        Long id = 2L;
        Article article = articleServerImpl.getArticle(id);
        System.out.println(article);
    }

}
