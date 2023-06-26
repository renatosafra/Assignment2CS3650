package assignment2;

import java.util.ArrayList;

// Composite


public class UserGroup extends User {

    private ArrayList<User> users;
    private String groupName;

    public UserGroup(String groupName) {
        super();
        users = new ArrayList<>();
        this.groupName = groupName;
    }

    void addUser(User user) {
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}