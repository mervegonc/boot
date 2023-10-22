package spring.boot.core.utilities.results;

public class ResultData<T> extends Result {

	private T data;

	public ResultData(T data, boolean success, String message) {
		super(success, message);
		this.data = data;

	}

	public ResultData(T data, boolean success) {
		super(success);
		this.data = data;

	}

	public T getData() {
		return this.data;
	}

}

//super success ve message i base sınıfta set ediyor zaten bir daha set etmeye
// gerke yok bu yüzden super in içine yazıyoruz
// t burada amaç biz bu resultu döndürüken sadece başarılı ve mesaj i değil bir
// de data döndermeliyiz
