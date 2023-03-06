package uk.ac.rgu.cm2116;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ParserTest {

    @Test
    public void testValidParserInput(){

        Parser parser = new Parser();
        String input = "(hello (world))";
        boolean result = parser.parse(input);

        assertTrue(result);
    }

    @Test
    public void testParserInvalidInput(){
        Parser parser = new Parser();
        String input = "(hello (world)";
        boolean result = parser.parse(input);

        assertFalse(result);

        input = "hello world)";
        result = parser.parse(input);

        assertFalse(result);
    }
    
}
