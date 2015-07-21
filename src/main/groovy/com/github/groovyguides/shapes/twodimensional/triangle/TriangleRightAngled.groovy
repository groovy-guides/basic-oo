package com.github.groovyguides.shapes.twodimensional.triangle

import com.github.groovyguides.shapes.measurement.LengthMeasurement
import com.github.groovyguides.shapes.measurement.SameUoLRequiredException
import com.github.groovyguides.shapes.twodimensional.Triangle

/**
 *
 *
 * @author Duncan Dickinson
 */
class TriangleRightAngled extends Triangle {

    TriangleRightAngled(LengthMeasurement sideA,
                        LengthMeasurement sideB,
                        LengthMeasurement sideC = calculateSideC(sideA, sideB))
            throws SameUoLRequiredException, IllegalArgumentException {
        super(sideA, sideB, sideC)
    }

    static LengthMeasurement calculateSideC(LengthMeasurement sideA, LengthMeasurement sideB) {
        LengthMeasurement.sqrt(sideA ** 2 + sideB ** 2)
    }

    @Override
    protected void calculateArea() {
        Number area = 0.5 * this.sideA.length * this.sideB.length
        this.setArea(new LengthMeasurement(area, this.sideA.unitOfLength))
    }
}
