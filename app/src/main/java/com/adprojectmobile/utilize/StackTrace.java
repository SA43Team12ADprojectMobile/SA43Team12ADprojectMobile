package com.adprojectmobile.utilize;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by EvEr on 2017/1/26.
 */

public class StackTrace {
    public static String trace(Exception ex) {
        StringWriter outStream = new StringWriter();
        ex.printStackTrace(new PrintWriter(outStream));
        return outStream.toString();
    }
}
