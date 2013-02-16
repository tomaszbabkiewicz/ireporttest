package com.myfaces.model.database;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="person")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_id")
	private Long userId;

	private String login;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	

	@Temporal(TemporalType.TIMESTAMP)
	private Date birthday;
	
	private boolean active;
	private boolean deleted;
	
	private String pwContractorID;
	private String erpCodeRec;
	private String erpCodeRel;
	private String erpCodeDel;

	@Column(columnDefinition="TEXT")
	private String oldPasswords;
	
    
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOldPasswords() {
		return oldPasswords;
	}

	public void setOldPasswords(String oldPasswords) {
		this.oldPasswords = oldPasswords;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getPwContractorID() {
		return pwContractorID;
	}

	public void setPwContractorID(String pwContractorID) {
		this.pwContractorID = pwContractorID;
	}

	public String getErpCodeRec() {
		return erpCodeRec;
	}

	public void setErpCodeRec(String erpCodeRec) {
		this.erpCodeRec = erpCodeRec;
	}

	public String getErpCodeRel() {
		return erpCodeRel;
	}

	public void setErpCodeRel(String erpCodeRel) {
		this.erpCodeRel = erpCodeRel;
	}

	public String getErpCodeDel() {
		return erpCodeDel;
	}

	public void setErpCodeDel(String erpCodeDel) {
		this.erpCodeDel = erpCodeDel;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set 
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User[ userId=" + userId + " ]";
    }

}
