package iuh.team.iuhdemo.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;

@Entity
@Table(name = "user_profile")
public class user_profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    @NotEmpty(message = "please provide username")
    private String name;

    @Column(name = "password")
    @Length(min = 5,message = "*Your password must have at least 5 character")
    @NotEmpty(message = "please provide your password")
    private String password;

    @Column(name = "fullname")
    @NotEmpty(message = "*please provide fullname")
    private String fullname;

    @Column(name = "level")
    private Integer level;

    @Column(name = "status")
    private Integer status;

    @OneToMany()
    @JoinColumn(name = "sub_id",referencedColumnName = "id")
    private ArrayList<submission> submissions;

    public user_profile() {
    }

    public ArrayList<submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(ArrayList<submission> submissions) {
        this.submissions = submissions;
    }

    public user_profile(@NotEmpty(message = "please provide username") String username, @Length(min = 5, message = "*Your password must have at least 5 character") @NotEmpty(message = "please provide your password") String password, @NotEmpty(message = "*please provide fullname") String fullname, Integer level, Integer status) {
        this.name = username;
        this.password = password;
        this.fullname = fullname;
        this.level = level;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
