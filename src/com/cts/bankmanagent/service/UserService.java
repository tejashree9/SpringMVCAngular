package com.cts.bankmanagement.service;

import java.util.List;

import com.cts.bankmanagement.vo.UserVO;

public interface UserService {

	Long addUserDetails(UserVO userVO);

	List<UserVO> getUsersDetails();

	UserVO getUserDetails(Long accountNo);
}
