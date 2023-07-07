package br.com.devsibre;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.devsibre.Dtos.FamiliaDTO;
import br.com.devsibre.Enuns.StatusEnum;
import br.com.devsibre.Model.ConjugeModel;
import br.com.devsibre.Model.FilhoModel;
import br.com.devsibre.Model.FormularioModel;
import br.com.devsibre.ServiceImpl.FamiliaServiceImpl;

@SpringBootTest
public class FamiliaServiceImplTeste {

	@Autowired
	private FamiliaServiceImpl familiaService;

	private final EntityManager entityManager;

	public FamiliaServiceImplTeste(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Test
	void contextLoads() {

//	        List<FamiliaDTO> listaDTO = familiaService.buscarPorNome("Fulano");
//	        for (FamiliaDTO f : listaDTO) {
//	           System.out.println(f.getFormulario().getNome() +" "+ f.getFamilia().getNomeDoConjuge() + " Data de Nasc ->"+ f.getFamilia().getdataNascEsp() +" Email " + f.getFamilia().getEmail()
//	            		+"filhos" + f.getFilhos());
//	        }

		incluirDadosNasTabelas();
		
		List<FamiliaDTO> listaDTO = familiaService.listarTodasFamilias();
		for (FamiliaDTO f : listaDTO) {
			System.out.println(f.getFormulario().getNome() + " " + f.getFamilia().getNomeDoConjuge()
					+ " Data de Nasc ->" + f.getFamilia().getdataNascEsp() + " Email " + f.getFamilia().getEmail()
					+ "filhos" + f.getFilhos());
		}		
		
	}

	public void incluirDadosNasTabelas() {
		// Criando e preenchendo os objetos com os dados a serem incluídos
		FormularioModel formulario = new FormularioModel();
		formulario.setNome("Ciclano");
		formulario.setFone("369852741");
		formulario.setEmail("beltrano@teste.com");
		formulario.setData("01/02/03");
		formulario.setUf("DF");
		formulario.setCep("72601108");
		formulario.setBairro("Recanto das Emas");
		formulario.setLocalidade("Brasília");
		formulario.setLogradouro("Quadra 101");
		formulario.setStatus("Membro");

		ConjugeModel conjuge = new ConjugeModel();
		conjuge.setNomeDoConjuge("Larissa Gomes");
		conjuge.setTelefone("159852357");
		conjuge.setEmail("larissa@test.com");
		conjuge.setdataNascEsp("02/03");
		conjuge.setQuantidadeFilhos(3);
		conjuge.setStatus(StatusEnum.Membro);
		conjuge.setSeBatizado(StatusEnum.Batizado);

		List<FilhoModel> filhos = new ArrayList<>();

		FilhoModel filho1 = new FilhoModel();
		filho1.setNome("Filho 1 do Ciclano");
		filho1.setDataNascProl("01/01");
		filho1.setTelefone("123456789");
		filho1.setEmail("filho1@test.com");
		filho1.setStatus(StatusEnum.Membro);
		filho1.setSeBatizado(StatusEnum.Batizado);
		filho1.setFamilia(conjuge);
		filhos.add(filho1);

		FilhoModel filho2 = new FilhoModel();
		filho2.setNome("Filho 2 do Ciclano");
		filho2.setDataNascProl("02/02");
		filho2.setTelefone("987654321");
		filho2.setEmail("filho2@test.com");
		filho2.setStatus(StatusEnum.NaoMembro);
		filho2.setSeBatizado(StatusEnum.NaoBatizado);
		filho2.setFamilia(conjuge);
		filhos.add(filho2);

		FilhoModel filho3 = new FilhoModel();
		filho3.setNome("Filho 3 do Ciclano");
		filho3.setDataNascProl("03/03");
		filho3.setTelefone("789665412");
		filho3.setEmail("filho3@test.com");
		filho3.setStatus(StatusEnum.Membro);
		filho3.setSeBatizado(StatusEnum.Batizado);
		filho3.setFamilia(conjuge);
		filhos.add(filho3);

		// Estabelecendo as relações entre os objetos		
		conjuge.setFilhos(filhos);
		formulario.setFamilia(conjuge);
		
		familiaService.incluirDadosNasTabelas2(formulario, conjuge, filhos);
		
		// Persistindo os objetos no banco de dados
//		entityManager.persist(formulario);
//		entityManager.persist(conjuge);
//		filhos.forEach(entityManager::persist);
	}

}
