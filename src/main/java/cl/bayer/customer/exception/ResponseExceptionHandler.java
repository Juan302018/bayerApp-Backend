package cl.bayer.customer.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> manejadorTodasLasExcepciones(ModelNotFoundException ex,
			WebRequest req) {
		ExceptionResponse eRes = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), req.getDescription(true));
		return new ResponseEntity<ExceptionResponse>(eRes, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ModelNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> manejadorModeloExcepciones(ModelNotFoundException ex,
			WebRequest req) {
		ExceptionResponse eRes = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), req.getDescription(true));
		return new ResponseEntity<ExceptionResponse>(eRes, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest req) {
		ExceptionResponse eRes = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<Object>(eRes, HttpStatus.BAD_REQUEST);
	}

}