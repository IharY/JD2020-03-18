package by.it.novikov.calc;

class Scalar extends Var {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar other) {
        this.value = other.value;
    }

    Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            double result = value + otherValue;
            return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            double result = value - otherValue;
            return new Scalar(result);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            double result = value * otherValue;
            return new Scalar(result);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            if (otherValue != 0) {
                double result = value / otherValue;
                return new Scalar(result);
            }
            else
                throw new CalcException("divide by zero");
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}