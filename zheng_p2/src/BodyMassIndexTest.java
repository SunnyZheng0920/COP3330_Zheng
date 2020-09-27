import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {

    // Check if the method calculate correct result of bmi
    @Test
    public void testCalculateBmiResult1() {
        BodyMassIndex test = new BodyMassIndex(50, 110);

        double answer = test.calculateBmiResult();

        assertEquals(30.9, answer);
    }

    @Test
    public void testCalculateBmiResult2() {
        BodyMassIndex test = new BodyMassIndex(68, 170);

        double answer = test.calculateBmiResult();

        assertEquals(25.8, answer);
    }

    @Test
    public void testCalculateBmiResult3() {
        BodyMassIndex test = new BodyMassIndex(65, 170);

        double answer = test.calculateBmiResult();

        assertEquals(28.3, answer);
    }

    @Test
    public void testCalculateBmiResult4() {
        BodyMassIndex test = new BodyMassIndex(60, 170);

        double answer = test.calculateBmiResult();

        assertEquals(33.2, answer);
    }

    // Create 4 tests to test each case
    @Test
    public void testCalculateCategoryUnderweight() {
        BodyMassIndex test = new BodyMassIndex(50, 60);

        String answer = test.calculateCategory();

        assertEquals("Underweight\n",answer);
    }

    @Test
    public void testCalculateCategoryNormalWeight() {
        BodyMassIndex test = new BodyMassIndex(50, 80);

        String answer = test.calculateCategory();

        assertEquals("Normal weight\n",answer);
    }

    @Test
    public void testCalculateCategoryOverweight() {
        BodyMassIndex test = new BodyMassIndex(50, 90);

        String answer = test.calculateCategory();

        assertEquals("Overweight\n",answer);
    }

    @Test
    public void testCalculateCategoryObesity() {
        BodyMassIndex test = new BodyMassIndex(50, 110);

        String answer = test.calculateCategory();

        assertEquals("Obesity\n",answer);
    }

    // Following 2 tests are checking the print out result
    @Test
    public void testDisplayScore() {
        BodyMassIndex test = new BodyMassIndex(50, 110);

        test.displayScore();
    }

    @Test
    public void testDisplayCategoryResult() {
        BodyMassIndex test = new BodyMassIndex(50, 110);

        test.displayCategoryResult();
    }
}