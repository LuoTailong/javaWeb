package service;

import dao.UserDao;
import domain.User;

public class UserService {
    public boolean isLogin(User user){
        UserDao ud = new UserDao();
        User loginUser = ud.isLoign(user);
        return loginUser != null;
    }

    public void registerUser(User user) {
        UserDao ud = new UserDao();
        ud.registerUser(user);
    }
}
