package communityselfproject.dto;

import lombok.Data;

/**
 * @author qwj
 * @version 1.0
 * @date 2019/12/19 17:47
 */
@Data
public class GithubUser {
    private String name;
    private Integer id;
    private String bio;
    private String avatarUrl;
}
