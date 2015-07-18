package com.github.groovyguides.shapes.twodimensional

import com.github.groovyguides.shapes.measurement.Millimetre
import spock.lang.Specification

/**
 *
 *
 * @author Duncan Dickinson
 */
class SquareTest extends Specification {
    def "Test that a Square of length #length has a perimeter of #perimeter and an area of #area"() {
        given: "A new Square"
            Square r = new Square(new Millimetre(length))
        expect: "that the fields are set correctly"
            r.length.length == length
            r.getPerimeter().getLength() == perimeter
            r.getArea().getLength() == area
        where: "the dimensions and resulting measurements are"
        length  || perimeter | area
        2       || 8         | 4
        10      || 40        | 100
        6       || 24        | 36
    }

}
