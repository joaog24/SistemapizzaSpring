package br.fepi.listaproduto.repository;

import java.util.List;

import br.fepi.listaproduto.model.Produto;

public interface ProdutoServices {
	List<Produto> getAllProduto();
	void save(Produto produto);
	Produto getById(Long id);
	void deleteViaId(long id);
}

