package web.dao;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import web.models.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User save(User user) {
        if (user.getId() == 0) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        TypedQuery<User> typedQuery =
            (TypedQuery<User>) entityManager.createQuery("from User");
        return typedQuery.getResultList();
    }

    @Override
    public User get(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.detach(user);
        return user;
    }

    @Override
    public User delete(User user) {
        entityManager.remove(user);
        return user;
    }

    @Override
    public void deleteById(long id) {
        entityManager.createQuery("delete from User where id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
