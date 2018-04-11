package handler;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import po.Article;
import service.ArticleService;
import service.Impl.ArticleServiceImpl;

import java.util.List;

/**
 * Created by Intellij IDEA.
 *
 * @Author SUBING
 * @Date ${Date}
 * @Comment
 */
@Controller
@RequestMapping("views")
public class ArticleHandler {
    @Autowired
    ArticleService articleService;

    /**
     * 文章列表
     * @param m
     * @return
     */
    @RequestMapping(value="index.do")
    public String select(Model m)
    {
        System.out.println("LLLL");
        List<Article> l= articleService.selectAll();
        m.addAttribute("articles",l);
        return "views/index.jsp";
    }

    /**
     * 分类查询
     * @param m
     * @param id
     * @return
     */
    @RequestMapping(value = "classification.do")
    public String selectClassification(Model m,int id)
    {
        List<Article> l=articleService.selectByCategoryId(id);
        m.addAttribute("articles",l);
        return "views/index.jsp";
    }
    /**
     * 阅读全文
     * @param m
     * @param id
     * @return
     */
    @RequestMapping(value = "detail.do")
    public String selectdetail(Model m,int id)
    {
        List<Article> l=articleService.selectById(id);
        Article article=l.get(0);
        for(Article a:l)
        {
            System.out.println(a);

        }
        m.addAttribute("article",l);
        PegDownProcessor pdp = new PegDownProcessor(Integer.MAX_VALUE);
        String html = pdp.markdownToHtml(article.getContent());
        System.out.println(html);
        m.addAttribute("articles",html);
        m.addAttribute("title",article.getTitle());
        return "views/detail.jsp";
    }

    /**
     * 模糊查询
     * @param m
     * @return
     */
    @RequestMapping("selectlike.do")
    public String selectLike(Model m,String title)
    {
        System.out.println(title);
        List<Article> l=articleService.selectLike(title);
        m.addAttribute("articles",l);
        return "views/index.jsp";
    }

}
