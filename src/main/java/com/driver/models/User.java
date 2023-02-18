package  com.driver.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private String FirstName = "test";
    private String LastName = "test";

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    @JoinColumn
    private List<Blog> blogList;

    public User(){

    }

    public User(String lastName , String firstName) {
        this.FirstName = firstName;
        this.LastName = lastName;
    }

    public User(int id, String username, String password, String firstName, String lastName, List<Blog> blogList) {
        this.id = id;
        this.username = username;
        this.password = password;
        FirstName = firstName;
        LastName = lastName;
        this.blogList = blogList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}