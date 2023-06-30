package br.com.devsibre.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.devsibre.Dtos.FamiliaDTO;
import br.com.devsibre.Model.ConjugeModel;
import br.com.devsibre.Model.FilhoModel;
import br.com.devsibre.Model.FormularioModel;
import br.com.devsibre.ServiceImpl.FamiliaServiceImpl;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

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
        List<FamiliaDTO> retorno = null;
        ModelAndView model = new ModelAndView("listaFamilia");

        if (nome == null) {
       	 retorno = familiaService.buscarPorNome(nome); // Retorna as famílias com o nome especificado 
        } else {
        	retorno = familiaService.buscarPorNome(nome);   // Retorna todas as famílias
        }

        model.addObject("familia", retorno);
        model.addObject("nome", nome);
        return model;
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/incluir")
	public ResponseEntity<String> incluirDadosNoFormulario(@RequestBody FormularioModel formulario, ConjugeModel cm, List<FilhoModel> fi) {
	    try {
	        // Obtenha os dados do formulário
	        String nome = formulario.getNome();
	        String email = formulario.getEmail();
	        String dataNasc = formulario.getData();
	        String telefone = formulario.getFone();
	        String status = formulario.getStatus();
	        String cep = formulario.getCep();
	        String localidade = formulario.getLocalidade();
	        String logadouro = formulario.getLogradouro();
	        String bairro = formulario.getBairro();
	        String uf = formulario.getUf();
	        ConjugeModel familia = formulario.getFamilia();
	        
	        FormularioModel fm = new FormularioModel();
	        fm.setNome(nome);
	        fm.setEmail(email);
	        fm.setData(dataNasc);
	        fm.setFone(telefone);
	        fm.setStatus(status);
	        fm.setCep(cep);
	        fm.setLocalidade(localidade);
	        fm.setLogradouro(logadouro);
	        fm.setBairro(bairro);
	        fm.setUf(uf);
	        fm.setFamilia(familia);
	        
	        	        
	        ConjugeModel conjuge = new ConjugeModel();
	        conjuge.setNomeDoConjuge(cm.getNomeDoConjuge());
	        conjuge.setdataNascEsp(cm.getdataNascEsp());
	        conjuge.setQuantidadeFilhos(cm.getQuantidadeFilhos());
	        conjuge.setTelefone(cm.getTelefone());
	        conjuge.setSeBatizado(cm.getSeBatizado());
	        conjuge.setStatus(cm.getStatus());
	        
	        for (FilhoModel filhoForm : fi) {
	            FilhoModel filho = new FilhoModel();
	            filho.setNome(filhoForm.getNome());
	            filho.setEmail(filhoForm.getEmail());
	            filho.setDataNascProl(filhoForm.getDataNascProl());
	            filho.setTelefone(filhoForm.getTelefone());
	            filho.setFamilia(conjuge);
	            filho.setStatus(filhoForm.getStatus());
	            filho.setSeBatizado(filhoForm.getSeBatizado());
	            
	            fi.add(filho);
	        }
	        
	        // Chame o método para incluir os dados nas tabelas
	        familiaService.incluirDadosNasTabelas2(fm, conjuge, fi);
	        
	        return ResponseEntity.ok("Dados incluídos com sucesso!");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao incluir os dados.");
	    }
	}


}

