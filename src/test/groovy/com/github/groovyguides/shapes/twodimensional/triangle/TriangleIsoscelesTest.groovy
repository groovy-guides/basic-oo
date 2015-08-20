package com.github.groovyguides.shapes.twodimensional.triangle

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
@Subject(TriangleIsosceles)
class TriangleIsoscelesTest extends Specification {
    def "Test that an Isosceles Triangle of sides (#sideA, #sideB) has a perimeter of #perimeter and an area of #area"() {
        given: "A new Isosceles Triangle"
        LengthMeasurement a = new Millimetre(sideA)
        LengthMeasurement b = new Millimetre(sideB)
        TriangleIsosceles t = new TriangleIsosceles(a, b)
        expect: "that the perimeter and area calculations are correct"
        t.perimeter.length == perimeter
        t.area.length.trunc(4) == area
        where: "the dimensions and resulting measurements are"
        sideA | sideB || perimeter | area
        4.0 | 5.0 || 14.0 | 9.1651

    }

}
