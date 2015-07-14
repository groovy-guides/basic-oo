package com.github.groovyguides.shapes.twodimensional

import groovy.transform.ToString

class Square extends Rectangle {
    
    private Square() {}
    
    public Square(Number length) {
        super(length, length)
    }
}