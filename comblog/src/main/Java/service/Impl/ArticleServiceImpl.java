package service.Impl;

import dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import po.Article;
import service.ArticleService;

import java.util.List;

/**
 * Created by Intellij IDEA.
 *
 * @Author SUBING
 * @Date ${Date}
 * @Comment
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleDao articleDao;


    public List<Article> selectAll() {
        return articleDao.selectAll();
    }


    public List<Article> selectById(int id) {
        return articleDao.selectById(id);
    }


    public List<Article> selectByCategoryId(int id) {
        return articleDao.selectByCategoryId(id);
    }


    public List<Article> selectLike(String title) {
        return articleDao.selectLike(title);
    }
}
