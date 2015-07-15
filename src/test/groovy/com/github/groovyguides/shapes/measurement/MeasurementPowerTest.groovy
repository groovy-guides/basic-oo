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
class MeasurementPowerTest extends Specification {
    def ""() {
        given: ""
            Measurement m = new Measurement(left, UoM.Millimetre)
            Number exp = exponent

        when: "they are divided"
            Measurement result = m**exp
        
        then: "the result should equal the value held in the answer"
            result.value == answer

        where: "the left and right measurement values and the answer are"
            left| exponent || answer
            2   | 2     || 4
            7   | 3     || 343
            5   | -2    || 0.4
    }
}
