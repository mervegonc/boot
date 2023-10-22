package spring.boot.core.utilities.results;

public class ResultDataSuccess<T> extends ResultData<T> {

	public ResultDataSuccess(T data, String message) {// başarılı olduğunu tekrar söylemeye gerek yok
		super(data, true, message);
	}

	public ResultDataSuccess(T data) {
		super(data, true);
	}

	public ResultDataSuccess(String message) {// data döndermek istemiyorum null
		super(null, true, message);
	}
	
	public ResultDataSuccess() {// hiçbir şey istemiyorum
		super(null,true);
	}

}
