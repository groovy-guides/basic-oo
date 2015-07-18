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
class LengthMeasurementDivTest extends Specification {
    def "Dividing a measurement (#left) by a number (#right) results in a measurement with value #answer"() {
        given: "Two measurements with the same unitOfLength of measurement"
            LengthMeasurement lhs = new LengthMeasurement(left, UoM.Millimetre)
            Number rhs = right

        when: "they are divided"
            LengthMeasurement result = lhs / rhs
        
        then: "the result should equal the length held in the answer"
            result.length == answer

        where: "the left and right measurement values and the answer are"
            left| right || answer
            10  | 5     || 2
            50  | 10    || 5
            99  | 9     || 11
            8   | 2     || 4
    }

    def "Attempting to divide a measurement by a number <= 0 (#right) throws an IllegalArgumentException"() {
        given: "One measurement and a Number"
            LengthMeasurement lhs = new LengthMeasurement(left, UoM.Millimetre)
            Number rhs = right

        when: "The length of the RHS operand is <=0"
            Exception e = null
            try {
                lhs / rhs
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
