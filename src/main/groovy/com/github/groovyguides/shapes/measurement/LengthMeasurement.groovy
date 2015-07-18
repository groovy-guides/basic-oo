package com.github.groovyguides.shapes.measurement

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Describes a (length) measurement such as 10mm or 5".
 *
 * The length of the measurement must be >= 0.
 *
 * @author Duncan Dickinson
 */
@EqualsAndHashCode(includeFields = true, cache = true)
@ToString(includeNames = true, includeFields = true)
class LengthMeasurement implements Comparable<LengthMeasurement> {

    /** The length measured */
    private final Number length

    /** The unitOfLength of measurement */
    private final UnitOfLength unitOfLength

    /**
     *
     * @param length The length value of the measurement
     * @param unitOfLength The unitOfLength of measurement ascribed to the length
     * @throws IllegalArgumentException if length is <= 0
     */
    LengthMeasurement(Number length, UnitOfLength unitOfLength) throws IllegalArgumentException {
        checkMeasurementValueIsPositive(length)
        this.length = length
        this.unitOfLength = unitOfLength
    }

    /**
     *
     * @return the length of the measurement
     */
    public Number getLength() {
        this.length
    }

    /**
     *
     * @return The unitOfLength of measurement in use
     */
    public UnitOfLength getUnitOfLength() {
        this.unitOfLength
    }

    /**
     *
     * @param v The length being checked
     * @return true if all checks succeed, an exception is raised otherwise
     * @throws IllegalArgumentException when v is not valid
     */
    private static Boolean checkMeasurementValueIsPositive(Number v) throws IllegalArgumentException {
        if (v <= 0) {
            throw new IllegalArgumentException('The length must be greater than 0')
        }
        true
    }

    /**
     * Many operations within this class rely on the two Measurement operands being of the same unitOfLength of measurement.
     * No conversions (e.g. mm to inches) are attempted
     * @param m1 A measurement
     * @param m2 Another measurement
     * @return true if all checks succeed, an exception is raised otherwise
     * @throws IllegalArgumentException if m1 and m2 use different units of measurement
     */
    public
    static Boolean checkUnitsOfMeasurementAreTheSame(LengthMeasurement m1, LengthMeasurement m2) throws IllegalArgumentException {
        if (m1.unitOfLength != m2.unitOfLength) {
            throw new IllegalArgumentException('Can only use Measurements with the same unitOfLength of measurement')
        }
        true
    }

    /**
     * Overloads the + operator
     * @param right another measurement
     * @return a new Measurement instance with the length reflecting the operation
     * @throws IllegalArgumentException if the measurements are of different units or if the 'right' parameter is <= 0
     */
    public LengthMeasurement plus(LengthMeasurement right) throws IllegalArgumentException {
        checkUnitsOfMeasurementAreTheSame(this, right)
        this + right.length
    }

    /**
     * Overloads the + operator
     * @param right a length (it is assumed that this is in the same unitOfLength of measurement as the instance)
     * @return a new Measurement instance with the length reflecting the operation
     * @throws IllegalArgumentException if the 'right' parameter is <= 0
     */
    public LengthMeasurement plus(Number right) throws IllegalArgumentException {
        checkMeasurementValueIsPositive(length)
        return new LengthMeasurement(this.length + right, this.unitOfLength)
    }

    /**
     * Overloads the - operator
     * @param right another measurement
     * @return a new Measurement instance with the length reflecting the operation
     * @throws IllegalArgumentException if the measurements are of different units or if the operation results in a
     *      length <= 0
     */
    public LengthMeasurement minus(LengthMeasurement right) throws IllegalArgumentException {
        checkUnitsOfMeasurementAreTheSame(this, right)
        this - right.length
    }

    /**
     * Overloads the - operator
     * @param right a length (it is assumed that this is in the same unitOfLength of measurement as the instance)
     * @return a new Measurement instance with the length reflecting the operation
     * @throws IllegalArgumentException if the operation results in a length <= 0
     */
    public LengthMeasurement minus(Number right) throws IllegalArgumentException {
        checkMeasurementValueIsPositive(length)
        LengthMeasurement result
        try {
            result = new LengthMeasurement(this.length - right, this.unitOfLength)
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException('The resulting measurement length is <=0 and a measurement cannot be negative', e)
        }
        return result
    }

    /**
     * Overloads the / operator
     * @param right the denominator
     * @return a new Measurement instance with the length reflecting the operation
     * @throws IllegalArgumentException if 'right' <= 0
     */
    public LengthMeasurement div(Number right) throws IllegalArgumentException {
        checkMeasurementValueIsPositive(right)
        return new LengthMeasurement((Integer) (this.length / right), this.unitOfLength)
    }

    /**
     * Overloads the * operator
     * @param the multiplier
     * @return a new Measurement instance with the length reflecting the operation
     * @throws IllegalArgumentException if the 'right' parameter is <= 0
     */
    public LengthMeasurement multiply(Number right) throws IllegalArgumentException {
        checkMeasurementValueIsPositive(right)
        return new LengthMeasurement(this.length * right, this.unitOfLength)
    }

    /**
     * Overloads the * operator
     * @param the multiplier
     * @return a new Measurement instance with the length reflecting the operation
     * @throws IllegalArgumentException if the 'right' parameter is <= 0
     */
    public LengthMeasurement multiply(LengthMeasurement right) throws IllegalArgumentException {
        checkUnitsOfMeasurementAreTheSame(this, right)
        this * right.length
    }

    /**
     * Overloads the power(**) operator
     * @param exponent
     * @return a new Measurement instance with the length reflecting the operation
     * @throws IllegalArgumentException if exponent <= 0
     */
    public LengthMeasurement power(Integer exponent) throws IllegalArgumentException {
        if (exponent < 0) {
            throw new IllegalArgumentException('The exponent must be a positive number')
        }
        return new LengthMeasurement(this.length**exponent, this.unitOfLength)
    }

    @Override
    public int compareTo(LengthMeasurement right) throws IllegalArgumentException {
        checkUnitsOfMeasurementAreTheSame(this, right)
        this.length <=> right.length
    }

}
