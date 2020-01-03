package communityselfproject.exception;

/**
 * @author qwj
 * @version 1.0
 * @date 2019/12/31 16:39
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode{
//
    QUESTION_NOT_FOUND("您要找的文章不存在，可以浏览其他文章哦！");

    @Override
    public String getMessage(){
        return message;
    }
    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }
}
