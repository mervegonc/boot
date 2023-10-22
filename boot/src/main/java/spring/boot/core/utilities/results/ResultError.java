package spring.boot.core.utilities.results;

public class ResultError extends Result {

	public ResultError() {
		super(false);// boş mesajsız
	}

	public ResultError(String message) {
		super(false, message);// yanlış ve message
	}
}
