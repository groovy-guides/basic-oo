package com.github.groovyguides.shapes.measurement

import com.github.groovyguides.shapes.measurement.UnitOfLength as UoM
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

/**
 *
 *
 * @author Duncan Dickinson
 */
@Unroll
@Subject(LengthMeasurement)
class LengthMeasurementMinusTest extends Specification {
    def "Subtracting two measurements with the values #left, #right results in a measurement with value #answer"() {
        given: "Two measurements with the same unitOfLength of measurement"
        LengthMeasurement lhs = new LengthMeasurement(left, UoM.MILLIMETRE)
        LengthMeasurement rhs = new LengthMeasurement(right, UoM.MILLIMETRE)

        expect: "the result should equal the length held in the answer"
        (lhs - rhs).length == answer

        where: "the left and right measurement values and the answer are"
        left | right || answer
        10 | 5 || 5
        15 | 10 || 5
        9 | 1 || 8
        8 | 7 || 1
    }

    def "Subtracting two measurements with the values #left, #right will result in a negative or zero measurement and will throw an IllegalArgumentException"() {
        given: "Two measurements with the same unitOfLength of measurement"
        LengthMeasurement lhs = new LengthMeasurement(left, UoM.MILLIMETRE)
        LengthMeasurement rhs = new LengthMeasurement(right, UoM.MILLIMETRE)

        when: "The length of the RHS operand is > the length of the LHS"
        Exception e = null
        try {
            lhs - rhs
        } catch (any) {
            e = any
        }

        then: "the result would be a negative or zero measurement so an IllegalArgumentException is thrown"
        e instanceof IllegalArgumentException

        where: "the left and right measurement values are"
        left | right
        10 | 15
        10 | 10
        3 | 9
        1 | 7
    }

    def "Attempting to subtract two measurements with different units of measurement (#left, #right) will throw an IllegalArgumentException"() {
        given: "Two measurements each with a different unitOfLength of measurement"
        LengthMeasurement lhs = new LengthMeasurement(12, left)
        LengthMeasurement rhs = new LengthMeasurement(10, right)

        when:
        Exception e = null
        try {
            lhs - rhs
        } catch (any) {
            e = any
        }

        then: "the sum of the two measurements should equal the length held in the result"
        e instanceof IllegalArgumentException

        where: "the left and right measurement values and their summed result are"
        left | right
        UoM.MILLIMETRE | UoM.INCH
        UoM.INCH | UoM.MILLIMETRE
    }

}
