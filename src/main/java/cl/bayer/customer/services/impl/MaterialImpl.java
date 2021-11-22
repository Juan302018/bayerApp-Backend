package cl.bayer.customer.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.bayer.customer.model.Material;
import cl.bayer.customer.repo.IMaterialRepo;
import cl.bayer.customer.servicess.IMaterialService;

@Service
public class MaterialImpl implements IMaterialService{

	@Autowired
	private IMaterialRepo repo;

	@Override
	public Material registrar(Material obj) {
		return repo.save(obj);
	}

	@Override
	public List<Material> listar() {
		return repo.findAll();
	}

	@Override
	public Material modificar(Material obj) {
		return repo.save(obj);
	}

	@Override
	public Material leerPorId(Long id) {
		Optional<Material> op = repo.findById(id);
		return op.isPresent()?op.get(): new Material();
	}

	@Override
	public boolean eliminar(Long id) {
		repo.deleteById(id);
		return true;
	}
}
