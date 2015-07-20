package com.github.groovyguides.shapes.measurement

import com.github.groovyguides.shapes.util.Messages
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
class LengthMeasurement implements Comparable<LengthMeasurement>, Cloneable {

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
    LengthMeasurement(Number length, UnitOfLength unitOfLength) throws LengthNotPositiveException {
        if (!checkMeasurementValueIsPositive(length)){
            throw new LengthNotPositiveException()
        }
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
     */
    private static Boolean checkMeasurementValueIsPositive(Number v) {
        return v > 0
    }

    /**
     * Many operations within this class rely on the two Measurement operands being of the same unitOfLength of measurement.
     * No conversions (e.g. mm to inches) are attempted
     * @param measurements A series of measurements
     * @return true if all checks succeed, an exception is raised otherwise
     */
    public
    static Boolean checkUnitsOfMeasurementAreTheSame(LengthMeasurement ...measurements) {
        if (measurements.size() <= 1) {
            true
        }
        UnitOfLength lastUoL = null
        for (m in measurements) {
            if (!lastUoL) {
                lastUoL = m.getUnitOfLength()
                continue
            }
            if (m.unitOfLength != lastUoL) {
                return false
            }
        }
        true
    }

    /**
     * Overloads the + operator
     * @param right another measurement
     * @return a new Measurement instance with the length reflecting the operation
     * @throws IllegalArgumentException if the measurements are of different units or if the 'right' parameter is <= 0
     */
    public LengthMeasurement plus(LengthMeasurement right) throws SameUoLRequiredException {
        if (!checkUnitsOfMeasurementAreTheSame(this, right)) {
            throw new SameUoLRequiredException()
        }
        this + right.length
    }

    /**
     * Overloads the + operator
     * @param right a length (it is assumed that this is in the same unitOfLength of measurement as the instance)
     * @return a new Measurement instance with the length reflecting the operation
     * @throws IllegalArgumentException if the 'right' parameter is <= 0
     */
    public LengthMeasurement plus(Number right) throws LengthNotPositiveException {
        if (!checkMeasurementValueIsPositive(right)) {
            throw new LengthNotPositiveException()
        }
        return new LengthMeasurement(this.length + right, this.unitOfLength)
    }

    /**
     * Overloads the - operator
     * @param right another measurement
     * @return a new Measurement instance with the length reflecting the operation
     * @throws IllegalArgumentException if the measurements are of different units or if the operation results in a
     *      length <= 0
     */
    public LengthMeasurement minus(LengthMeasurement right)
            throws SameUoLRequiredException, LengthNotPositiveException {
        if (!checkUnitsOfMeasurementAreTheSame(this, right)) {
            throw new SameUoLRequiredException()
        }
        this - right.length
    }

    /**
     * Overloads the - operator
     * @param right a length (it is assumed that this is in the same unitOfLength of measurement as the instance)
     * @return a new Measurement instance with the length reflecting the operation
     * @throws IllegalArgumentException if the operation results in a length <= 0
     */
    public LengthMeasurement minus(Number right) throws LengthNotPositiveException {
        if (!checkMeasurementValueIsPositive(right)) {
            throw new LengthNotPositiveException()
        }
        return new LengthMeasurement(this.length - right, this.unitOfLength)
    }

    /**
     * Overloads the / operator
     * @param right the denominator
     * @return a new Measurement instance with the length reflecting the operation
     * @throws IllegalArgumentException if 'right' <= 0
     */
    public LengthMeasurement div(Number right) throws LengthNotPositiveException {
        if (!checkMeasurementValueIsPositive(right)) {
            throw new LengthNotPositiveException()
        }
        return new LengthMeasurement((Integer) (this.length / right), this.unitOfLength)
    }

    /**
     * Overloads the * operator
     * @param the multiplier
     * @return a new Measurement instance with the length reflecting the operation
     * @throws IllegalArgumentException if the 'right' parameter is <= 0
     */
    public LengthMeasurement multiply(Number right) throws LengthNotPositiveException {
        if (!checkMeasurementValueIsPositive(right)) {
            throw new LengthNotPositiveException()
        }
        return new LengthMeasurement(this.length * right, this.unitOfLength)
    }

    /**
     * Overloads the * operator
     * @param the multiplier
     * @return a new Measurement instance with the length reflecting the operation
     * @throws IllegalArgumentException if the 'right' parameter is <= 0
     */
    public LengthMeasurement multiply(LengthMeasurement right) throws SameUoLRequiredException {
        if (!checkUnitsOfMeasurementAreTheSame(this, right)) {
            throw new SameUoLRequiredException()
        }

        this * right.length
    }

    /**
     * Overloads the power(**) operator
     * @param exponent
     * @return a new Measurement instance with the length reflecting the operation
     * @throws IllegalArgumentException if exponent <= 0
     */
    public LengthMeasurement power(Integer exponent) throws NonPositiveExponentException, LengthNotPositiveException {
        if (exponent < 0) {
            throw new NonPositiveExponentException()
        }
        return new LengthMeasurement(this.length**exponent, this.unitOfLength)
    }

    @Override
    public int compareTo(LengthMeasurement right) throws SameUoLRequiredException {
        if (!checkUnitsOfMeasurementAreTheSame(this, right)) {
            throw new SameUoLRequiredException()
        }

        this.length <=> right.length
    }

    public static LengthMeasurement sqrt(LengthMeasurement m) {
        return new LengthMeasurement(Math.sqrt(m.length.toDouble()), m.unitOfLength)
    }

    @Override
    protected LengthMeasurement clone() throws CloneNotSupportedException {
        return new LengthMeasurement(this.length, this.unitOfLength)
    }

    class NonPositiveExponentException extends IllegalArgumentException {
        public static final String NON_POSITIVE_EXPONENT = Messages.getString('NonPositiveExponentException.message')
        NonPositiveExponentException() {
            super(NON_POSITIVE_EXPONENT)
        }

        NonPositiveExponentException(String message) {
            super(message)
        }

        NonPositiveExponentException(String message, Throwable cause) {
            super(message, cause)
        }

        NonPositiveExponentException(Throwable cause) {
            super(NON_POSITIVE_EXPONENT, cause)
        }
    }
}
