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
import jooqGen.tables.records.BikeRecord;

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
public class Bike extends TableImpl<BikeRecord> {

    private static final long serialVersionUID = 1317883379;

    /**
     * The reference instance of <code>ibikehda.bike</code>
     */
    public static final Bike BIKE = new Bike();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BikeRecord> getRecordType() {
        return BikeRecord.class;
    }

    /**
     * The column <code>ibikehda.bike.BikeID</code>.
     */
    public final TableField<BikeRecord, UInteger> BIKEID = createField("BikeID", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>ibikehda.bike.BikeNumber</code>.
     */
    public final TableField<BikeRecord, UInteger> BIKENUMBER = createField("BikeNumber", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>ibikehda.bike.Designation</code>.
     */
    public final TableField<BikeRecord, String> DESIGNATION = createField("Designation", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>ibikehda.bike.GearCount</code>.
     */
    public final TableField<BikeRecord, UInteger> GEARCOUNT = createField("GearCount", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>ibikehda.bike.DriveTechnology</code>.
     */
    public final TableField<BikeRecord, String> DRIVETECHNOLOGY = createField("DriveTechnology", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>ibikehda.bike.BatteryLifePercent</code>.
     */
    public final TableField<BikeRecord, UInteger> BATTERYLIFEPERCENT = createField("BatteryLifePercent", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>ibikehda.bike.BikeStatusID</code>.
     */
    public final TableField<BikeRecord, UInteger> BIKESTATUSID = createField("BikeStatusID", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>ibikehda.bike.UserID</code>.
     */
    public final TableField<BikeRecord, UInteger> USERID = createField("UserID", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>ibikehda.bike.MainStationID</code>.
     */
    public final TableField<BikeRecord, UInteger> MAINSTATIONID = createField("MainStationID", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>ibikehda.bike.CurrentStationID</code>.
     */
    public final TableField<BikeRecord, UInteger> CURRENTSTATIONID = createField("CurrentStationID", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * Create a <code>ibikehda.bike</code> table reference
     */
    public Bike() {
        this(DSL.name("bike"), null);
    }

    /**
     * Create an aliased <code>ibikehda.bike</code> table reference
     */
    public Bike(String alias) {
        this(DSL.name(alias), BIKE);
    }

    /**
     * Create an aliased <code>ibikehda.bike</code> table reference
     */
    public Bike(Name alias) {
        this(alias, BIKE);
    }

    private Bike(Name alias, Table<BikeRecord> aliased) {
        this(alias, aliased, null);
    }

    private Bike(Name alias, Table<BikeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Bike(Table<O> child, ForeignKey<O, BikeRecord> key) {
        super(child, key, BIKE);
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
        return Arrays.<Index>asList(Indexes.BIKE_BIKE_BB_FK, Indexes.BIKE_BIKE_BU_FK, Indexes.BIKE_BIKE_CS_FK, Indexes.BIKE_BIKE_MS_FK, Indexes.BIKE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<BikeRecord> getPrimaryKey() {
        return Keys.KEY_BIKE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<BikeRecord>> getKeys() {
        return Arrays.<UniqueKey<BikeRecord>>asList(Keys.KEY_BIKE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<BikeRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<BikeRecord, ?>>asList(Keys.BIKE_BB_FK, Keys.BIKE_BU_FK, Keys.BIKE_MS_FK, Keys.BIKE_CS_FK);
    }

    public Bikestatus bikestatus() {
        return new Bikestatus(this, Keys.BIKE_BB_FK);
    }

    public User user() {
        return new User(this, Keys.BIKE_BU_FK);
    }

    public Station bikeMsFk() {
        return new Station(this, Keys.BIKE_MS_FK);
    }

    public Station bikeCsFk() {
        return new Station(this, Keys.BIKE_CS_FK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Bike as(String alias) {
        return new Bike(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Bike as(Name alias) {
        return new Bike(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Bike rename(String name) {
        return new Bike(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Bike rename(Name name) {
        return new Bike(name, null);
    }
}
