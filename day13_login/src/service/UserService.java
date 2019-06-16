package service;

import dao.UserDao;
import domain.User;

public class UserService {
    public User isLogin(User user) {
        UserDao ud = new UserDao();
        return ud.isLogin(user);
    }
}
