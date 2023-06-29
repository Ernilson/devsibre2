package br.com.devsibre;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.devsibre.Dtos.FamiliaDTO;
import br.com.devsibre.Enuns.StatusEnum;
import br.com.devsibre.Model.FamiliaModel;
import br.com.devsibre.Model.FilhoModel;
import br.com.devsibre.Model.FormularioModel;
import br.com.devsibre.ServiceImpl.FamiliaServiceImpl;
import br.com.devsibre.ServiceImpl.FormularioServiceImpl;

@SpringBootTest
class DevsibreApplicationTests {

    @Autowired
    private FormularioServiceImpl formularioService;

    @Autowired
    private FamiliaServiceImpl familiaService;

    @Test
    void contextLoads() {
        FormularioModel formulario = criarFormulario();
        formularioService.saveOrUpdate(formulario);

//        List<FamiliaDTO> listaDTO = familiaService.buscarPorNome("Fulano");
//        for (FamiliaDTO f : listaDTO) {
//            System.out.println(f.getFormulario().getNome() +" "+ f.getFamilia().getNomeDoConjuge() + " Data de Nasc ->"+ f.getFamilia().getdataNascEsp() +" Email " + f.getFamilia().getEmail()
	//	+"filhos" + f.getFilhos());
//        }
    }

    private FormularioModel criarFormulario() {
        FormularioModel formulario = new FormularioModel();
        formulario.setNome("Ciclano");
        formulario.setFone("1234567");
        formulario.setEmail("teste@teste.com");
        formulario.setData("01/02/03");
        formulario.setUf("DF");
        formulario.setCep("72601108");
        formulario.setBairro("Recanto das Emas");
        formulario.setLocalidade("Brasilia");
        formulario.setLogradouro("Quadra 101");
        formulario.setStatus("Membro");

        FamiliaModel familia = criarFamilia();
        formulario.setFamilia(familia);

        return formulario;
    }

    private FamiliaModel criarFamilia() {
        FamiliaModel familia = new FamiliaModel();
        familia.setNomeDoConjuge("Esposa do Ciclano");
        familia.setTelefone("1234567");
        familia.setEmail("esposa@test.com");
        familia.setdataNascEsp("02/03");
        familia.setQuantidadeFilhos(3);
        familia.setStatus(StatusEnum.Membro);
        familia.setSeBatizado(StatusEnum.Batizado);

        List<FilhoModel> filhos = new ArrayList<>();

        FilhoModel filho1 = criarFilho("1 Filho do Ciclano ", " 01/01", " 123456789", " filho1@test.com ", StatusEnum.Membro, StatusEnum.Batizado, familia);
        filhos.add(filho1);

//        FilhoModel filho2 = criarFilho("2 Filho do Fulano ", " 02/02", " 987654321", " filho2@test.com ", StatusEnum.NaoMembro, StatusEnum.NaoBatizado, familia);
//        filhos.add(filho2);

//        FilhoModel filho3 = criarFilho("3 Filho do Beltrano ", " 03/03", " 456123789", " filho3@test.com ", StatusEnum.Membro, StatusEnum.Batizado, familia);
//        filhos.add(filho3);

        familia.setFilhos(filhos);

        return familia;
    }

    private FilhoModel criarFilho(String nome, String dataNascProl, String telefone, String email, StatusEnum seBatizado, StatusEnum status, FamiliaModel familia) {
        FilhoModel filho = new FilhoModel();
        filho.setNome(nome);
        filho.setDataNascProl(dataNascProl);
        filho.setTelefone(telefone);
        filho.setEmail(email);
        filho.setStatus(status);
        filho.setSeBatizado(seBatizado);
        filho.setFamilia(familia);
     
        return filho;
    }

    
}
