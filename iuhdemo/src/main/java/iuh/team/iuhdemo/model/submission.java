package iuh.team.iuhdemo.model;

import javax.persistence.*;

@Entity
public class submission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "problem_id",referencedColumnName = "id")
    private problem problem;

    private String score;

    private String source_code;

    @ManyToOne()
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private user_profile user_profile;

    public submission() {
    }

    public submission(iuh.team.iuhdemo.model.problem problem, String score, String source_code, iuh.team.iuhdemo.model.user_profile user_profile) {
        this.problem = problem;
        this.score = score;
        this.source_code = source_code;
        this.user_profile = user_profile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public iuh.team.iuhdemo.model.problem getProblem() {
        return problem;
    }

    public void setProblem(iuh.team.iuhdemo.model.problem problem) {
        this.problem = problem;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSource_code() {
        return source_code;
    }

    public void setSource_code(String source_code) {
        this.source_code = source_code;
    }

    public iuh.team.iuhdemo.model.user_profile getUser_profile() {
        return user_profile;
    }

    public void setUser_profile(iuh.team.iuhdemo.model.user_profile user_profile) {
        this.user_profile = user_profile;
    }
}
