package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer> {
	Image getByImageId(int imageId);

//	void removeByImageId(int imageId);
}
