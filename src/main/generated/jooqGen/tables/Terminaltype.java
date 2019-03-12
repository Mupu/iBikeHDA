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
import jooqGen.tables.records.TerminaltypeRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
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
public class Terminaltype extends TableImpl<TerminaltypeRecord> {

    private static final long serialVersionUID = -1833099349;

    /**
     * The reference instance of <code>ibikehda.terminaltype</code>
     */
    public static final Terminaltype TERMINALTYPE = new Terminaltype();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TerminaltypeRecord> getRecordType() {
        return TerminaltypeRecord.class;
    }

    /**
     * The column <code>ibikehda.terminaltype.TerminalTypeID</code>.
     */
    public final TableField<TerminaltypeRecord, UInteger> TERMINALTYPEID = createField("TerminalTypeID", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>ibikehda.terminaltype.Type</code>.
     */
    public final TableField<TerminaltypeRecord, String> TYPE = createField("Type", org.jooq.impl.SQLDataType.VARCHAR(16).nullable(false), this, "");

    /**
     * Create a <code>ibikehda.terminaltype</code> table reference
     */
    public Terminaltype() {
        this(DSL.name("terminaltype"), null);
    }

    /**
     * Create an aliased <code>ibikehda.terminaltype</code> table reference
     */
    public Terminaltype(String alias) {
        this(DSL.name(alias), TERMINALTYPE);
    }

    /**
     * Create an aliased <code>ibikehda.terminaltype</code> table reference
     */
    public Terminaltype(Name alias) {
        this(alias, TERMINALTYPE);
    }

    private Terminaltype(Name alias, Table<TerminaltypeRecord> aliased) {
        this(alias, aliased, null);
    }

    private Terminaltype(Name alias, Table<TerminaltypeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Terminaltype(Table<O> child, ForeignKey<O, TerminaltypeRecord> key) {
        super(child, key, TERMINALTYPE);
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
        return Arrays.<Index>asList(Indexes.TERMINALTYPE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<TerminaltypeRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_TERMINALTYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TerminaltypeRecord> getPrimaryKey() {
        return Keys.KEY_TERMINALTYPE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TerminaltypeRecord>> getKeys() {
        return Arrays.<UniqueKey<TerminaltypeRecord>>asList(Keys.KEY_TERMINALTYPE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Terminaltype as(String alias) {
        return new Terminaltype(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Terminaltype as(Name alias) {
        return new Terminaltype(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Terminaltype rename(String name) {
        return new Terminaltype(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Terminaltype rename(Name name) {
        return new Terminaltype(name, null);
    }
}