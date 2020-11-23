package atividade;

import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ComputadorError {
	@ExceptionHandler({EmptyResultDataAccessException.class,NoSuchElementException.class})
	public ResponseEntity<Void> handleNotFound() {
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(idComputadorException.class)
	public ResponseEntity<Void> handleConflict() {
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}

	@ExceptionHandler(idCompException.class)
	public ResponseEntity<Void> handleBadRequest() {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

}
