package kodlamaio.hrms.dataAccess.abstracts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CV.CoverLetter;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer> {
	CoverLetter getByCoverLetterId(int coverLetterId);
}
