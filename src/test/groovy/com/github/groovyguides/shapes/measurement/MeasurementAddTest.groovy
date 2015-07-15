package com.github.groovyguides.shapes.measurement

import spock.lang.Specification
import spock.lang.Unroll
import com.github.groovyguides.shapes.measurement.UnitOfMeasurement as UoM

/**
 *
 *
 * @author Duncan Dickinson
 */
@Unroll
class MeasurementPlusTest extends Specification {
    def "Adding two measurements with the values #left, #right results in a measurement with value #answer"() {
        given: "Two measurements with the same unit of measurement"
            Measurement lhs = new Measurement(left, UoM.Millimetre)
            Measurement rhs = new Measurement(right, UoM.Millimetre)

        when:
            Measurement result = lhs + rhs

        then: "the sum of the two measurements should equal the value held in the result"
            result.value == answer

        where: "the left and right measurement values and their summed result are"
            left| right || answer
            10  | 5     || 15
            5   | 10    || 15
            3.1 | 9     || 12.1
            0.4 | 7.2   || 7.6
    }

    def "Adding a measurement with value #left and a Number (#right) results in a Measurement with value #answer"() {
        given: "One measurement and a Number"
            Measurement lhs = new Measurement(left, UoM.Millimetre)
            Number rhs = right

        when:
            Measurement result = lhs + rhs

        then: "that "
            result.value == answer

        where: "the left and right measurement values and their summed result are"
            left| right || answer
            10  | 5     || 15
            5   | 10    || 15
            3.1 | 9     || 12.1
            0.4 | 7.2   || 7.6
    }

    def "Attempting to add two measurements with different units of measurement (#left, #right) will throw an IllegalArgumentException"() {
        given: "Two measurements each with a different unit of measurement"
            Measurement lhs = new Measurement(10, left)
            Measurement rhs = new Measurement(10, right)

        when:
            Exception e
            try {
                lhs + rhs
            } catch (any) {
                e = any
            }

        then: "the sum of the two measurements should equal the value held in the result"
            e.class == IllegalArgumentException.class

        where: "the left and right measurement values and their summed result are"
            left            | right
            UoM.Millimetre  | UoM.Inch
            UoM.Inch        | UoM.Millimetre
    }

}
