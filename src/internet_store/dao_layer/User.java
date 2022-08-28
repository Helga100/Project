package internet_store.dao_layer;

import java.util.Objects;

public class User {
    String login;
    String password;
    boolean isAdmin;
    boolean isBlocked;
    String ID;

    public User(String login1, String password, String ID) {
        this.login = login1;
        this.password = password;
        this.isAdmin = false;
        this.isBlocked = false;
        this.ID = ID;


    }

    public User(String login1, String password, boolean isAdmin, String ID ) {
        this.login = login1;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isBlocked = false;
        this.ID = ID;


    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", isBlocked=" + isBlocked +
                ", ID='" + ID + '\'' +
                '}';
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
