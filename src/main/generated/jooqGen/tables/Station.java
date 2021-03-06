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
import jooqGen.tables.records.StationRecord;

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
public class Station extends TableImpl<StationRecord> {

    private static final long serialVersionUID = -610728753;

    /**
     * The reference instance of <code>ibikehda.station</code>
     */
    public static final Station STATION = new Station();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StationRecord> getRecordType() {
        return StationRecord.class;
    }

    /**
     * The column <code>ibikehda.station.StationID</code>.
     */
    public final TableField<StationRecord, UInteger> STATIONID = createField("StationID", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>ibikehda.station.PhoneNumber</code>.
     */
    public final TableField<StationRecord, String> PHONENUMBER = createField("PhoneNumber", org.jooq.impl.SQLDataType.VARCHAR(16), this, "");

    /**
     * The column <code>ibikehda.station.Place</code>.
     */
    public final TableField<StationRecord, String> PLACE = createField("Place", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>ibikehda.station.Street</code>.
     */
    public final TableField<StationRecord, String> STREET = createField("Street", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>ibikehda.station.HouseNumber</code>.
     */
    public final TableField<StationRecord, String> HOUSENUMBER = createField("HouseNumber", org.jooq.impl.SQLDataType.VARCHAR(16).nullable(false), this, "");

    /**
     * The column <code>ibikehda.station.Coordinates</code>.
     */
    public final TableField<StationRecord, String> COORDINATES = createField("Coordinates", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>ibikehda.station.TerminalTypeID</code>.
     */
    public final TableField<StationRecord, UInteger> TERMINALTYPEID = createField("TerminalTypeID", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * Create a <code>ibikehda.station</code> table reference
     */
    public Station() {
        this(DSL.name("station"), null);
    }

    /**
     * Create an aliased <code>ibikehda.station</code> table reference
     */
    public Station(String alias) {
        this(DSL.name(alias), STATION);
    }

    /**
     * Create an aliased <code>ibikehda.station</code> table reference
     */
    public Station(Name alias) {
        this(alias, STATION);
    }

    private Station(Name alias, Table<StationRecord> aliased) {
        this(alias, aliased, null);
    }

    private Station(Name alias, Table<StationRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Station(Table<O> child, ForeignKey<O, StationRecord> key) {
        super(child, key, STATION);
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
        return Arrays.<Index>asList(Indexes.STATION_PHONENUMBER, Indexes.STATION_PRIMARY, Indexes.STATION_STATION_TERMINALTYPE_FK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<StationRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_STATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<StationRecord> getPrimaryKey() {
        return Keys.KEY_STATION_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<StationRecord>> getKeys() {
        return Arrays.<UniqueKey<StationRecord>>asList(Keys.KEY_STATION_PRIMARY, Keys.KEY_STATION_PHONENUMBER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<StationRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<StationRecord, ?>>asList(Keys.STATION_TERMINALTYPE_FK);
    }

    public Terminaltype terminaltype() {
        return new Terminaltype(this, Keys.STATION_TERMINALTYPE_FK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Station as(String alias) {
        return new Station(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Station as(Name alias) {
        return new Station(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Station rename(String name) {
        return new Station(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Station rename(Name name) {
        return new Station(name, null);
    }
}
