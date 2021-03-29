package au.mgemployeehire.employeehireemployeepanel.Model;

public class ChatUsers {
    String id;
    String imageURL;
    String username;

    public ChatUsers(){
        //default
    }

    public ChatUsers(String id, String imageURL, String username) {
        this.id = id;
        this.imageURL = imageURL;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
