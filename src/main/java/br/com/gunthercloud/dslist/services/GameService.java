package br.com.gunthercloud.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gunthercloud.dslist.entities.Game;
import br.com.gunthercloud.dslist.entities.dto.GameMinDTO;
import br.com.gunthercloud.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){
		List<Game> list = gameRepository.findAll();
		return list.stream().map(x -> new GameMinDTO(x)).toList();
	}

}
