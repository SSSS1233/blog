package handler;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import po.Article;
import po.Category;
import po.User;
import service.ArticleService;
import service.Impl.ArticleServiceImpl;
import service.Impl.UserServiceImpl;
import service.UserService;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Intellij IDEA.
 *
 * @Author SUBING
 * @Date 2018/4/10 22:59.
 * @Comment
 */
@Controller
@RequestMapping(value = "admin")
public class UserHandler {
    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;
    @RequestMapping(value = "/Login.do")
    public String login()
    {

        return "admin/login.jsp";
    }
    @ResponseBody
    @RequestMapping(value = "login.do")
    public Map<String, Object> login(Model m, User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (user.getUsername() == null || user.getUsername().trim() == "") {
            map.put("message","用户名为空");
        }
        else if(user.getPassword()==null||user.getPassword().trim()=="")
        {
            map.put("message","密码为空");
        }else
        {
            if(userService.selectName(user.getUsername())!=null)
            {
                //String name=
                if(userService.selectPass(user.getUsername()).trim().equals(user.getPassword().trim()))
                {
                    map.put("message","ok");
                }
                else {
                    map.put("message","密码错误");
                }
            }else {
                map.put("message","用户名不存在");
            }
        }
        return map;
    }
    /**
     * 文章列表
     * @param m
     * @return
     */
    @RequestMapping(value="Adminselect.do")
    public String select(Model m)
    {
        System.out.println("LLLL");
        List<Article> l= articleService.selectAll();
        m.addAttribute("articles",l);
        return "admin/index.jsp";
    }
    @RequestMapping(value = "update.do")
   public String update(Model m,int id)
   {
       List<Article> l=articleService.selectById(id);
       Category category=userService.selectdisplayName(id);
       List<Category> categories=userService.selectdisplayNameAll();
       m.addAttribute("category",category);
       m.addAttribute("categories",categories);
       m.addAttribute("article",(Article)l.get(0));
       return "admin/write.jsp";
   }
   @RequestMapping(value = "updates.do")
   public String updates(Model m,String title,String content,String category,int id)
   {
       //System.out.println(content+"###"+title+"###"+category);
       Article article = new Article();
       article.setContent(content);
       int ids = userService.selectId(category);
       article.setCategoryid(ids);
       article.setTitle(title);
       if(id>0) {
           System.out.println("id=" + id);
           article.setId(id);
           System.out.println(article);
           userService.updateArticle(article);
       }
       else {
           article.setSummary(title);
           Date time= new java.sql.Date(new java.util.Date().getTime());
           article.setDate(time);
           userService.insertArticle(article);
       }
       return "redirect:/admin/Adminselect.do";
   }
   @RequestMapping(value = "write.do")
    public String  write(Model m)
   {
       List<Category> categories=userService.selectdisplayNameAll();
       m.addAttribute("categories",categories);
       return "admin/write.jsp";
   }

}
