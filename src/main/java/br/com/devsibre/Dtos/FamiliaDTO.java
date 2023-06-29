package br.com.devsibre.Dtos;

import java.util.List;
import java.util.Objects;

import br.com.devsibre.Model.FamiliaModel;
import br.com.devsibre.Model.FilhoModel;
import br.com.devsibre.Model.FormularioModel;

public class FamiliaDTO {
	private String nome;
    private FormularioModel formulario;
    private FamiliaModel familia;
    private List<FilhoModel> filhos;
    
    public FamiliaDTO() {
		
	}

	public FamiliaDTO(String nome, FormularioModel formulario, FamiliaModel familia, List<FilhoModel> filhos) {
		super();
		this.nome = nome;
		this.formulario = formulario;
		this.familia = familia;
		this.filhos = filhos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public FormularioModel getFormulario() {
		return formulario;
	}

	public void setFormulario(FormularioModel formulario) {
		this.formulario = formulario;
	}

	public FamiliaModel getFamilia() {
		return familia;
	}

	public void setFamilia(FamiliaModel familia) {
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
		return Objects.hash(familia, filhos, formulario, nome);
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
				&& Objects.equals(formulario, other.formulario) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "FamiliaDTO [nome=" + nome + ", formulario=" + formulario + ", familia=" + familia + ", filhos=" + filhos
				+ "]";
	}

	
}

