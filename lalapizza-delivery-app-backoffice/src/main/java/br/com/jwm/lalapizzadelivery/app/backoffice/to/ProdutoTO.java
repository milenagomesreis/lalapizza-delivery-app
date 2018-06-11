package br.com.jwm.lalapizzadelivery.app.backoffice.to;

import br.com.jwm.lalapizzadelivery.app.core.entity.Categoria;
import br.com.jwm.lalapizzadelivery.app.core.to.BaseTO;
import org.springframework.data.annotation.Transient;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProdutoTO extends BaseTO {

	private Long id;

	@NotBlank
	private String nome;

	@NotBlank
	private String descricao;

	@NotNull
	private Double valorUnitario;

	private Categoria categoria = new Categoria();

	private MultipartFile imagem;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public MultipartFile getImagem() {
		return imagem;
	}

	public void setImagem(MultipartFile imagem) {
		this.imagem = imagem;
	}

	@Transient
	public boolean isCreate() {
		return id == null;
	}
}
