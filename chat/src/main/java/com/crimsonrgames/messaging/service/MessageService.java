/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimsonrgames.messaging.service;

import com.crimsonrgames.messaging.model.Message;
import java.util.List;

/**
 *
 * @author aldo
 */
public interface MessageService {
    
    Message createNewMessage (Message m);
    List<Message> getMessagesForUser(Long userId);
    List<Message> getMessagesBetweenUsers(Long userId, Long userId2);
    Message deleteMessage(Long id);
    Message markMessageAsSeen(Long id);
    
    
}
