package arisimons.simons.Exceptions;

import arisimons.simons.Entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class ResponseEntityExceptHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> UserNotFoundException(UserNotFoundException exception, WebRequest request){
        ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
    @ExceptionHandler(EmailFoundException.class)
    public ResponseEntity<ErrorMessage> EmailFoundException(EmailFoundException exception,WebRequest request){
        ErrorMessage message=new ErrorMessage(HttpStatus.FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.FOUND).body(message);
    }
    @ExceptionHandler(UserNameException.class)
    public ResponseEntity<ErrorMessage> UserNameException(UserNotFoundException exception, WebRequest request){
        ErrorMessage message=new ErrorMessage(HttpStatus.FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.FOUND).body(message);
    }
    @ExceptionHandler(NameFoundException.class)
    public  ResponseEntity<ErrorMessage> NameFoundException(NameFoundException exception,WebRequest request){
        ErrorMessage message= new ErrorMessage(HttpStatus.FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.FOUND).body(message);
    }

}





















