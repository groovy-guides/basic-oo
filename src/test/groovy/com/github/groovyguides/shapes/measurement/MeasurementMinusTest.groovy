package com.github.groovyguides.shapes.measurement

import com.github.groovyguides.shapes.measurement.UnitOfMeasurement as UoM
import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 *
 * @author Duncan Dickinson
 */
@Unroll
class MeasurementMinusTest extends Specification {
    def "Subtracting two measurements with the values #left, #right results in a measurement with value #answer"() {
        given: "Two measurements with the same unit of measurement"
            Measurement lhs = new Measurement(left, UoM.Millimetre)
            Measurement rhs = new Measurement(right, UoM.Millimetre)

        when: "they are subtracted"
            Measurement result = lhs - rhs
        
        then: "the result should equal the value held in the answer"
            result.value == answer

        where: "the left and right measurement values and the answer are"
            left| right || answer
            10  | 5     || 5
            15  | 10    || 5
            9.1 | 9     || 0.1
            8.4 | 7.2   || 1.2
    }

    def "Subtracting two measurements with the values #left, #right will result in a negative measurement and will throw an IllegalArgumentException"() {
        given: "Two measurements with the same unit of measurement"
            Measurement lhs = new Measurement(left, UoM.Millimetre)
            Measurement rhs = new Measurement(right, UoM.Millimetre)

        when: "The value of the RHS operand is > the value of the LHS"
            Exception e
            try {
                lhs - rhs
            } catch (any) {
                e = any
            }

        then: "the result would be a negative measurement so an IllegalArgumentException is thrown"
            e.class == IllegalArgumentException.class

        where: "the left and right measurement values are"
            left| right
            10  | 15
            5   | 10
            3.1 | 9
            0.4 | 7.2
    }

    def "Subtracting a measurement with value #left and a Number (#right) results in a Measurement with value #answer"() {
        given: "One measurement and a Number"
            Measurement lhs = new Measurement(left, UoM.Millimetre)
            Number rhs = right

        when:
            Measurement result = lhs - rhs

        then: "the result should equal the value held in the answer"
            result.value == answer

        where: "the left and right measurement values and their summed result are"
            left| right || answer
            10  | 5     || 5
            15  | 10   || 5
            9.1 | 9     || 0.1
            8.4 | 7.2   || 1.2
    }

    def "Subtracting a number (#right) from a measurement with the value #left will result in a negative measurement and will throw an IllegalArgumentException"() {
        given: "Two measurements with the same unit of measurement"
            Measurement lhs = new Measurement(left, UoM.Millimetre)
            Number rhs = right

        when: "The value of the RHS operand is > the value of the LHS"
        Exception e
            try {
                lhs - rhs
            } catch (any) {
                e = any
            }

        then: "the result would be a negative measurement so an IllegalArgumentException is thrown"
            e.class == IllegalArgumentException.class

        where: "the left and right measurement values are"
            left| right
            10  | 15
            5   | 10
            3.1 | 9
            0.4 | 7.2
    }

    def "Attempting to subtract two measurements with different units of measurement (#left, #right) will throw an IllegalArgumentException"() {
        given: "Two measurements each with a different unit of measurement"
            Measurement lhs = new Measurement(12, left)
            Measurement rhs = new Measurement(10, right)

        when:
            Exception e
            try {
                lhs - rhs
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
