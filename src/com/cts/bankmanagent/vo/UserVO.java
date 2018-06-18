/**
 * This is our entity class and it corresponds to USER_DETAILS table in database
 * @author 606273
 */

package com.cts.bankmanagement.vo;

public class UserVO {

	private Long accountNumber;

	private String accountType;

	private String accountHolderName;

	private Double accountBalance;

	public UserVO() {
		super();
	}
	
	public UserVO(Long accountNumber) {
		this(accountNumber, null, null, null);
	}

	public UserVO(Long accountNumber, String accountType,
			String accountHolderName, Double accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
}