package com.cts.bankmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.cts.bankmanagement.entity.User;
import com.cts.bankmanagement.vo.UserVO;

@Repository("userDao")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Long addUserDetails(UserVO userVO) {
		User user = prepareUser(userVO);
		Long accountNumber = (Long) sessionFactory.getCurrentSession().save(
				user);
		return accountNumber;
	}

	@Override
	public boolean isAccountExist(Long accountNumber) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User where accountNumber=:accountNumber");
		query.setParameter("accountNumber", accountNumber);
		return CollectionUtils.isEmpty(query.list());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserVO> getUsersDetails() {
		List<User> users = sessionFactory.getCurrentSession()
				.createCriteria(User.class).list();
		List<UserVO> usersVO = new ArrayList<UserVO>(users.size());
		for (User user : users) {
			usersVO.add(prepareUserVO(user));
		}
		return usersVO;
	}

	@Override
	public UserVO getUserDetails(Long accountNo) {
		return prepareUserVO((User) sessionFactory.getCurrentSession().get(
				User.class, accountNo));
	}
	
	public static UserVO getUserVO(User user) {
		if (user != null) {
			return new UserVO(user.getAccountNumber(), user.getAccountType(), user.getAccountHolderName(),
					user.getAccountBalance());
		}
		return null;
	}

	private User prepareUser(UserVO userVO) {
		return new User(userVO.getAccountNumber(), userVO.getAccountType(),
				userVO.getAccountHolderName(), userVO.getAccountBalance());
	}

	private UserVO prepareUserVO(User user) {
		return new UserVO(user.getAccountNumber(), user.getAccountType(),
				user.getAccountHolderName(), user.getAccountBalance());
	}

}