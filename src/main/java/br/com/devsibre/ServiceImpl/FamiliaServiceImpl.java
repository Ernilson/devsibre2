package br.com.devsibre.ServiceImpl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.devsibre.Dtos.FamiliaDTO;
import br.com.devsibre.Model.ConjugeModel;
import br.com.devsibre.Model.FilhoModel;
import br.com.devsibre.Model.FormularioModel;
import br.com.devsibre.Repository.ConjugeRepository;
import br.com.devsibre.Repository.FilhoRepository;
import br.com.devsibre.Repository.FormularioRepository;

@Service
@Transactional
public class FamiliaServiceImpl {

	private FormularioRepository fservice;
	private ConjugeRepository cservice;
	private FilhoRepository flservice;
	private final EntityManager entityManager;

	@Autowired
	public FamiliaServiceImpl(EntityManager entityManager, FormularioRepository fservice, ConjugeRepository cservice,
			FilhoRepository flservice) {
		this.fservice = fservice;
		this.cservice = cservice;
		this.flservice = flservice;
		this.entityManager = entityManager;
	}

	// Metodo para busca o Membro e sua familia por nome
	public List<FamiliaDTO> buscarPorNome(String nome) {
		String jpql = "SELECT f, fam, filho " + "FROM FormularioModel f " + "JOIN f.familia fam "
				+ "JOIN fam.filhos filho " + "WHERE f.nome = :nome";

		TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
		query.setParameter("nome", nome);

		List<Object[]> results = query.getResultList();
		List<FamiliaDTO> familiaDTOs = new ArrayList<>();

		for (Object[] result : results) {
			FormularioModel formulario = (FormularioModel) result[0];
			ConjugeModel familia = (ConjugeModel) result[1];
			FilhoModel filho = (FilhoModel) result[2];

			FamiliaDTO familiaDTO = new FamiliaDTO();
			familiaDTO.setFormulario(formulario);
			familiaDTO.setFamilia(familia);
			familiaDTO.setFilhos(Collections.singletonList(filho));

			familiaDTOs.add(familiaDTO);
		}

		return familiaDTOs;
	}

	// Metodo para listar todas as familasa
	public List<FamiliaDTO> listarTodasFamilias() {
		String jpql = "SELECT f, fam, filho " + "FROM FormularioModel f " + "JOIN f.familia fam "
				+ "JOIN fam.filhos filho";

		TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
		List<Object[]> results = query.getResultList();
		List<FamiliaDTO> familiaDTOs = new ArrayList<>();

		for (Object[] result : results) {
			FormularioModel formulario = (FormularioModel) result[0];
			ConjugeModel familia = (ConjugeModel) result[1];
			FilhoModel filho = (FilhoModel) result[2];

			FamiliaDTO familiaDTO = new FamiliaDTO();
			familiaDTO.setFormulario(formulario);
			familiaDTO.setFamilia(familia);
			familiaDTO.setFilhos(Collections.singletonList(filho));

			familiaDTOs.add(familiaDTO);
		}

		return familiaDTOs;
	}

	public void incluirDadosNasTabelas2(FormularioModel fm, ConjugeModel cm, List<FilhoModel> filhos) {

		try {

			FormularioModel f = new FormularioModel();
			f.setNome(fm.getNome());
			f.setEmail(fm.getEmail());
			f.setData(fm.getData());
			f.setFone(fm.getFone());
			f.setStatus(fm.getStatus());
			f.setCep(fm.getCep());
			f.setBairro(fm.getBairro());
			f.setLocalidade(fm.getLocalidade());
			f.setLogradouro(fm.getLogradouro());
			f.setUf(fm.getUf());
			f.setFamilia(fm.getFamilia());
			// -->

			ConjugeModel conjuge = new ConjugeModel();
			conjuge.setNomeDoConjuge(cm.getNomeDoConjuge());
			conjuge.setdataNascEsp(cm.getdataNascEsp());
			conjuge.setQuantidadeFilhos(cm.getQuantidadeFilhos());
			conjuge.setTelefone(cm.getTelefone());
			conjuge.setSeBatizado(cm.getSeBatizado());
			conjuge.setStatus(cm.getStatus());
			// conjuge.setFilhos(cm.getFilhos());

			for (FilhoModel fl : filhos) {
			    FilhoModel filho = new FilhoModel();
			    filho.setNome(fl.getNome());
			    filho.setEmail(fl.getEmail());
			    filho.setDataNascProl(fl.getDataNascProl());
			    filho.setTelefone(fl.getTelefone());
			    filho.setFamilia(cm);
			    filho.setStatus(fl.getStatus());
			    filho.setSeBatizado(fl.getSeBatizado());
			    
			    // Estabelecer a relação entre o filho e a família
			    fl.setFamilia(cm);
			    
			    // Persistir o filho no banco de dados
			    flservice.save(filho);
			}

			// Persistir a família e o cônjuge no banco de dados
			fservice.save(f);
			cservice.save(conjuge);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}