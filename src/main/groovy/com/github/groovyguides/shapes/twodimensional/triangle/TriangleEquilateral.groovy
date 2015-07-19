package com.github.groovyguides.shapes.twodimensional.triangle

import com.github.groovyguides.shapes.measurement.LengthMeasurement
import com.github.groovyguides.shapes.measurement.SameUoLRequiredException
import com.github.groovyguides.shapes.twodimensional.Triangle

/**
 *
 *
 * @author Duncan Dickinson
 */
class TriangleEquilateral extends Triangle {

    TriangleEquilateral(LengthMeasurement sideA)
            throws SameUoLRequiredException, IllegalArgumentException {
        super(sideA, sideA, sideA)
    }

    @Override
    protected void calculateArea() {
        Number area = Math.sqrt(3) / 4 * this.sideA.length**2
        this.setArea(new LengthMeasurement(area, this.sideA.unitOfLength))
    }
}

