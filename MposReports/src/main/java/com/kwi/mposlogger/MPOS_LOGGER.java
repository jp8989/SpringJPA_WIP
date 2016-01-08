package com.kwi.mposlogger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class MPOS_LOGGER {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String logRecord;

    public MPOS_LOGGER() {
    }

    public MPOS_LOGGER(final String logRecord) {
        this.logRecord = logRecord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogRecord() {
        return logRecord;
    }

    public void setLogRecord(String logRecord) {
        this.logRecord = logRecord;
    }

    @Override
    public String toString() {
        return id + " " + logRecord;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(logRecord).toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof MPOS_LOGGER) {
            final MPOS_LOGGER other = (MPOS_LOGGER) obj;
            return new EqualsBuilder().append(logRecord, other.logRecord).append(id, other.id).isEquals();
        }
        return false;
    }

}