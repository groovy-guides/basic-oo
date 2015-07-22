package com.github.groovyguides.shapes.twodimensional.triangle

import com.github.groovyguides.shapes.measurement.LengthMeasurement
import com.github.groovyguides.shapes.measurement.Millimetre
import com.github.groovyguides.shapes.twodimensional.triangle.TriangleRightAngled
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

/**
 *
 *
 * @author Duncan Dickinson
 */
@Unroll
@Subject(TriangleRightAngled)
class TriangleRightAngledTest extends Specification {
    def "Test that a Right Angled Triangle of sides (#sideA, #sideB) has a perimeter of #perimeter and an area of #area"() {
        given: "A new Right Angled Triangle"
        LengthMeasurement a = new Millimetre(sideA)
        LengthMeasurement b = new Millimetre(sideB)
        TriangleRightAngled t = new TriangleRightAngled(a, b)
        expect: "that the perimeter and area calculations are correct"
        t.perimeter.length == perimeter
        t.area.length == area
        where: "the dimensions and resulting measurements are"
        sideA | sideB || perimeter | area
        3     | 4     || 12        | 6

    }

}
