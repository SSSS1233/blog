package dao;

import org.springframework.stereotype.Repository;
import po.Article;

import java.util.List;

/**
 * Created by Intellij IDEA.
 *
 * @Author SUBING
 * @Date ${Date}
 * @Comment
 */
@Repository
public interface ArticleDao {
    List<Article> selectAll();

    List<Article> selectById(int id);

    List<Article> selectByCategoryId(int id);

    List<Article> selectLike(String name);
}
