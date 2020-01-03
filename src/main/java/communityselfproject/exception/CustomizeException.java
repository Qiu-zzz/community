package communityselfproject.exception;

/**
 * @author qwj
 * @version 1.0
 * @date 2019/12/31 15:59
 */
public class CustomizeException extends RuntimeException {
    private String message;

    public CustomizeException(ICustomizeErrorCode iCustomizeErrorCode){
        this.message = iCustomizeErrorCode.getMessage();
    }

    public CustomizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
