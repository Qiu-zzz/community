package communityselfproject.model;

import lombok.Data;

/**
 * @author qwj
 * @version 1.0
 * @date 2019/12/20 15:33
 */
@Data
public class User {
    private Integer id;
    private String name;
    private Integer accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;


}
