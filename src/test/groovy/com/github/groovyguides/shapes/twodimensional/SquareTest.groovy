package com.github.groovyguides.shapes.twodimensional

import com.github.groovyguides.shapes.measurement.LengthMeasurement
import com.github.groovyguides.shapes.measurement.Millimetre
import com.github.groovyguides.shapes.measurement.UnitOfLength
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

/**
 *
 *
 * @author Duncan Dickinson
 */
@Unroll
@Subject(Square)
class SquareTest extends Specification {
    def "Test that a Square of length #length has a perimeter of #perimeter and an area of #area"() {
        given: "A new Square"
            Square s = new Square(new LengthMeasurement(length, UnitOfLength.Millimetre))
        expect: "that the fields are set correctly"
            s.length.length == length
            s.length == s.width
            s.getPerimeter().getLength() == perimeter
            s.getArea().getLength() == area
        where: "the dimensions and resulting measurements are"
        length  || perimeter | area
        2       || 8         | 4
        10      || 40        | 100
        6       || 24        | 36
        10.1    || 40.4      | 102.01
    }

}
