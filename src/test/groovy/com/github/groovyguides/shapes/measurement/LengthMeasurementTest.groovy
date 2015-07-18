package com.github.groovyguides.shapes.measurement

import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 *
 * @author Duncan Dickinson
 */
@Unroll
class LengthMeasurementTest extends Specification {
    def "Creating a new Measurement instance with a positive value (#value) and a UnitOfMeasurement (#uom) will produce the correct measurement instance"() {

        when: "an attempt is made to create a new instance"
        LengthMeasurement m = new LengthMeasurement(length, uom)


        then: "the measurement's length and UoM are correct"
            m.getLength() == length
            m.getUnitOfLength() == uom

        where: "the values are"
            length  | uom                            || _
            1       | UnitOfLength.Inch         || _
            1       | UnitOfLength.Millimetre   || _
            99      | UnitOfLength.Inch         || _

    }


    def "Creating a new Measurement instance with a negative or zero value (#value) will cause an IllegalArgumentException"() {

        when: "an attempt is made to create a new instance with a negative length"
            Exception e = null
            try {
                LengthMeasurement m = new LengthMeasurement(length, UnitOfLength.Inch)
            } catch (any) {
                e = any
            }

        then: "an IllegalArgumentException is thrown"
            e instanceof IllegalArgumentException

        where: "the values are"
            length  | _
            -1      | _
            -99     | _
            0       | _
    }
}
