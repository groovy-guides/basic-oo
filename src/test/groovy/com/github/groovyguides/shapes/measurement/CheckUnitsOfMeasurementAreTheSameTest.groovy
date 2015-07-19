package com.github.groovyguides.shapes.measurement

import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 *
 * @author Duncan Dickinson
 */
@Unroll
class CheckUnitsOfMeasurementAreTheSameTest extends Specification {
    def "Test that checkUnitsOfMeasurementAreTheSame  using #list"() {
        given: ""
            def measurements = []
            for (item in list) {
                measurements << new LengthMeasurement(1, item)
            }
        expect: "all "
            result == LengthMeasurement.checkUnitsOfMeasurementAreTheSame(*measurements)
        where:
        list || result
        [] || true
        [UnitOfLength.Inch] || true
        [UnitOfLength.Millimetre] || true
        [UnitOfLength.Inch, UnitOfLength.Inch] || true
        [UnitOfLength.Millimetre, UnitOfLength.Millimetre] || true
        [UnitOfLength.Inch, UnitOfLength.Inch, UnitOfLength.Millimetre] || false
        [UnitOfLength.Inch, UnitOfLength.Millimetre, UnitOfLength.Millimetre] || false
        [UnitOfLength.Millimetre, UnitOfLength.Millimetre, UnitOfLength.Inch] || false
        [UnitOfLength.Millimetre, UnitOfLength.Inch, UnitOfLength.Inch] || false
        [UnitOfLength.Inch, UnitOfLength.Inch, UnitOfLength.Inch] || true
        [UnitOfLength.Millimetre, UnitOfLength.Millimetre, UnitOfLength.Millimetre] || true
    }
}
