package assignment2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

// Observer & Composite

public class User {

    private String tweet;
    private String username;
    private PropertyChangeSupport support;
    private ChatFeed myFeed;
    private ArrayList<User> followers;
    private ArrayList<User> following;
    private ArrayList<String> tweetList;


    public User() {

    }
   
    //constructor
    public User(String username) {
        setUsername(username);
        tweet = "";
        support = new PropertyChangeSupport(this);
        myFeed = new ChatFeed();
        myFeed.setUser(this);
        followers = new ArrayList<>();
        following = new ArrayList<>();
        tweetList = new ArrayList<>();
        addPropertyChangeListener(myFeed);

    }


    // adds a property change listener
    public void addPropertyChangeListener(PropertyChangeListener listener) throws NullPointerException{
        support.addPropertyChangeListener(listener);
    }

    public void addFollowers(User newFollower) {
        followers.add(newFollower);
    }

    public void addFollowing(User newFollowing) {
        following.add(newFollowing);
        newFollowing.addFollowers(this);
    }

    // property change to all the listeners when a post is sent
    public void addTweet(String tweet) {
        support.firePropertyChange("tweet", this.tweet, tweet);
        tweetList.add(tweet);
        setTweet(tweet);
    }


    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public ChatFeed getMyFeed() {
        return myFeed;
    }

    public void setMyFeed(ChatFeed myFeed) {
        this.myFeed = myFeed;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }

    public ArrayList<User> getFollowing() {
        return following;
    }

    public void setFollowing(ArrayList<User> following) {
        this.following = following;
    }

}