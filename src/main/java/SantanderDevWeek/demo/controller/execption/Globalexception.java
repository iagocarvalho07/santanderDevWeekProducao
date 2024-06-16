package SantanderDevWeek.demo.controller.execption;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Globalexception {

   private final Logger logger = LoggerFactory.getLogger(Globalexception.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> hanlderbusinessException(IllegalArgumentException businessException){
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchFieldException.class)
    public ResponseEntity<String> hanlderNoSuchFieldException(NoSuchFieldException NoSuchFieldException){
        return new ResponseEntity<>("Resource ID not Found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> hanlderUnexpectedExpction(Throwable unexpectedExpction){
        var message = "Unexpected server error, see the logs.";
        logger.error(message, unexpectedExpction);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
