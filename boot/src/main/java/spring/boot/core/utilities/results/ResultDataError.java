package spring.boot.core.utilities.results;

public class ResultDataError<T> extends ResultData<T>{// DATA + MESSAGE      MESSAGE     DATA     NULL
													 // burada data olmasa bile null vermek zorundayız true ve false da zaten olmaz ise olmaz
	public ResultDataError(T data, String message) {
		super(data, false, message);
	}
	
	public ResultDataError(T data) {
		super(data, false);
	}
	public ResultDataError(String message) {
		super(null, false, message);
	}
	public ResultDataError() {
		super(null, false);
	}


}
