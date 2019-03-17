/*
 * This file is generated by jOOQ.
 */
package jooqGen.tables.records;


import javax.annotation.Generated;

import jooqGen.tables.Bikestatus;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UInteger;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BikestatusRecord extends UpdatableRecordImpl<BikestatusRecord> implements Record2<UInteger, String> {

    private static final long serialVersionUID = 201978183;

    /**
     * Setter for <code>ibikehda.bikestatus.BikeStatusID</code>.
     */
    public void setBikestatusid(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>ibikehda.bikestatus.BikeStatusID</code>.
     */
    public UInteger getBikestatusid() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>ibikehda.bikestatus.Status</code>.
     */
    public void setStatus(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>ibikehda.bikestatus.Status</code>.
     */
    public String getStatus() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<UInteger> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<UInteger, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<UInteger, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return Bikestatus.BIKESTATUS.BIKESTATUSID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Bikestatus.BIKESTATUS.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component1() {
        return getBikestatusid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value1() {
        return getBikestatusid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BikestatusRecord value1(UInteger value) {
        setBikestatusid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BikestatusRecord value2(String value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BikestatusRecord values(UInteger value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BikestatusRecord
     */
    public BikestatusRecord() {
        super(Bikestatus.BIKESTATUS);
    }

    /**
     * Create a detached, initialised BikestatusRecord
     */
    public BikestatusRecord(UInteger bikestatusid, String status) {
        super(Bikestatus.BIKESTATUS);

        set(0, bikestatusid);
        set(1, status);
    }
}
