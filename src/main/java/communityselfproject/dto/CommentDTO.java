package communityselfproject.dto;

import lombok.Data;

/**
 * @author qwj
 * @version 1.0
 * @date 2020/1/3 11:07
 */
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
