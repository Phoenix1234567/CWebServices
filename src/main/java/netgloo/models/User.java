package netgloo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "user_id", unique = true)
	private String id;

	@NotNull
	@Column(name = "first_name")
	@Size(max = 10)
	private String firstName;

	@NotNull
	@Column(name = "last_name")
	@Size(max = 10)
	private String lastName;

	@NotNull
	@Column(name = "mobile_no")
	@Size(max = 10)
	private String mobileNo;

	@NotNull
	@Column(name = "email_id")
	@Size(max = 30)
	private String emailId;

	@Column(name = "referral_code")
	@Size(max = 15)
	private String referralCode;

	@Column(name = "referred_code")
	@Size(max = 15)
	private String referredCode;
	
	@NotNull
	@Column(name = "password")
	@Size(max = 15)
	private String password;

	
	public User() {
	}

	public User(String firstName, String lastName, String mobileNo, String emailId, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

	public String getReferralCode() {
		return referralCode;
	}

	public void setReferralCode(String referralCode) {
		this.referralCode = referralCode;
	}

	public String getReferredCode() {
		return referredCode;
	}

	public void setReferredCode(String referredCode) {
		this.referredCode = referredCode;
	}

}