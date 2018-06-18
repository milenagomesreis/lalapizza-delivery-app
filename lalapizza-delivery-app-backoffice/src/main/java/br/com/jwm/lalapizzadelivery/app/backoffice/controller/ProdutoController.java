package br.com.jwm.lalapizzadelivery.app.backoffice.controller;

import br.com.jwm.lalapizzadelivery.app.backoffice.to.ProdutoTO;
import br.com.jwm.lalapizzadelivery.app.core.entity.Produto;
import br.com.jwm.lalapizzadelivery.app.core.repository.ProdutoRepository;
import br.com.jwm.lalapizzadelivery.app.core.service.CategoriaService;
import br.com.jwm.lalapizzadelivery.app.core.cloudinary.service.CloudinaryService;
import br.com.jwm.lalapizzadelivery.app.core.service.ProdutoService;
import br.com.jwm.lalapizzadelivery.app.backoffice.to.translator.ProdutoTOTranslator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.NoResultException;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoTOTranslator produtoTOTranslator;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private CloudinaryService cloudinaryService;

	@GetMapping
	public String listar(Model model) {

		model.addAttribute("produtos", produtoService.listar());

		return "produto/lista";
	}

	@GetMapping("/novo")
	public String exibirFormulario(Model model, ProdutoTO produtoTO) {

		model.addAttribute("categorias", categoriaService.listar());

		return "produto/formulario";
	}

	@PostMapping("/novo")
	public String adicionar(Model model, @Valid ProdutoTO produtoTO, BindingResult bindingResult) {

		if (produtoTO.isCreate() && produtoTO.getImagem() == null) {
			bindingResult.addError(new FieldError("produtoTO", "imagem", "Imagem é obrigatória"));
		}

		if (bindingResult.hasErrors()) {
			return exibirFormulario(model, produtoTO);
		}

		Map<String, String> imageMap = new HashMap<>();

		if (produtoTO.isCreate() || produtoTO.getImagem() != null) {

			File file = new File("/tmp/imagemProduto-" + produtoTO.getNome() + "-" + produtoTO.getImagem().getOriginalFilename());

			try {
				FileUtils.writeByteArrayToFile(file, produtoTO.getImagem().getBytes());
				imageMap = cloudinaryService.uploadImage(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Produto produto = produtoTOTranslator.toToEntity(produtoTO);
		produto.setUrlImagem(imageMap.get("url"));

		produtoService.salvar(produto);

		return "redirect:/admin/produtos";
	}

	@GetMapping("/{id}/editar")
	public String exibirFormulario(Model model, @PathVariable String id) {

		if (!StringUtils.isNumeric(id)) {
			return "/errors/404";
		}

		try {
			Produto produto = produtoService.getById(Long.valueOf(id));

			model.addAttribute("produtoTO", produtoTOTranslator.entityToTO(produto));
			model.addAttribute("categorias", categoriaService.listar());
		} catch (NoResultException e) {
			return "/errors/404";
		}

		return "produto/formulario";
	}


}
