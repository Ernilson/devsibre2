package br.com.devsibre;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.devsibre.Controller.FamiliaController;
import br.com.devsibre.Dtos.FamiliaDTO;
import br.com.devsibre.Model.ConjugeModel;
import br.com.devsibre.Model.FilhoModel;
import br.com.devsibre.Model.FormularioModel;
import br.com.devsibre.ServiceImpl.FamiliaServiceImpl;

class FamiliaControllerTest {

    private FamiliaController familiaController;

    @Mock
    private FamiliaServiceImpl familiaService;

    @BeforeEach
    void setUp() {
       // MockitoAnnotations.openMocks(this);
        familiaController = new FamiliaController(familiaService);
    }

    @Test
    void buscarPorNome() {
        // Arrange
        String nome = "John Doe";
        List<FamiliaDTO> familias = new ArrayList<>();
        FamiliaDTO familia1 = new FamiliaDTO();
        FamiliaDTO familia2 = new FamiliaDTO();
        familias.add(familia1);
        familias.add(familia2);

        when(familiaService.buscarPorNome(nome)).thenReturn(familias);

        // Act
        List<FamiliaDTO> resultado = familiaController.buscarPorNome(nome);

        // Assert
        assertEquals(familias, resultado);
        verify(familiaService, times(1)).buscarPorNome(nome);
    }

    @Test
    void incluirDadosNoFormulario() {
        // Arrange
        FormularioModel formulario = new FormularioModel();
        ConjugeModel conjuge = new ConjugeModel();
        List<FilhoModel> filhos = new ArrayList<>();

     //   when(familiaService.incluirDadosNasTabelas2(formulario, conjuge, filhos)).thenReturn(true);

        // Act
        ResponseEntity<String> resultado = familiaController.incluirDadosNoFormulario(formulario, conjuge, filhos);

        // Assert
        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals("Dados incluídos com sucesso!", resultado.getBody());
        verify(familiaService, times(1)).incluirDadosNasTabelas2(formulario, conjuge, filhos);
    }
}

