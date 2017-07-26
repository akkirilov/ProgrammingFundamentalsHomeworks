package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

	Resource findByName(String name);

	List<Resource> findByLicensesIsNull();

}
