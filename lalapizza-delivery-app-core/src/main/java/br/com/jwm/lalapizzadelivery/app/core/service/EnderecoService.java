package br.com.jwm.lalapizzadelivery.app.core.service;

import br.com.jwm.lalapizzadelivery.app.core.entity.Cidade;
import br.com.jwm.lalapizzadelivery.app.core.entity.Endereco;
import br.com.jwm.lalapizzadelivery.app.core.exception.RegistroNaoEncontradoException;
import br.com.jwm.lalapizzadelivery.app.core.util.StringPTBRUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection.Response;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnderecoService {

	@Autowired
	private CidadeService cidadeService;

	@Autowired
	private EstadoService estadoService;


	public Endereco getByCEP(String cep) throws Exception {

		Response response = Jsoup.connect("http://www.buscacep.correios.com.br/sistemas/buscacep/resultadoBuscaEndereco.cfm")
				.method(Method.POST)
				.data("CEP", cep)
				.execute();

		if(StringUtils.contains(response.body(), "CEP NAO ENCONTRADO")) {
			throw new RegistroNaoEncontradoException();
		}

		Document document = response.parse();

		Element tmptabela = document.getElementsByClass("tmptabela").first();

		if(tmptabela == null) {
			throw new Exception();
		}

		tmptabela.getElementsByTag("tr").first().remove();

		Element registro = tmptabela.getElementsByTag("tr").first();

		Elements colunas = registro.getElementsByTag("td");

		String uf = StringUtils.substringAfter(colunas.get(2).html(), "/");
		List<Cidade> cidades = cidadeService.findByEstadoUF(uf);

		final String cidadeCorreios = StringUtils.substringBefore(colunas.get(2).html(), "/");

		Cidade cidade = cidades.stream().filter(c-> {

			String cidadeList = StringPTBRUtils.removeAcentos(c.getNome());
			String cidade2 = StringPTBRUtils.removeAcentos(cidadeCorreios);

			return StringUtils.equalsIgnoreCase(cidadeList, cidade2);
		}).findFirst().orElseThrow(() -> new Exception());

		Endereco endereco = new Endereco();
		endereco.setLogradouro(StringPTBRUtils.removeNonBreakingSpace(colunas.get(0).html()));
		endereco.setBairro(StringPTBRUtils.removeNonBreakingSpace(colunas.get(1).html()));
		endereco.setCidade(cidade);
		endereco.setCep(StringPTBRUtils.removeNonBreakingSpace(colunas.get(3).html()));

		return endereco;


	}
}
