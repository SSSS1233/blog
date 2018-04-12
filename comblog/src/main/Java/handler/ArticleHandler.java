package handler;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import po.Article;
import service.ArticleService;
import service.Impl.ArticleServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @ResponseBody
    @RequestMapping(value = "classification.do")
    public Map<String,Object> selectClassification(Model m, int id)
    {
        List<Article> l=articleService.selectByCategoryId(id);
        Map<String,Object> map=new HashMap<String, Object>();
        m.addAttribute("articles",l);
        m.addAttribute("length",l.size());
        map.put("articles",l);
        map.put("length",l.size());
        return map;
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
    @ResponseBody
    @RequestMapping("selectlike.do")
    public Map<String,Object> selectLike(Model m,String title)
    {
        System.out.println(title);
        Map<String,Object> map=new HashMap<String, Object>();
        List<Article> l=articleService.selectLike(title);
        m.addAttribute("articles",l);
        map.put("articles",l);
        map.put("length",l.size());
        return map;
    }
    @RequestMapping(value = "demo.do")
    public String demo()
    {
        return "views/demo.jsp";
    }

}
