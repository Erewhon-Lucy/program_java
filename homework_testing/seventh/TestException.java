package homework_testing.seventh;

public class TestException {
    static void validate(double score) throws BadScoreException {
        System.out.println(score);
        if (score < 60) {
            throw new BadScoreException("Did not pass, please redo the exam.");
        }
        System.out.println("Ok, pass.");
    }

    public static void main(String[] args) {
        try {
            validate(59);   //throw an exception
            validate(44);   //didn't throw exception
        }
        catch (Exception e) {
            System.out.println("Exception occur: " + e);
        }
        try {
            validate(90);
        }
        catch (Exception e) {
            System.out.println("Exception occur: " + e);
        }
        finally {
            System.out.println("Finally, good good study, day day up ^_^");
        }
    }
}

class BadScoreException extends Exception {
    BadScoreException(String info) {
        super(info);
    }
}