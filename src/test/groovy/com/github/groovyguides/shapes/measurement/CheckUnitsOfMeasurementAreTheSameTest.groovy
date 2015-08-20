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
        list                                                                        || result
        []                                                                          || true
        [UnitOfLength.INCH]                                                         || true
        [UnitOfLength.MILLIMETRE]                                                   || true
        [UnitOfLength.INCH, UnitOfLength.INCH]                                      || true
        [UnitOfLength.MILLIMETRE, UnitOfLength.MILLIMETRE]                          || true
        [UnitOfLength.INCH, UnitOfLength.INCH, UnitOfLength.MILLIMETRE]             || false
        [UnitOfLength.INCH, UnitOfLength.MILLIMETRE, UnitOfLength.MILLIMETRE]       || false
        [UnitOfLength.MILLIMETRE, UnitOfLength.MILLIMETRE, UnitOfLength.INCH]       || false
        [UnitOfLength.MILLIMETRE, UnitOfLength.INCH, UnitOfLength.INCH]             || false
        [UnitOfLength.INCH, UnitOfLength.INCH, UnitOfLength.INCH]                   || true
        [UnitOfLength.MILLIMETRE, UnitOfLength.MILLIMETRE, UnitOfLength.MILLIMETRE] || true
    }
}
