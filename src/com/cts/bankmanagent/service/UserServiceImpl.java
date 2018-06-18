package com.cts.bankmanagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cts.bankmanagement.dao.UserDAO;
import com.cts.bankmanagement.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;

	@Override
	@Transactional
	public Long addUserDetails(UserVO userVO) {
		return userDao.addUserDetails(userVO);
	}

	@Override
	@Transactional
	public List<UserVO> getUsersDetails() {
		return userDao.getUsersDetails();
	}

	@Override
	@Transactional
	public UserVO getUserDetails(Long accountNo) {
		return userDao.getUserDetails(accountNo);
	}

}
