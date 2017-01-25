package com.adprojectmobile.testdata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EvEr on 2017/1/17.
 */

public class testDummyData {
    public static List<testCollectionPoint> collectionPoints;

    static {
        collectionPoints=new ArrayList<testCollectionPoint>();
        collectionPoints.add(new testCollectionPoint(1,"Collection Point A","01/01/2017 9AM"));
        collectionPoints.add(new testCollectionPoint(2,"Collection Point B","02/01/2017 9AM"));
        collectionPoints.add(new testCollectionPoint(3,"Collection Point C","02/01/2017 11AM"));
        collectionPoints.add(new testCollectionPoint(4,"Collection Point D","03/01/2017 9AM"));
        collectionPoints.add(new testCollectionPoint(5,"Collection Point E","03/01/2017 11AM"));
    }

}
