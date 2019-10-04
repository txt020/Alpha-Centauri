public class Calculations {
    private double FirstNumber;
    private double SecondNumer;

    public double getSecondNumer() {
        return SecondNumer;
    }

    public void setSecondNumer(double secondNumer) {
        SecondNumer = secondNumer;
    }

    public double getFirstNumber() {
        return FirstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        FirstNumber = firstNumber;
    }

    public double getAdditionResult(){
        return this.FirstNumber + this.SecondNumer;

    }

    public double getSubtractionResult(){
        return this.FirstNumber - this.SecondNumer;
    }

    public double getMultiplicationResult(){
        return this.FirstNumber * this.SecondNumer;

    }

    public double getDivisionResult(){
        if(this.SecondNumer == 0)
            return 0;
        else
            return this.FirstNumber / this.SecondNumer;
    }
}
