package com.github.groovyguides.shapes.twodimensional

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode
import static java.lang.Math.PI

@EqualsAndHashCode(includeFields=true)
@ToString(includeNames=true,includeFields=true,includeSuper=true)
class Circle extends BasicTwoDimensionalShape {
    
    private final Number radius
    private final Number diameter
    
    private Circle() {}
    
    public Circle(Number radius) {
        if (radius <=0 ) throw new IllegalArgumentException('The Radius must be greater than 0')
        this.radius = radius
        this.diameter = this.radius * 2
        this.perimeter = PI * this.diameter
        this.diameter = PI * this.radius**2

    }
    
}