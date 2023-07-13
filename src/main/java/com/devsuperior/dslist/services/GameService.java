package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

@Component
public class GameService {
	
	@Autowired
	private GameRepository gameRepository; // Registrando e Interagir com o GameRepository
	
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
		
	
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		
		List<Game> result = gameRepository.findAll();
		
		// Converting List<Game> in List<GameMinDTO>:
		
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();		
		
		return dto;
	}
	
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		
		// Converting List<Game> in List<GameMinDTO>:
		
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();		
		
		return dto;
	}
	

}

// Tornando o meu Game Service um componente -> 1:40:00