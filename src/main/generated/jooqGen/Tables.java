/*
 * This file is generated by jOOQ.
 */
package jooqGen;


import javax.annotation.Generated;

import jooqGen.tables.Bike;
import jooqGen.tables.Bikestatus;
import jooqGen.tables.Plugtype;
import jooqGen.tables.Station;
import jooqGen.tables.StationPlugtype;
import jooqGen.tables.Terminaltype;
import jooqGen.tables.User;


/**
 * Convenience access to all tables in ibikehda
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>ibikehda.bike</code>.
     */
    public static final Bike BIKE = jooqGen.tables.Bike.BIKE;

    /**
     * The table <code>ibikehda.bikestatus</code>.
     */
    public static final Bikestatus BIKESTATUS = jooqGen.tables.Bikestatus.BIKESTATUS;

    /**
     * The table <code>ibikehda.plugtype</code>.
     */
    public static final Plugtype PLUGTYPE = jooqGen.tables.Plugtype.PLUGTYPE;

    /**
     * The table <code>ibikehda.station</code>.
     */
    public static final Station STATION = jooqGen.tables.Station.STATION;

    /**
     * The table <code>ibikehda.station_plugtype</code>.
     */
    public static final StationPlugtype STATION_PLUGTYPE = jooqGen.tables.StationPlugtype.STATION_PLUGTYPE;

    /**
     * The table <code>ibikehda.terminaltype</code>.
     */
    public static final Terminaltype TERMINALTYPE = jooqGen.tables.Terminaltype.TERMINALTYPE;

    /**
     * The table <code>ibikehda.user</code>.
     */
    public static final User USER = jooqGen.tables.User.USER;
}
