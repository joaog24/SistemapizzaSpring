package br.fepi.listaproduto.repository;

import br.fepi.listaproduto.model.Produto;



import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServicesImpl
	implements ProdutoServices {

	@Autowired private ProdutoRepository prodRepo;

	@Override public List<Produto> getAllProduto()
	{
		return prodRepo.findAll();
	}

	@Override public void save(Produto produto)
	{
		prodRepo.save(produto);
	}

	@Override public Produto getById(Long id)
	{
		Optional<Produto> optional = prodRepo.findById(id);
		Produto produto = null;
		if (optional.isPresent())
			produto = optional.get();
		else
			throw new RuntimeException(
				"Produto nao encontrado para o id : " + id);
		return produto;
	}

	@Override public void deleteViaId(long id)
	{
		prodRepo.deleteById(id);
	}
}
