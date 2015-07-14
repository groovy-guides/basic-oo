package com.github.groovyguides.shapes.twodimensional

import com.github.groovyguides.shapes.measurement.Measurement
import groovy.transform.ToString

@ToString(includeNames=true,includeFields=true,includeSuper=true)
class Rectangle extends BasicTwoDimensionalShape {

    private final Measurement length

    private final Measurement width
    
    private Rectangle() {}
    
    Rectangle(Measurement length, Measurement width) {

        if (length.unit != width.unit ) throw new IllegalArgumentException('The length and width must use the same unit of measurement')

        this.length = length
        this.width = width
        super.perimeter = new Measurement(this.length * 2 + this.width * 2, this.length.unit)
        super.area = new Measurement(this.length * this.width, this.length.unit)
    }    
}