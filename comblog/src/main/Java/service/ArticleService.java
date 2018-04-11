package service;

import po.Article;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Intellij IDEA.
 *
 * @Author SUBING
 * @Date ${Date}
 * @Comment
 */
@Transactional
public interface ArticleService {

    public List<Article> selectAll();
    public List<Article> selectById(int id);
    List<Article> selectByCategoryId(int id);
    List<Article> selectLike(String title);
}
