package com.github.groovyguides.shapes.twodimensional

import groovy.transform.ToString

@ToString(includeNames=true,includeFields=true,includeSuper=true)
class Rectangle extends BasicTwoDimensionalShape {

    private final Number length

    private final Number width
    
    private Rectangle() {}
    
    Rectangle(Number length, Number width) {

        if (length <=0 ) throw new IllegalArgumentException('The Length must be greater than 0')
        if (width <=0 ) throw new IllegalArgumentException('The Width must be greater than 0')

        this.length = length
        this.width = width
        super.perimeter = this.length * 2 + this.width * 2
        super.area = this.length * this.width
    }    
}