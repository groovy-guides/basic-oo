package com.github.groovyguides.shapes.twodimensional

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
@Subject(Circle)
class CircleTest extends Specification {
    def "Test that a Circle of radius #radius has a diameter of #diameter, a perimeter of #perimeter and an area of #area"() {
        given: "A new Circle"
        Circle r = new Circle(new Millimetre(radius))
        expect: "that the fields are set correctly"
            r.radius.length == radius
            r.diameter.length == radius * 2
            r.getPerimeter().getLength().trunc(4) == perimeter
            r.getPerimeter() == r.getCircumference()
            r.getArea().getLength().trunc(4) == area

        where: "the dimensions and resulting measurements are"
        radius  || diameter  | perimeter | area
        2       || 4         | 12.5663   | 12.5663
        10      || 20        | 62.8318   | 314.1592
        6       || 12        | 37.6991   | 113.0973
    }

}
