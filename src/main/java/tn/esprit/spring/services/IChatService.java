package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Chat;


public interface IChatService {

	List<Chat> getAllChats();
	Chat addChat(Chat c);
	Chat modifyChat(Long id, Chat c);
	void deleteChat(Long id);

}
