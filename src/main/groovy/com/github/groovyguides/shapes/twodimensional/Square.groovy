package com.github.groovyguides.shapes.twodimensional

import com.github.groovyguides.shapes.measurement.Measurement
import groovy.transform.ToString

class Square extends Rectangle {
    
    private Square() {}
    
    public Square(Measurement length) {
        super(length, length)
    }
}