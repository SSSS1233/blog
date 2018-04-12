package service.Impl;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import po.Article;
import po.Category;
import po.User;
import service.UserService;

import java.util.List;



/**
 * Created by Intellij IDEA.
 *
 * @Author SUBING
 * @Date 2018/4/10 22:58.
 * @Comment
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;


    public String selectName(String name) {
        return userDao.selectName(name);
    }

    public String selectPass(String name) {
        return userDao.selectPass(name);
    }


    public void updateArticle(Article article) {
        userDao.updateArticle(article);
    }


    public Category selectdisplayName(int id) {
        return userDao.selectdisplayName(id);
    }


    public List<Category> selectdisplayNameAll() {
        return userDao.selectdisplayNameAll();
    }


    public int selectId(String name) {
        return userDao.selectId(name);
    }
}
