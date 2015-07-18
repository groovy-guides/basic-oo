package com.github.groovyguides.shapes.measurement

import com.github.groovyguides.shapes.measurement.UnitOfLength as UoM
import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 *
 * @author Duncan Dickinson
 */
@Unroll
class LengthMeasurementMultiplyTest extends Specification {
    def "Multiplying a measurement (#left) by a number (#right) results in a measurement with value #answer"() {
        given: "Two measurements with the same unit of measurement"
            LengthMeasurement lhs = new LengthMeasurement(left, UoM.Millimetre)
            Number rhs = right

        when: "they are divided"
            LengthMeasurement result = lhs * rhs
        
        then: "the result should equal the value held in the answer"
            result.value == answer

        where: "the left and right measurement values and the answer are"
            left| right || answer
            10  | 5     || 50
            15  | 10    || 150
            99  | 9     || 891
            8   | 2     || 16
    }

    def "Attempting to multiply a measurement by a number <= 0 (#right) throws an IllegalArgumentException"() {
        given: "One measurement and a Number"
            LengthMeasurement lhs = new LengthMeasurement(left, UoM.Millimetre)
            Number rhs = right

        when: "The value of the RHS operand is <=0"
            Exception e = null
            try {
                lhs * rhs
            } catch (any) {
                e = any
            }

        then: "an IllegalArgumentException is thrown"
            e instanceof IllegalArgumentException

        where: "the left and right measurement values are"
            left| right
            10  | -5
            15  | -10
            9   | -9
            8   | -7
    }
}
