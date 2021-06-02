package kodlamaio.hrms.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OptimisticLock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "images")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "user" })
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id")
	private int imageId;

	@Column(name = "name")
	private String name;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "public_id")
	private String publicId;

	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = "user_id")
	@OneToOne()
	private User user;

	public Image(String name, String imageUrl, String publicId, User user) {
		this.name = name;
		this.imageUrl = imageUrl;
		this.publicId = publicId;
		this.user = user;

	}

}
