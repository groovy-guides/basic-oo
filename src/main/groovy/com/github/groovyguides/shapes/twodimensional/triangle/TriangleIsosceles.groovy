package com.github.groovyguides.shapes.twodimensional.triangle

import com.github.groovyguides.shapes.measurement.LengthMeasurement
import com.github.groovyguides.shapes.measurement.SameUoLRequiredException
import com.github.groovyguides.shapes.twodimensional.Triangle

/**
 *
 *
 * @author Duncan Dickinson
 */
class TriangleIsosceles extends Triangle {

    TriangleIsosceles(LengthMeasurement sideA, LengthMeasurement sideB)
            throws SameUoLRequiredException, IllegalArgumentException {
        super(sideA, sideB, sideB)
    }

    @Override
    protected void calculateArea() {
        Number height = Math.sqrt(this.sideB.length**2 - (this.sideA.length**2 / 4))
        this.setArea(this.sideA * (height / 2))
    }
}

