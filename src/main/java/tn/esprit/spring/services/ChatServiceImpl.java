package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Chat;
import tn.esprit.spring.repository.ChatRepository;

@Service
@Slf4j
public class ChatServiceImpl implements IChatService {

	@Autowired
	ChatRepository ChatRepository;

	@Override
	public List<Chat> getAllChats() { 
		List<Chat> list=null;
		try {
			list= ChatRepository.findAll();
		} catch (Exception e) {
			log.error("++++++++++++++++++ Error : " + e );
		}
		return list;
	}

	@Override
	public Chat addChat(Chat c) {
		try {
			ChatRepository.save(c);
			
		} catch (Exception e) {
			log.error("++++++++++++++++++ Error : " + e );
		}
		return c;
	}

	@Override
	public Chat modifyChat(Long id, Chat c) {
		Chat cc = new Chat();
		try {
			cc = ChatRepository.getById(id);
			cc = c;
			ChatRepository.save(cc);
			
		} catch (Exception e) {
			log.error("++++++++++++++++++ Error : " + e );
		}
		return cc;
	}

	@Override
	public void deleteChat(Long id) {
		try {
			ChatRepository.deleteById(id);
		} catch (Exception e){
			log.error("++++++++++++++++++ Error : " + e );
		}
	}

}
