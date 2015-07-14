package com.github.groovyguides.shapes.twodimensional

import groovy.transform.ToString

@ToString(includeNames=true,includeFields=true,includeSuper=true)
class Rectangle extends BasicTwoDimensionalShape {

    private final Number length

    private final Number width
    
    public Rectangle() {
        this(0,0)
    }
    
    public Rectangle(Number length, Number width) {
        super(
            length * 2 + width * 2,
            length * width
        )
        this.length = length
        this.width = width
    }    
}