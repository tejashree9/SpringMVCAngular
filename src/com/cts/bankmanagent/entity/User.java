/**
 * This is our entity class and it corresponds to USER_DETAILS table in database
 * @author 606273
 */

package com.cts.bankmanagement.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class User implements Serializable {

	private static final long serialVersionUID = 1898989899899L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ACCOUNT_NUMBER")
	private Long accountNumber;

	@Column(name = "ACCOUNT_TYPE")
	private String accountType;

	@Column(name = "ACCOUNT_HOLDER_NAME")
	private String accountHolderName;

	@Column(name = "ACCOUNT_BALANCE")
	private Double accountBalance;

	@OneToMany
	@JoinColumn(name = "ACCOUNT_NUMBER")
	private List<EducationLoan> transactionDetail = new ArrayList<EducationLoan>();
	
	

	@Override
	public String toString() {
		return "User [accountNumber=" + accountNumber + ", accountType="
				+ accountType + ", accountHolderName=" + accountHolderName
				+ ", accountBalance=" + accountBalance + ", transactionDetail="
				+ transactionDetail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountBalance == null) ? 0 : accountBalance.hashCode());
		result = prime
				* result
				+ ((accountHolderName == null) ? 0 : accountHolderName
						.hashCode());
		result = prime * result
				+ ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result
				+ ((accountType == null) ? 0 : accountType.hashCode());
		result = prime
				* result
				+ ((transactionDetail == null) ? 0 : transactionDetail
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (accountBalance == null) {
			if (other.accountBalance != null)
				return false;
		} else if (!accountBalance.equals(other.accountBalance))
			return false;
		if (accountHolderName == null) {
			if (other.accountHolderName != null)
				return false;
		} else if (!accountHolderName.equals(other.accountHolderName))
			return false;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (transactionDetail == null) {
			if (other.transactionDetail != null)
				return false;
		} else if (!transactionDetail.equals(other.transactionDetail))
			return false;
		return true;
	}
	
	public User(Long accountNumber) {
		this(accountNumber, null, null, null);
	}

	public User() {
		super();
	}

	public User(Long accountNumber, String accountType,
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