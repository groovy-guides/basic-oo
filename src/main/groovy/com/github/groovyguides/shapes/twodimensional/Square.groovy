package com.github.groovyguides.shapes.twodimensional

import com.github.groovyguides.shapes.measurement.LengthMeasurement

class Square extends Rectangle {

    /**
     * Not useful
     */
    Square() {}
    
    public Square(LengthMeasurement length) {
        super(length, length)
    }
}