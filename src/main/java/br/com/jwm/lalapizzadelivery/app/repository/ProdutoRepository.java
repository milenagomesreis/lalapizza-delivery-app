package br.com.jwm.lalapizzadelivery.app.repository;

import br.com.jwm.lalapizzadelivery.app.entity.Produto;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository extends GenericRepository<Produto, Long> {
}
