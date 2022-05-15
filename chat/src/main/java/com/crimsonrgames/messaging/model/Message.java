package com.crimsonrgames.messaging.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author aldo
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private User sender;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private User recipent;
    
    private String content;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date sentTimestamp;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date seenTimestamp;
    
    private MessageStatus status;

}
