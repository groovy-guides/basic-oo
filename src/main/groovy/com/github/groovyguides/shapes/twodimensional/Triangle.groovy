package com.github.groovyguides.shapes.twodimensional

import com.github.groovyguides.shapes.measurement.LengthMeasurement
import com.github.groovyguides.shapes.measurement.SameUoLRequiredException
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import sun.security.util.Length

/**
 *
 *
 * @author Duncan Dickinson
 */
@EqualsAndHashCode(includeFields = true, cache = true)
@ToString(includeNames=true,includeFields=true,includeSuper=true)
class Triangle extends BasicTwoDimensionalShape {

    private final Map<String, LengthMeasurement> sides

    Triangle(){}

    Triangle(LengthMeasurement sideA, LengthMeasurement sideB, LengthMeasurement sideC)
            throws SameUoLRequiredException, IllegalArgumentException {

        if (!sideA || !sideB || !sideC) {
            throw new IllegalArgumentException('Unable to determine Sides a,b and c')
        }

        if (!LengthMeasurement.checkUnitsOfMeasurementAreTheSame(sideA, sideB, sideC)){
            throw new SameUoLRequiredException()
        }

        this.sides = [a: sideA.clone() as LengthMeasurement,
                      b: sideB.clone() as LengthMeasurement,
                      c: sideC.clone() as LengthMeasurement].asImmutable()
    }

    Map<String, LengthMeasurement> getSides() {
        return sides
    }

    LengthMeasurement getSideA() {
        return this.sides.a
    }

    LengthMeasurement getSideB() {
        return this.sides.b
    }

    LengthMeasurement getSideC() {
        return this.sides.c
    }

    @Override
    protected void calculatePerimeter() {
        Number sum = 0

        for (LengthMeasurement side in this.sides.values()) {
            sum += side.length
        }
         def uol = this.sides.a.unitOfLength
        this.setPerimeter(new LengthMeasurement(sum, uol))
    }

    /**
     * @see <a href="https://en.wikipedia.org/wiki/Heron%27s_formula">Wikipedia - Heron's Formula</a>
     */
    @Override
    protected void calculateArea() {
        Number a = this.sides.a.getLength()
        Number b = this.sides.b.getLength()
        Number c = this.sides.c.getLength()

        Number s = (a + b + c) / 2

        Number working = s * (s - a) * (s - b) * (s - c)

        Number area = Math.sqrt(working)

        this.setArea(new LengthMeasurement(area, this.sides.a.getUnitOfLength()))
    }

}
