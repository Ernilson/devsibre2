package br.com.devsibre;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.devsibre.Dtos.FamiliaDTO;

import br.com.devsibre.ServiceImpl.FamiliaServiceImpl;

@SpringBootTest
public class FamiliaServiceImplTeste {

	@Autowired
	private FamiliaServiceImpl familiaService;
	
	public FamiliaServiceImplTeste() {
		// TODO Auto-generated constructor stub
	}
	
	 @Test
	    void contextLoads() {
	       
	        List<FamiliaDTO> listaDTO = familiaService.buscarPorNome("Fulano");
	        for (FamiliaDTO f : listaDTO) {
	           System.out.println(f.getFormulario().getNome() +" "+ f.getFamilia().getNomeDoConjuge() + " Data de Nasc ->"+ f.getFamilia().getdataNascEsp() +" Email " + f.getFamilia().getEmail()
	            		+"filhos" + f.getFilhos());
	        }
	    }

}
