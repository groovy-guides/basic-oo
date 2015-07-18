package com.github.groovyguides.shapes.measurement

/**
 * An example enum used to describe two units of length:
 * inches and millimetres
 *
 * This is an example but could have used https://jcp.org/en/jsr/detail?id=363
 *
 * @author Duncan Dickinson
 */
enum UnitOfLength {

    Millimetre('Millimetre', 'mm'),
    Inch('Inch', 'in')

    private final String name
    private final String symbol

    UnitOfLength(String name, String symbol){
        this.name = name
        this.symbol = symbol
    }

}
