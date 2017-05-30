package netgloo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not found")
public class EmployeeNotFoundException extends RuntimeException {
	private final Logger logger = LoggerFactory.getLogger(EmployeeNotFoundException.class);
	private static final long serialVersionUID = 100L;

	public EmployeeNotFoundException(String id) {
		super("Employee with employee id '" + id + "' not found");
		logger.error("Employee with employeeId '" + id + "' not found");
	}
}
