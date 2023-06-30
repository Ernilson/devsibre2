package br.com.devsibre.Dtos;

import java.util.List;
import java.util.Objects;

import br.com.devsibre.Model.ConjugeModel;
import br.com.devsibre.Model.FilhoModel;
import br.com.devsibre.Model.FormularioModel;

public class FamiliaDTO {	
    private FormularioModel formulario;
    private ConjugeModel familia;
    private List<FilhoModel> filhos;
    
    public FamiliaDTO() {
		
	}

	public FamiliaDTO(FormularioModel formulario, ConjugeModel familia, List<FilhoModel> filhos) {
		super();
		this.formulario = formulario;
		this.familia = familia;
		this.filhos = filhos;
	}

	public FormularioModel getFormulario() {
		return formulario;
	}

	public void setFormulario(FormularioModel formulario) {
		this.formulario = formulario;
	}

	public ConjugeModel getFamilia() {
		return familia;
	}

	public void setFamilia(ConjugeModel familia) {
		this.familia = familia;
	}

	public List<FilhoModel> getFilhos() {
		return filhos;
	}

	public void setFilhos(List<FilhoModel> filhos) {
		this.filhos = filhos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(familia, filhos, formulario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FamiliaDTO other = (FamiliaDTO) obj;
		return Objects.equals(familia, other.familia) && Objects.equals(filhos, other.filhos)
				&& Objects.equals(formulario, other.formulario);
	}

	@Override
	public String toString() {
		return "FamiliaDTO [formulario=" + formulario + ", familia=" + familia + ", filhos=" + filhos + "]";
	}

	
	
}

