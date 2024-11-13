package br.com.gunthercloud.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gunthercloud.dslist.entities.Game;
import br.com.gunthercloud.dslist.entities.dto.GameDTO;
import br.com.gunthercloud.dslist.entities.dto.GameMinDTO;
import br.com.gunthercloud.dslist.projections.GameMinProjection;
import br.com.gunthercloud.dslist.repositories.GameRepository;

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
	public List<GameMinDTO> findAll(){
		List<Game> list = gameRepository.findAll();
		return list.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		return list.stream().map(x -> new GameMinDTO(x)).toList();
	}

}
