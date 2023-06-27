package br.com.devsibre.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.devsibre.Dtos.FamiliaDTO;
import br.com.devsibre.ServiceImpl.FamiliaServiceImpl;

@RestController
@RequestMapping("/familia")
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
        List<FamiliaDTO> retorno = new ArrayList<>();
        ModelAndView model = new ModelAndView("listaFamilia.html");
        if (nome == null) {
            retorno = familiaService.buscarPorNome(nome);
        } else {
            retorno = familiaService.buscarPorNome(nome);
        }

        model.addObject("familia", retorno);
        model.addObject("nome", nome);
        return model;
    }

}

