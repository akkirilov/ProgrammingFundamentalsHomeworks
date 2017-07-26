package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.License;

@Repository
public interface LicenseRepository extends JpaRepository<License, Long> {

	License findByName(String name);

}
