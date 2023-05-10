package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import com.devsuperior.dto.GameDTO;
import com.devsuperior.dto.GameMinDTO;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		return new GameDTO(result);
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		var result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}
