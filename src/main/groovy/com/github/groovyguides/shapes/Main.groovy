package com.github.groovyguides.shapes

import com.github.groovyguides.shapes.measurement.LengthMeasurement
import com.github.groovyguides.shapes.measurement.UnitOfLength
import com.github.groovyguides.shapes.twodimensional.Rectangle


//Square mySquare = new Square(10)

LengthMeasurement length = new LengthMeasurement(20, UnitOfLength.MILLIMETRE)
LengthMeasurement width = new LengthMeasurement(50, UnitOfLength.MILLIMETRE)
Rectangle myRectangle = new Rectangle(length, width)