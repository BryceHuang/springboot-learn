package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "spring_session")
public class SpringSessionBean implements Serializable {
    @Id
    @Column(name = "PRIMARY_ID")
    private Character primaryId;

    @Column(name = "SESSION_ID")
    private Character sessionId;

    @Column(name = "CREATION_TIME")
    private BigInteger creationTime;

    @Column(name = "LAST_ACCESS_TIME")
    private BigInteger lastAccessTime;

    @Column(name = "MAX_INACTIVE_INTERVAL")
    private Integer maxInactiveTime;

    @Column(name = "EXPIRY_TIME")
    private BigInteger expireTime;

    @Column(name = "PRINCIPAL_NAME")
    private String principalName;

    public Character getPrimaryId() {
        return primaryId;
    }

    public void setPrimaryId(Character primaryId) {
        this.primaryId = primaryId;
    }

    public Character getSessionId() {
        return sessionId;
    }

    public void setSessionId(Character sessionId) {
        this.sessionId = sessionId;
    }

    public BigInteger getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(BigInteger creationTime) {
        this.creationTime = creationTime;
    }

    public BigInteger getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(BigInteger lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public Integer getMaxInactiveTime() {
        return maxInactiveTime;
    }

    public void setMaxInactiveTime(Integer maxInactiveTime) {
        this.maxInactiveTime = maxInactiveTime;
    }

    public BigInteger getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(BigInteger expireTime) {
        this.expireTime = expireTime;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }
}
