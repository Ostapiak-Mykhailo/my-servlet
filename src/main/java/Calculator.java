public class Calculator {

    public double findResult(String option, String first, String second){

        return switch (option){
            case "add" -> add(first, second);
            case "subtract" -> subtract(first, second);
            case "multiply" -> multiply(first, second);
            case "divide" -> divide(first, second);
            default -> throw new IllegalArgumentException("unknown operation " + option);
        };
    }

    private int add(String first, String second) {
        int firstNumber = parse(first);
        int secondNumber = parse(second);
        return firstNumber + secondNumber;
    }

    private int subtract(String first, String second) {
        int firstNumber = parse(first);
        int secondNumber = parse(second);
        return firstNumber - secondNumber;
    }

    private int multiply(String first, String second) {
        int firstNumber = parse(first);
        int secondNumber = parse(second);
        return firstNumber * secondNumber;
    }

    private double divide(String first, String second) {
        int firstNumber = parse(first);
        int secondNumber = parse(second);
        return (double) firstNumber / secondNumber;
    }

    private int parse(String string){
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input");
            return 0;
        }
    }

}
