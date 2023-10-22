package spring.boot.core.utilities.results;

public class ResultSuccess extends Result {

	public ResultSuccess(){
		super(true);
		}
	
	public ResultSuccess(String message) {
		super(true,message);
	}

}
