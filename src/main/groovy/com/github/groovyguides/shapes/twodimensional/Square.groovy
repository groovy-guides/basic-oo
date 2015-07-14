package com.github.groovyguides.shapes.twodimensional

import groovy.transform.ToString

class Square extends Rectangle {
    
    public Square() {
        super()
    }
    
    public Square(Number length) {
        super(length, length)
    }
}