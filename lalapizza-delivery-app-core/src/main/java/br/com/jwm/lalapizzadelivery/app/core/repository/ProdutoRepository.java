package br.com.jwm.lalapizzadelivery.app.core.repository;

import br.com.jwm.lalapizzadelivery.app.core.entity.Produto;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository extends GenericRepository<Produto, Long> {
}
