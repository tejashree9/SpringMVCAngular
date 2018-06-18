package com.cts.bankmanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.cts.bankmanagement.service.UserService;
import com.cts.bankmanagement.vo.UserVO;

@Controller
public class MainController {

	@Autowired
	private UserService userService;

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/hellospring", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String main() {
		System.out.println("Hi from here:::::::");
		return "hello from spring";
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserVO getUser() {
		return new UserVO(100L, "saving", "Deepak Rana", 190909d);
	}

	@ResponseBody
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<?> addUser(UriComponentsBuilder b,
			@RequestBody UserVO userVO) {

		userService.addUserDetails(userVO);
		UriComponents uriComponents = b.path("/users/{0}").buildAndExpand(
				userVO.getAccountNumber());

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponents.toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "forward: /static/html/home.html";
	}

	@RequestMapping(value = "/static/html/user/save", method = RequestMethod.POST)
	public ModelAndView performTran(
			@RequestParam("accountHolderName") String accountHolderName,
			@RequestParam("accountType") String accountType) {

		UserVO userVo = new UserVO(null, accountType, accountHolderName, null);
		Long accountNo = userService.addUserDetails(userVo);
		userVo.setAccountNumber(accountNo);
		return new ModelAndView("user/showUserDetail", "user", userVo);
	}

	@RequestMapping(value = "/users/list", method = RequestMethod.GET)
	public ModelAndView listUsers() {
		List<UserVO> usersList = userService.getUsersDetails();
		return new ModelAndView("/user/showUsersDetail", "users", usersList);
	}

	@RequestMapping(value = "/static/html/user/search", method = RequestMethod.POST)
	public ModelAndView performSearch(
			@RequestParam("accountNumber") Long accountNo) {
		UserVO user = userService.getUserDetails(accountNo);
		return new ModelAndView("/user/showUserDetail", "user", user);
	}

}