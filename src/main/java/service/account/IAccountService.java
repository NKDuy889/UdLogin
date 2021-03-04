package service.account;

import model.Login;
import model.User;
import service.IService;

public interface IAccountService extends IService<User> {
    User findByName(String name);
    User checkLogin(Login login);
}
