package br.com.devsibre.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.devsibre.Model.ConjugeModel;
import br.com.devsibre.Model.FormularioModel;

@Repository
@Transactional
public interface ConjugeRepository extends CrudRepository<ConjugeModel, Long> {



}
