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
	       
	        List<FamiliaDTO> listaDTO = familiaService.buscarPorNome("fulano");
	        for (FamiliaDTO f : listaDTO) {
	            System.out.println("Familia: " + f.getFamilia() + "Filhos" + f.getFilhos() + "Formulario" + f.getFormulario());
	        }
	    }

}