package br.com.gunthercloud.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gunthercloud.dslist.entities.GameList;
import br.com.gunthercloud.dslist.entities.dto.GameListDTO;
import br.com.gunthercloud.dslist.entities.dto.GameMinDTO;
import br.com.gunthercloud.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> list = gameListRepository.findAll();
		return list.stream().map(x -> new GameListDTO(x)).toList();
	}

}
