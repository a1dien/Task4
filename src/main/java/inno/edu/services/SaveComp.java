package inno.edu.services;

import inno.edu.logging.Loggable;
import inno.edu.model.Login;
import inno.edu.model.User;
import inno.edu.repo.LoginRepository;
import inno.edu.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class SaveComp {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginRepository loginRepository;
    public void saveUsers(List<User> userList) {userRepository.saveAll(userList);}

    public void saveLogins(List<Login> loginList) {
        loginRepository.saveAll(loginList);
    }

     @Loggable
    public void save(List<Map<Keys, Object>> recordsMap) {
        for (Map recordMap : recordsMap) {
            User user = new User(
                    (String) recordMap.get(Keys.FIO),
                    (String) recordMap.get(Keys.USERNAME));
            userRepository.save(user);
            Login login = new Login(
                    ((Timestamp) recordMap.get(Keys.DATE)),
                    (Long) recordMap.get(user.getId()),
                    (String) recordMap.get(Keys.APPLICATION)
            );
            loginRepository.save(login);
        }

    }

}
