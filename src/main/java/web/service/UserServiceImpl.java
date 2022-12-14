package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.models.User;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User get(long id) {
        return userDao.get(id);
    }

    @Transactional
    @Override
    public User delete(User user) {
        return userDao.delete(user);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        userDao.deleteById(id);
    }
}
