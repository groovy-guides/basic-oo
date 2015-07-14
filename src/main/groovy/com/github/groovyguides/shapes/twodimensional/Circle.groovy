package com.github.groovyguides.shapes.twodimensional

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode
import static java.lang.Math.PI

@EqualsAndHashCode(includeFields=true)
@ToString(includeNames=true,includeFields=true,includeSuper=true)
class Circle extends BasicTwoDimensionalShape {
    
    private final Number radius
    private final Number diameter
    
    public Circle() {
        super()
    }
    
    public Circle(Number radius) {
        super(
            PI * radius * 2,
            PI * radius**2
        )
        this.radius = radius
        this.diameter = this.radius * 2
    }
    
}