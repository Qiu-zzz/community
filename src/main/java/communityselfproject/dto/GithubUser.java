package communityselfproject.dto;

/**
 * @author qwj
 * @version 1.0
 * @date 2019/12/19 17:47
 */
public class GithubUser {
    private String name;
    private long id;
    private String bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
