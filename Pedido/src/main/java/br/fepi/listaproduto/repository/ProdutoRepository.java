package br.fepi.listaproduto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fepi.listaproduto.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {

}
