package br.com.devsibre.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import br.com.devsibre.Dtos.FamiliaDTO;
import br.com.devsibre.ServiceImpl.FamiliaServiceImpl;

@Controller
public class FamiliaController {

	private final FamiliaServiceImpl familiaService;

	@Autowired
	public FamiliaController(FamiliaServiceImpl familiaService) {
		this.familiaService = familiaService;
	}

	@GetMapping("/{nome}")
	public List<FamiliaDTO> buscarPorNome(@PathVariable String nome) {
		return familiaService.buscarPorNome(nome);
	}
	
	 //Metodo para listar todos e buscar os cadastros
	@GetMapping("/listarfamilia")
    public ModelAndView lista(@RequestParam(value = "nome", required = false) String nome) {
        List<FamiliaDTO> retorno;
        ModelAndView model = new ModelAndView("listaFamilia");

        if (nome == null) {
        	 retorno = familiaService.buscarPorNome(nome); // Retorna todas as famílias
        } else {
           retorno = familiaService.listarTodasFamilias(); // Retorna as famílias com o nome especificado
        }

        model.addObject("familia", retorno);
        model.addObject("nome", nome);
        return model;
    }

}

