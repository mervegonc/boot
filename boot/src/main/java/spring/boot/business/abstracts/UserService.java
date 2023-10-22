package spring.boot.business.abstracts;

import spring.boot.core.entities.User;
import spring.boot.core.utilities.results.Result;
import spring.boot.core.utilities.results.ResultData;

public interface UserService {

	Result add(User user);

	ResultData<User> findByEmail(String email);

}
