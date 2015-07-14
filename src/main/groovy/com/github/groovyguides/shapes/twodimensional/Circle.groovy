package com.github.groovyguides.shapes.twodimensional

import com.github.groovyguides.shapes.measurement.Measurement
import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode
import static java.lang.Math.PI

@EqualsAndHashCode(includeFields=true)
@ToString(includeNames=true,includeFields=true,includeSuper=true)
class Circle extends BasicTwoDimensionalShape {
    
    private final Measurement radius
    private final Measurement diameter
    
    private Circle() {}
    
    public Circle(Measurement radius) {
        if (radius <=0 ) throw new IllegalArgumentException('The Radius must be greater than 0')
        this.radius = radius
        this.diameter = this.radius * 2
        this.perimeter = new Measurement(PI * this.diameter, this.radius.unit)
        this.diameter = new Measurement(PI * this.radius**2, this.radius.unit)

    }
    
}