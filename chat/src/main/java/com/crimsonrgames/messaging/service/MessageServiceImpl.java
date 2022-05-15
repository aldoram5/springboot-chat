
package com.crimsonrgames.messaging.service;

import com.crimsonrgames.messaging.dai.MessageRepository;
import com.crimsonrgames.messaging.dai.UserRepository;
import com.crimsonrgames.messaging.model.Message;
import com.crimsonrgames.messaging.model.MessageStatus;
import com.crimsonrgames.messaging.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aldo
 */
@Service
public class MessageServiceImpl implements MessageService{
    
    private MessageRepository messageRepository;
    
    private UserRepository userRepository;
    
    @Autowired
    public void setMessageRepository(MessageRepository messageRepository){

        this.messageRepository =messageRepository;
    }
    
    @Autowired
    public void setUserRepository(UserRepository userRepository){

        this.userRepository =userRepository;
    }
    
    @Override
    public Message createNewMessage(Message m) {
        return messageRepository.save(m);
        
    }

    @Override
    public Message deleteMessage(Long id) {
        Optional<Message> message;
        message = messageRepository.findById(id);
        if (message.isPresent()){
            Message t = message.get();
            t.setStatus(MessageStatus.DELETED);
            return messageRepository.save(t);
        }
        return null;
    }

    @Override
    public Message markMessageAsSeen(Long id) {
        Optional<Message> message;
        message = messageRepository.findById(id);
        if (message.isPresent()){
            Message t = message.get();
            t.setStatus(MessageStatus.SEEN);
            return messageRepository.save(t);
        }
        return null;
    }

    @Override
    public List<Message> getMessagesForUser(Long userId) {
        Optional<User> user;
        user = userRepository.findById(userId);
        if(user.isPresent()){
            List<Message> received = messageRepository.getAllMessagesBySender(user.get());
            return received;
        }
        
        return null;
        
        
    }

    @Override
    public List<Message> getMessagesBetweenUsers(Long userId, Long userId2) {
        Optional<User> user, user2;
        user = userRepository.findById(userId);
        user2 = userRepository.findById(userId2);
        if(user.isPresent() && user2.isPresent()){
        
            List<Message> received = messageRepository.getAllMessagesBySenderAndRecipent(user.get(), user2.get());
            List<Message> sent = messageRepository.getAllMessagesBySenderAndRecipent(user2.get(), user.get());
            received.addAll(sent);
            return received;
        
        }
        return null;
    }
    
}
