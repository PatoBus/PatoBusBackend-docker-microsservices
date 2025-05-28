// OnibusService.java
package com.patobus.service;

//import com.patobus.dto.LinhaDTO;
import com.patobus.dto.OnibusHorarioDTO;
//import com.patobus.model.Horario;
import com.patobus.model.Linha;
import com.patobus.model.LinhaHorario;
import com.patobus.model.Onibus;
import com.patobus.repository.LinhaHorarioRepository;
import com.patobus.repository.OnibusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OnibusService {

    @Autowired
    private OnibusRepository onibusRepository;

    @Autowired
    private LinhaHorarioRepository linhaHorarioRepository;

    public List<Onibus> findAll() {
        return onibusRepository.findAll();
    }

    public Optional<Onibus> findById(Long id) {
        return onibusRepository.findById(id);
    }

    public Onibus save(Onibus onibus) {
        return onibusRepository.save(onibus);
    }

    public void deleteById(Long id) {
        onibusRepository.deleteById(id);
    }
 public List<OnibusHorarioDTO> findAllOnibusHorarios() {
    List<Onibus> todosOnibus = onibusRepository.findAll();
    
    return todosOnibus.stream()
            .map(onibus -> {
                OnibusHorarioDTO dto = new OnibusHorarioDTO();
                dto.setIdOnibus(onibus.getIdOnibus());
                dto.setPlaca(onibus.getPlaca());
                dto.setGpsAtual(onibus.getGpsAtual());
                
                Linha linha = onibus.getLinha();
                if (linha != null) {
                    // Usando o método correto do repository
                    List<LinhaHorario> linhaHorarios = linhaHorarioRepository.findByLinha_IdLinha(linha.getIdLinha());
                    List<LocalTime> horarios = linhaHorarios.stream()
                            .map(lh -> lh.getHorario().getHora())
                            .collect(Collectors.toList());
                    dto.setHorarios(horarios);
                } else {
                    dto.setHorarios(List.of());
                }
                
                return dto;
            })
            .collect(Collectors.toList());
}

    public OnibusHorarioDTO buscarOnibusComHorarios(Long onibusId) {
    // Busca o ônibus pelo ID ou lança exceção se não encontrado
    Onibus onibus = onibusRepository.findById(onibusId)
            .orElseThrow(() -> new RuntimeException("Ônibus não encontrado com ID: " + onibusId));

    // Cria o DTO de resposta
    OnibusHorarioDTO dto = new OnibusHorarioDTO();
    dto.setIdOnibus(onibus.getIdOnibus());
    dto.setPlaca(onibus.getPlaca());
    dto.setGpsAtual(onibus.getGpsAtual());
    
    // Verifica se o ônibus tem linha associada
    if (onibus.getLinha() != null) {
        // Busca os horários da linha associada
        List<LinhaHorario> horarios = linhaHorarioRepository.findByLinha_IdLinha(onibus.getLinha().getIdLinha());
        
        // Mapeia para LocalTime e adiciona ao DTO
        List<LocalTime> horariosFormatados = horarios.stream()
                .map(lh -> lh.getHorario().getHora())
                .collect(Collectors.toList());
        
        dto.setHorarios(horariosFormatados);
    } else {
        // Se não houver linha associada, retorna lista vazia de horários
        dto.setHorarios(Collections.emptyList());
    }
    
    return dto;
}

}