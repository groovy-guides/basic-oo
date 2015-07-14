package com.github.groovyguides.shapes.measurement

/**
 *
 *
 * This is an example but could have used https://jcp.org/en/jsr/detail?id=363
 *
 * @author Duncan Dickinson
 */
enum UnitOfMeasurement {

    Millimetre('Millimetre', 'mm'),
    Inch('Inch', 'in')

    private final String name
    private final String symbol
    private final Number inMillimetres

    UnitOfMeasurement(String name, String symbol){
        this.name = name
        this.symbol = symbol
    }

}
