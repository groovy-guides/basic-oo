package com.github.groovyguides.shapes.twodimensional

import com.github.groovyguides.shapes.measurement.Inch
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
@Subject(Rectangle)
class RectangleTest extends Specification {
    def "Test that a rectangle of length #length and width #width has a perimeter of #perimeter and an area of #area"() {
        given: "A new rectangle"
            Rectangle r = new Rectangle(new Millimetre(length), new Millimetre(width))
        expect: "that the fields are set correctly"
            r.length.length == length
            r.width.length == width
            r.perimeter.length == perimeter
            r.area.length == area
        where: "the dimensions and resulting measurements are"
        length  | width || perimeter | area
        2       | 2     || 8         | 4
        10      | 7     || 34        | 70
        6       | 100   || 212       | 600
    }

    def "Another test that a rectangle of length #length and width #width has a perimeter of #perimeter and an area of #area"() {
        //A minor variation of the previous - just using the base LengthMeasurement class and not a subclass thereof
        given: "A new rectangle"
        LengthMeasurement l = new LengthMeasurement(length, UnitOfLength.INCH)
        LengthMeasurement w = new LengthMeasurement(width, UnitOfLength.INCH)
        Rectangle r = new Rectangle(l, w)
        expect: "that the fields are set correctly"
        r.length.length == length
        r.width.length == width
        r.perimeter.length == perimeter
        r.area.length == area
        where: "the dimensions and resulting measurements are"
        length  | width || perimeter | area
        2       | 2     || 8         | 4
        10      | 7     || 34        | 70
        6       | 100   || 212       | 600
    }


    def "Attempting to create a rectangle for which the length(#length) and width(#width) have differe UoM will throw an IllegalArgumentException"() {
        expect:
            Exception e = null
            try {
                new Rectangle(length, width)
            } catch (any) {
                e = any
            }
            e instanceof IllegalArgumentException
        where:
        length                | width
        new Millimetre(10)  | new Inch(99)
        new Inch(8)         | new Millimetre(2)
        new LengthMeasurement(6, UnitOfLength.INCH) | new LengthMeasurement(7, UnitOfLength.MILLIMETRE)
        new LengthMeasurement(9, UnitOfLength.MILLIMETRE) | new Inch(12)
    }
}
