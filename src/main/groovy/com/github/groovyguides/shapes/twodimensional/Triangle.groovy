package com.github.groovyguides.shapes.twodimensional

import com.github.groovyguides.shapes.measurement.LengthMeasurement
import com.github.groovyguides.shapes.measurement.SameUoLRequiredException
import com.github.groovyguides.shapes.measurement.UnitOfLength
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 *
 *
 * @author Duncan Dickinson
 */
@EqualsAndHashCode(includeFields = true, cache = true)
@ToString(includeNames = true, includeFields = true, includeSuper = true)
class Triangle extends BasicTwoDimensionalShape {

    private final Map<String, LengthMeasurement> sides

    Triangle() {

    }

    Triangle(LengthMeasurement sideA, LengthMeasurement sideB, LengthMeasurement sideC)
            throws SameUoLRequiredException, IllegalArgumentException {

        if (!sideA || !sideB || !sideC) {
            throw new IllegalArgumentException('Unable to determine Sides a,b and c')
        }

        if (!LengthMeasurement.checkUnitsOfMeasurementAreTheSame(sideA, sideB, sideC)) {
            throw new SameUoLRequiredException()
        }

        this.sides = [a:sideA.clone() as LengthMeasurement,
                      b:sideB.clone() as LengthMeasurement,
                      c:sideC.clone() as LengthMeasurement].asImmutable()
    }

    Map<String, LengthMeasurement> getSides() {
        sides
    }

    LengthMeasurement getSideA() {
        this.sides.a
    }

    LengthMeasurement getSideB() {
        this.sides.b
    }

    LengthMeasurement getSideC() {
        this.sides.c
    }

    @Override
    protected void calculatePerimeter() {
        Number sum = 0

        for (LengthMeasurement side in this.sides.values()) {
            sum += side.length
        }
        UnitOfLength uol = this.sides.a.unitOfLength
        this.setPerimeter(new LengthMeasurement(sum, uol))
    }

    /**
     * @see <a href="https://en.wikipedia.org/wiki/Heron%27s_formula">Wikipedia - Heron's Formula</a>
     */
    @Override
    protected void calculateArea() {
        Number a = this.sides.a.length
        Number b = this.sides.b.length
        Number c = this.sides.c.length

        Number s = (a + b + c) / 2

        Number working = s * (s - a) * (s - b) * (s - c)

        Number area = Math.sqrt(working)

        this.area = new LengthMeasurement(area, this.sides.a.getUnitOfLength())
    }

}
