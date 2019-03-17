/*
 * This file is generated by jOOQ.
 */
package jooqGen.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import jooqGen.Ibikehda;
import jooqGen.Indexes;
import jooqGen.Keys;
import jooqGen.tables.records.BikestatusRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
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
public class Bikestatus extends TableImpl<BikestatusRecord> {

    private static final long serialVersionUID = 1887571480;

    /**
     * The reference instance of <code>ibikehda.bikestatus</code>
     */
    public static final Bikestatus BIKESTATUS = new Bikestatus();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BikestatusRecord> getRecordType() {
        return BikestatusRecord.class;
    }

    /**
     * The column <code>ibikehda.bikestatus.BikeStatusID</code>.
     */
    public final TableField<BikestatusRecord, UInteger> BIKESTATUSID = createField("BikeStatusID", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>ibikehda.bikestatus.Status</code>.
     */
    public final TableField<BikestatusRecord, String> STATUS = createField("Status", org.jooq.impl.SQLDataType.VARCHAR(16).nullable(false), this, "");

    /**
     * Create a <code>ibikehda.bikestatus</code> table reference
     */
    public Bikestatus() {
        this(DSL.name("bikestatus"), null);
    }

    /**
     * Create an aliased <code>ibikehda.bikestatus</code> table reference
     */
    public Bikestatus(String alias) {
        this(DSL.name(alias), BIKESTATUS);
    }

    /**
     * Create an aliased <code>ibikehda.bikestatus</code> table reference
     */
    public Bikestatus(Name alias) {
        this(alias, BIKESTATUS);
    }

    private Bikestatus(Name alias, Table<BikestatusRecord> aliased) {
        this(alias, aliased, null);
    }

    private Bikestatus(Name alias, Table<BikestatusRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Bikestatus(Table<O> child, ForeignKey<O, BikestatusRecord> key) {
        super(child, key, BIKESTATUS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Ibikehda.IBIKEHDA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.BIKESTATUS_PRIMARY, Indexes.BIKESTATUS_STATUS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<BikestatusRecord> getPrimaryKey() {
        return Keys.KEY_BIKESTATUS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<BikestatusRecord>> getKeys() {
        return Arrays.<UniqueKey<BikestatusRecord>>asList(Keys.KEY_BIKESTATUS_PRIMARY, Keys.KEY_BIKESTATUS_STATUS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Bikestatus as(String alias) {
        return new Bikestatus(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Bikestatus as(Name alias) {
        return new Bikestatus(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Bikestatus rename(String name) {
        return new Bikestatus(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Bikestatus rename(Name name) {
        return new Bikestatus(name, null);
    }
}
