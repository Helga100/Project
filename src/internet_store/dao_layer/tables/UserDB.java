package internet_store.dao_layer.tables;

import internet_store.dao_layer.models.User;

import java.util.ArrayList;

public class UserDB {
    ArrayList<User> dbUsers = new ArrayList<>();


    public UserDB() {
        init();
    }

    public void init() {
        dbUsers.add(new User("1", "1", "1"));
        dbUsers.add(new User("2", "2", true, "2"));
    }

    public void setUserBlockStatus(String idUserFromConcole, boolean blockedStatus) {
        dbUsers.stream().filter(it -> it.getID().equals(idUserFromConcole))
                .forEach(it -> it.setBlocked(blockedStatus));
    }

    public User getUserById(String idUserFromConcole) {
        return dbUsers.stream().filter(it -> it.getID().equals(idUserFromConcole))
                .findFirst()
                .get();
    }

    public ArrayList<User> getDbUsers() {
        return dbUsers;
    }

    public boolean isUserBlocked(String login) {
      return dbUsers.stream().filter(it -> it.getLogin().equals(login))
                .findFirst()
                .get()
                .isBlocked();


    }

    public boolean isAdmin(String login) {
        return  dbUsers.stream().filter(it -> it.getLogin().equals(login))
                .findFirst()
                .get()
                .isAdmin();

    }

    public void addNewUser(String login, String password) {

        User tempUser = new User(login, password, "3");  //TODO Increment ID
        dbUsers.add(tempUser);  //TODO Increment ID

    }

    public boolean isUserExists(String login, String password) {
        return findUserByLoginAndPassword(login, password) != null;
    }

    public User findUserByLoginAndPassword(String loginFromConcole1, String passwordFromConcole1) {
        return dbUsers.stream()
                .filter(it -> it.getLogin().equals(loginFromConcole1) && it.getPassword().equals(passwordFromConcole1))
                .findFirst().orElse(null);
    }
}
