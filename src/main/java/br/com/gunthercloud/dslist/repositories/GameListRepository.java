package br.com.gunthercloud.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gunthercloud.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
