package br.com.jwm.lalapizzadelivery.app.client.to.translator;

import br.com.jwm.lalapizzadelivery.app.core.entity.BaseEntity;
import br.com.jwm.lalapizzadelivery.app.core.to.BaseTO;

public interface Translator<E extends BaseEntity, TO extends BaseTO>{

	E toToEntity(TO to);
	TO entityToTO(E e);
}
