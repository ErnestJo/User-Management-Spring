package ernestui.usermanagement.data;

import lombok.Data;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 22/06/2023 - 16:25
 * @project user-management
 */
@Data
public class GeneralResponse<T>{
    private String statusCode;
    private String message;
    private T body;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
