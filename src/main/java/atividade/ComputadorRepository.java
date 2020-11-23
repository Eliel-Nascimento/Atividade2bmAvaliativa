package atividade;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ComputadorRepository extends JpaRepository<Computador, String> {
	@Query(value = "select modelo from computador",nativeQuery = true)
	List<String> getModelos();
}