package akkProject.repository;

import akkProject.entity.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Integer> {
    ContactDetails findByDetailsUserId(Integer id);
}
