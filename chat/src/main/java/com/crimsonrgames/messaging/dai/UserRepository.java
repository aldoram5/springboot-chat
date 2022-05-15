
package com.crimsonrgames.messaging.dai;

/**
 *
 * @author aldo
 */

import com.crimsonrgames.messaging.model.User;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{
    
}
