package service.account;

import model.Login;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class AccountService implements IAccountService {
    static List<User> userList = new ArrayList<>();
    static {
        userList.add(new User("admin","admin","1","1",1));
        userList.add(new User("admin1","admin1","2","2",2));
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void update(User model) {

    }

    @Override
    public void save(User Model) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public User findByName(String name) {
            for (User user : userList) {
                if (name.equals(user.getName())) {
                    return user;
                }
            }
            return null;
    }

    @Override
    public User checkLogin(Login login){
        for (User u: userList) {
            if(u.getAccount().equals(login.getAccount()) && u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}
