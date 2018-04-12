package service;

import org.springframework.transaction.annotation.Transactional;
import po.Article;
import po.Category;
import po.User;

import java.util.List;

/**
 * Created by Intellij IDEA.
 *
 * @Author SUBING
 * @Date 2018/4/10 22:58.
 * @Comment
 */
@Transactional
public interface UserService {
    String selectName(String name);

    String selectPass(String name);

    void updateArticle(Article article);

    Category selectdisplayName(int id);

    List<Category> selectdisplayNameAll();

    int selectId(String name);

    void insertArticle(Article article);
}
