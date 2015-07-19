package com.github.groovyguides.shapes.twodimensional.triangle

import com.github.groovyguides.shapes.measurement.LengthMeasurement
import com.github.groovyguides.shapes.measurement.Millimetre
import com.github.groovyguides.shapes.twodimensional.triangle.TriangleEquilateral
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

/**
 *
 *
 * @author Duncan Dickinson
 */
@Unroll
@Subject(TriangleEquilateral)
class TriangleEquilateralTest extends Specification {
    def "Test that an Equilateral Triangle of side (#sideA) has a perimeter of #perimeter and an area of #area"() {
        given: "A new Equilateral Triangle"
        LengthMeasurement a = new Millimetre(sideA)
        TriangleEquilateral t = new TriangleEquilateral(a)
        expect: "that the perimeter and area calculations are correct"
        t.getPerimeter().getLength() == perimeter
        t.getArea().getLength().trunc(4) == area
        where: "the dimensions and resulting measurements are"
        sideA || perimeter | area
        3     || 9         | 3.8971
        7.2   || 21.6      | 22.4473

    }

}
