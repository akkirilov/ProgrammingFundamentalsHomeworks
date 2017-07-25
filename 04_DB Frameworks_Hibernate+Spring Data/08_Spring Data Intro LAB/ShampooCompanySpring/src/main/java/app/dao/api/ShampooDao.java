package app.dao.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.BasicShampoo;

@Repository
public interface ShampooDao extends JpaRepository<BasicShampoo, Long> {
	
	List<BasicShampoo> findAllByIngredientsId (Long Id); 

}
