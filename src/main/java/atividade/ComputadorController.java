package atividade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/computadores")
public class ComputadorController {
	@Autowired
	private ComputadorRepository repo;

	@GetMapping
	public List<Computador> getAll() {
		return repo.findAll();

	}
	@GetMapping("/modelos")
	public String modelos() {
		List<String> modelos = repo.getModelos();	
					
		return "Modelos: "+modelos;
	}

	@GetMapping("/{id}")
	public Computador getById(@PathVariable String id) {
		return repo.findById(id).get();
	}

	@PostMapping
	public String post(@RequestBody Computador novo) {
		if (repo.existsById(novo.getId())) {
			throw new idComputadorException();
		}
		novo = repo.save(novo);
		return novo.getId();
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable String id) {
		repo.deleteById(id);
	}

	@PutMapping("/{id}")
	public void put(@PathVariable String id, @RequestBody Computador novo) {
		if (!id.equals(novo.getId())) {
			throw new idCompException();
		}
		if (!repo.existsById(novo.getId())) {
			throw new idComputadorException();
		}
		repo.save(novo);
	}

}
