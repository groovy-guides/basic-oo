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
class MeasurementMultiplyTest extends Specification {
    def "Multiplying a measurement (#left) by a number (#right) results in a measurement with value #answer"() {
        given: "Two measurements with the same unit of measurement"
            Measurement lhs = new Measurement(left, UoM.Millimetre)
            Number rhs = right

        when: "they are divided"
            Measurement result = lhs * rhs
        
        then: "the result should equal the value held in the answer"
            result.value == answer

        where: "the left and right measurement values and the answer are"
            left| right || answer
            10  | 5     || 2
            15  | 10    || 1.5
            99  | 9     || 11
            8.4 | 2     || 4.2
    }

    def "Attempting to multiply a measurement by a number <= 0 (#right) throws an IllegalArgumentException"() {
        given: "One measurement and a Number"
            Measurement lhs = new Measurement(left, UoM.Millimetre)
            Number rhs = right

        when: "The value of the RHS operand is <=0"
            Exception e
            try {
                lhs * rhs
            } catch (any) {
                e = any
            }

        then: "an IllegalArgumentException is thrown"
            e.class == IllegalArgumentException.class

        where: "the left and right measurement values are"
            left| right
            10  | -5
            15  | -10
            9.1 | -9
            8.4 | -7.2
    }
}
