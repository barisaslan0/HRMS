package kodlamaio.hrms.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Email(message = "Email formatı geçersiz")
	@NotBlank(message = "Email boş olamaz")
	@Column(name = "email")
	private String email;

	@Size(min = 6, message = "şifre min 6 karakterli olmalı")
	@NotBlank(message = "Şifre boş olamaz")
	@Column(name = "password")
	private String password;

	@Column(name = "is_verify_email")
	private boolean isVerifyEmail;

	@OneToOne(mappedBy = "user")
	private Image image;

	public User(int userId) {
		super();
		this.userId = userId;
	}
}