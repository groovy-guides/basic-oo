package com.github.groovyguides.shapes

import com.github.groovyguides.shapes.measurement.Measurement
import com.github.groovyguides.shapes.measurement.UnitOfMeasurement
import com.github.groovyguides.shapes.twodimensional.Rectangle


//Square mySquare = new Square(10)

Measurement length = new Measurement(20, UnitOfMeasurement.Millimetre)
Measurement width = new Measurement(50, UnitOfMeasurement.Millimetre)
Rectangle myRectangle = new Rectangle(length, width)