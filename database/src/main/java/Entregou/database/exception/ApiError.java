package Entregou.database.exception;
import java.time.LocalDateTime;

public class ApiError {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String error;

    public ApiError( int status, String message, String error) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.error = error;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public int getStatus() {
        return status;
    }
    public String getError() {
        return error;
    }
    public String getMessage() {
        return message;
    }

}
