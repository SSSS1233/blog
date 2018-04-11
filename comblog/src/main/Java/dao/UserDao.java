package dao;

import org.springframework.stereotype.Repository;
import po.Article;
import po.Category;
import po.User;

import java.util.List;

/**
 * Created by Intellij IDEA.
 *
 * @Author SUBING
 * @Date 2018/4/10 22:53.
 * @Comment
 */
@Repository
public interface UserDao {
    String selectName(String name);

    String selectPass(String name);

    void updateArticle(Article article);

    Category selectdisplayName(int id);

    List<Category> selectdisplayNameAll();

    int selectId(String name);

}
