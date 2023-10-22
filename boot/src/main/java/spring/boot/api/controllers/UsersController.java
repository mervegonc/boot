package spring.boot.api.controllers;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.validation.FieldError;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import spring.boot.business.abstracts.UserService;
import spring.boot.core.entities.User;
import spring.boot.core.utilities.results.ResultDataError;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user) {
		return ResponseEntity.ok(this.userService.add(user));
	}

	
	@ExceptionHandler(MethodArgumentNotValidException.class) /* bu anatosyon olursa bu tipse(class) bu methodu yap */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResultDataError<Object> handleValidationException
	(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ResultDataError<Object> errors 
		= new ResultDataError<Object>(validationErrors, "Validation Errors");
		return errors;
	}

	/*
	 * AOP tüm methodları bu opr herhangibir hata olursa ||global exp|| handlerden
	 * geçir sonra opr 200 get 201 add 300 400 hata 500 hata ok 200 http oldu ?
	 * unknown
	 */
}
