package com.github.groovyguides.shapes.twodimensional

import com.github.groovyguides.shapes.measurement.LengthMeasurement
import com.github.groovyguides.shapes.measurement.Millimetre
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

/**
 *
 *
 * @author Duncan Dickinson
 */
@Unroll
@Subject(Triangle)
class TriangleTest extends Specification {
    def "Test that a Triangle of sides (#sideA, #sideB, #sideC) has a perimeter of #perimeter and an area of #area"() {
        given: "A new Triangle"
        LengthMeasurement a = new Millimetre(sideA)
        LengthMeasurement b = new Millimetre(sideB)
        LengthMeasurement c = new Millimetre(sideC)
        Triangle t = new Triangle(a, b, c)
        expect: "that the perimeter and area calculations are correct"
        t.getPerimeter().getLength() == perimeter
        t.getArea().getLength().trunc(4) == area
        where: "the dimensions and resulting measurements are"
        sideA | sideB | sideC  || perimeter | area
        3     | 4     | 5      || 12        | 6
        3     | 3     | 3      || 9         | 3.8971

    }

}
