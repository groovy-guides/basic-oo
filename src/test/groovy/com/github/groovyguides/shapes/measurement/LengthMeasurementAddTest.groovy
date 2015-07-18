package com.github.groovyguides.shapes.measurement

import spock.lang.Specification
import spock.lang.Unroll
import com.github.groovyguides.shapes.measurement.UnitOfLength as UoM

/**
 *
 *
 * @author Duncan Dickinson
 */
@Unroll
class LengthMeasurementAddTest extends Specification {
    def "Adding two measurements with the values #left, #right results in a measurement with value #answer"() {
        given: "Two measurements with the same unitOfLength of measurement"
            LengthMeasurement lhs = new LengthMeasurement(left, UoM.Millimetre)
            LengthMeasurement rhs = new LengthMeasurement(right, UoM.Millimetre)

        when:
            LengthMeasurement result = lhs + rhs

        then: "the sum of the two measurements should equal the length held in the result"
            result.length == answer

        where: "the left and right measurement values and their summed result are"
            left| right || answer
            10  | 5     || 15
            5   | 10    || 15
            3   | 9     || 12
            4   | 7     || 11
    }

    def "Adding a measurement with value #left and a Number (#right) results in a Measurement with value #answer"() {
        given: "One measurement and a Number"
            LengthMeasurement lhs = new LengthMeasurement(left, UoM.Millimetre)
            Number rhs = right

        when:
            LengthMeasurement result = lhs + rhs

        then: "that "
            result.length == answer

        where: "the left and right measurement values and their summed result are"
            left| right || answer
            10  | 5     || 15
            5   | 10    || 15
            3   | 9     || 12
            4   | 7     || 11
    }

    def "Attempting to add two measurements with different units of measurement (#left, #right) will throw an IllegalArgumentException"() {
        given: "Two measurements each with a different unitOfLength of measurement"
            LengthMeasurement lhs = new LengthMeasurement(10, left)
            LengthMeasurement rhs = new LengthMeasurement(10, right)

        when:
            Exception e = null
            try {
                lhs + rhs
            } catch (any) {
                e = any
            }

        then: "the sum of the two measurements should equal the length held in the result"
            e instanceof IllegalArgumentException

        where: "the left and right measurement values and their summed result are"
            left            | right
            UoM.Millimetre  | UoM.Inch
            UoM.Inch        | UoM.Millimetre
    }

}
