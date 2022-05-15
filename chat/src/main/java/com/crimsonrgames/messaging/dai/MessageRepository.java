
package com.crimsonrgames.messaging.dai;

/**
 *
 * @author aldo
 */


import com.crimsonrgames.messaging.model.Message;
import com.crimsonrgames.messaging.model.User;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository  extends CrudRepository<Message, Long>  {
    
    List<Message> getAllMessagesBySender(User sender);
    List<Message> getAllMessagesBySenderAndRecipent(User recipent, User sender);
    
}
