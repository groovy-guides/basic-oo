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
class LengthMeasurementPowerTest extends Specification {
    def "A measurement with value (#left) to the power (#exponent) a new measurement will be returned with the value #answer"() {
        given: "A measurement and an exponent"
        LengthMeasurement m = new LengthMeasurement(length, UoM.MILLIMETRE)
        Number exp = exponent

        when: "they are divided"
        LengthMeasurement result = m**exp

        then: "the result should equal the length held in the answer"
        result.length == answer

        where: "the length and the exponent are"
        length | exponent || answer
        2 | 2 || 4
        7 | 3 || 343
    }

    def "A measurement with value (#left) to a negative power (#exponent) will fail to create a new instance as the resulting value will be a decimal"() {
        given: "A measurement and an exponent"
        LengthMeasurement m = new LengthMeasurement(length, UoM.MILLIMETRE)
        Number exp = exponent

        when: "they are divided"
        Exception e = null
        try {
            LengthMeasurement result = m**exp
        } catch (any) {
            e = any
        }
        then: "an IllegalArgumentException is thrown"
        e instanceof IllegalArgumentException

        where: "the length and the exponent are"
        length | exponent
        5 | -2
    }
}
