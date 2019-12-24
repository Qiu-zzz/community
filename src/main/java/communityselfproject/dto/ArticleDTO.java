package communityselfproject.dto;

import communityselfproject.model.User;
import lombok.Data;

/**
 * @author qwj
 * @version 1.0
 * @date 2019/12/24 14:30
 */
@Data
public class ArticleDTO {
    private Integer id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
    private User user;
}

