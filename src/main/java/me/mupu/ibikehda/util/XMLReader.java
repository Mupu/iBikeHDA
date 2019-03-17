package me.mupu.ibikehda.util;

import me.mupu.ibikehda.persistence.dao.Bike;

import java.io.File;
import java.util.ArrayList;

public class XMLReader {

    public XMLReader(File xmlfile) {
        ArrayList<Bike> bikes = new ArrayList<>();
        readData(bikes);
    }

    private void readData(ArrayList<Bike> bikes) {

    }

}
