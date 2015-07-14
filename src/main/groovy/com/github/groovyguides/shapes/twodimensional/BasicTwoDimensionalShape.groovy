package com.github.groovyguides.shapes.twodimensional

import groovy.transform.ToString

@ToString(includeNames=true,includeFields=true)
abstract class BasicTwoDimensionalShape implements TwoDimensionalShape {

    final private Number perimeter
    
    final private Number area
    
    protected BasicTwoDimensionalShape() {
        this(0,0)
    }
    
    protected BasicTwoDimensionalShape(Number perimeter, Number area) {
        this.perimeter = perimeter
        this.area = area
    }
    
    public Number getPerimeter() {perimeter}
    
    public Number getArea() {area}

}