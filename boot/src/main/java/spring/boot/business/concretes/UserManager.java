package spring.boot.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.business.abstracts.UserService;
import spring.boot.core.dataAccess.UserDao;
import spring.boot.core.entities.User;
import spring.boot.core.utilities.results.Result;
import spring.boot.core.utilities.results.ResultData;
import spring.boot.core.utilities.results.ResultDataSuccess;
import spring.boot.core.utilities.results.ResultSuccess;

@Service
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new ResultSuccess("User Registered Successfuly");
	}

	@Override
	public ResultData<User> findByEmail(String email) {
		return new ResultDataSuccess<User>(this.userDao.findByEmail(email)
				, "User Found");
	}

}
