package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Component
public class GameService {
	
	@Autowired
	private GameRepository gameRepository; // Registrando e Interagir com o GameRepository
	
	
	public List<GameMinDTO> findAll(){
		
		List<Game> result = gameRepository.findAll();
		
		// Converting List<Game> in List<GameMinDTO>:
		
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();		
		
		return dto;
	}
	

}

// Tornando o meu Game Service um componente -> 1:40:00