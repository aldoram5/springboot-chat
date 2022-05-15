
package com.crimsonrgames.messaging.controller;

import com.crimsonrgames.messaging.model.Message;
import com.crimsonrgames.messaging.service.MessageService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aldo
 */

@RestController
public class MessageController {
    
    MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }
    
    @PostMapping("messages")
    public ResponseEntity<Message> addMessage(@RequestBody Message message) {
        Message savedMessage = messageService.createNewMessage(message);
        return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
    }
    
    @DeleteMapping("messages/{id}")
    public ResponseEntity<Message> deleteMessage(@PathVariable Long id) {
        Message deletedMessage = messageService.deleteMessage(id);
        return new ResponseEntity<>(deletedMessage, HttpStatus.OK);
    }
    
    @PutMapping("messages/seen/{id}")
    public ResponseEntity<Message> markMessageAsSeen(@PathVariable Long id) {
        Message markMessageAsSeen = messageService.markMessageAsSeen(id);
        return new ResponseEntity<>(markMessageAsSeen, HttpStatus.OK);
    }
    
    @GetMapping("messages/user/{id}")
    public ResponseEntity<List<Message>> getMessagesForUser(@PathVariable Long id){
        
        List<Message> messagesForUser = messageService.getMessagesForUser(id);
        if (messagesForUser != null)
            return new ResponseEntity<List<Message>>(messagesForUser,HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("messages/chat/{id}/{id2}")
    public ResponseEntity<List<Message>> getMessagesBetweenUsers(@PathVariable Long id,@PathVariable Long id2){
        
        List<Message> messagesBetweenUsers = messageService.getMessagesBetweenUsers(id,id2);
        if (messagesBetweenUsers != null)
            return new ResponseEntity<List<Message>>(messagesBetweenUsers,HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    
}
