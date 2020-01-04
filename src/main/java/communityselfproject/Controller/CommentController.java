package communityselfproject.Controller;

import communityselfproject.dto.CommentDTO;
import communityselfproject.mapper.CommentMapper;
import communityselfproject.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author qwj
 * @version 1.0
 * @date 2020/1/3 10:56
 */
@RestController
public class CommentController {

    @Autowired
    private CommentMapper commentMapper;

    @PostMapping(value = "/comment")
    public Object post(@RequestBody CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setCommentator(1);
        comment.setLikeCount(0L);
        commentMapper.insert(comment);
        return null;
    }
}
