package br.fepi.listaproduto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.fepi.listaproduto.model.Produto;
import br.fepi.listaproduto.repository.ProdutoServicesImpl;


@Controller
public class ProdutoController {

	@Autowired
	private ProdutoServicesImpl produtoServicesImpl;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("allemplist", produtoServicesImpl.getAllProduto());
		return "index";
	}

	@GetMapping("/addnew")
	public String addNewProduto(Model model) {
		Produto produto = new Produto();
		model.addAttribute("produto", produto);
		return "novoproduto";
	}

	@PostMapping("/save")
	public String saveProduto(@ModelAttribute("produto") Produto produto) {
		produtoServicesImpl.save(produto);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String updateForm(@PathVariable(value = "id") long id, Model model) {
		Produto produto = produtoServicesImpl.getById(id);
		model.addAttribute("produto", produto);
		return "atualizar";
	}

	@GetMapping("/deleteProduto/{id}")
	public String deleteThroughId(@PathVariable(value = "id") long id) {
		produtoServicesImpl.deleteViaId(id);
		return "redirect:/";

	}
}

