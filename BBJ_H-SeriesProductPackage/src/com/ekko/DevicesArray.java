package com.ekko;

import java.util.ArrayList;
import java.util.Collections;

public class DevicesArray
{

    public ArrayList<Devices> getArray()
    {
        //创建集合对象
        ArrayList<Devices> array = new ArrayList<Devices>();
        array.add(new Devices(0,"Other",100,1.1,0,0));
        array.add(new Devices(1,"Air Conditioner",1200,1.2,2,6));
        array.add(new Devices(2,"TV",150,1.1,2,6));
        array.add(new Devices(3,"Fridge",100,3,12,12));
        array.add(new Devices(4,"Bulb",20,1,4,12));
        array.add(new Devices(5,"Washing Machine",450,1.2,1,1));
        array.add(new Devices(6,"Computer",250,1,9,2));
        array.add(new Devices(7,"Floor Fan",15,1,6,6));
        array.add(new Devices(8,"Big Power Fan",300,1.2,3,3));
        array.add(new Devices(9,"Ceiling Fan",60,1.1,6,6));
        array.add(new Devices(10,"Water Pump",1000,1.5,1,0));
        array.add(new Devices(11,"Booster Pump",1000,1.3,1,1));
        array.add(new Devices(12,"Hair Blow Dryer",1800,1.5,0,1));
        array.add(new Devices(13,"Hot Water Dispenser",1200,1.1,1,1));
        array.add(new Devices(14,"Water Boiler",1200,1.1,2,1));
        array.add(new Devices(15,"Iron",1000,1.5,1,0));

        return array;
    }

}
