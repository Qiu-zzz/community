package communityselfproject.model;

import lombok.Data;

/**
 * @author qwj
 * @version 1.0
 * @date 2019/12/23 14:59
 */
@Data
public class Article {
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
}
