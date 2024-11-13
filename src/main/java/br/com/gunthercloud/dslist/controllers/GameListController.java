package br.com.gunthercloud.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gunthercloud.dslist.entities.dto.GameListDTO;
import br.com.gunthercloud.dslist.entities.dto.GameMinDTO;
import br.com.gunthercloud.dslist.services.GameListService;
import br.com.gunthercloud.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	@Autowired
	private GameListService gameListService;
	@Autowired
	private GameService gameService;

	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> list = gameListService.findAll();
		return list;
	}
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId){
		List<GameMinDTO> list = gameService.findByList(listId);
		return list;
	}

}
