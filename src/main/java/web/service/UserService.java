package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> getAll();
    User get(long id);
    User delete(User user);
    void deleteById(long id);
}
