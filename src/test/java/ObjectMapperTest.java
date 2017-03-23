import com.github.ilevshevich.mapper.delimited.DelimitedObjectMapper;
import com.github.ilevshevich.mapper.delimited.builder.TextDelimitedBuilder;
import com.github.ilevshevich.mapper.delimited.strategy.TextDelimitedStrategy;
import model.DelimitedModelTest;
import org.junit.Test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class ObjectMapperTest {
    private static final String TEST_DELIMITER = "|";
    private static final long CURRENT_TIME_MILLIS = System.currentTimeMillis();
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat DATE_FORMAT_ISO = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

    @Test
    public void testMapper1() throws Exception {
        final String testLine = getTestLine();
        assertNotNull(testLine);
        assertFalse(testLine.isEmpty());

        final List<String> testData = Collections.singletonList(testLine);
        assertNotNull(testData);
        assertFalse(testData.isEmpty());

        final DelimitedObjectMapper<String, DelimitedModelTest> mapper = new TextDelimitedBuilder<DelimitedModelTest>()
                .clazz(DelimitedModelTest.class)
                .instance(DelimitedModelTest::new)
                .split((line, delimiter) -> Arrays.asList(line.split(Pattern.quote(delimiter), -1)))
                .strategy(new TextDelimitedStrategy<>())
                .build();
        assertNotNull(mapper);

        final List<DelimitedModelTest> testResult = mapper.map(testData);
        assertNotNull(testResult);
        assertFalse(testResult.isEmpty());

        final DelimitedModelTest testModel = testResult.get(0);
        assertNotNull(testModel);
        {
            validateTestModel(testModel);
        }
    }

    @Test
    public void testMapper2() throws Exception {
        final List<String> testData = null;
        final DelimitedObjectMapper<String, DelimitedModelTest> mapper = new TextDelimitedBuilder<DelimitedModelTest>()
                .clazz(DelimitedModelTest.class)
                .instance(() -> null)
                .split((line, delimiter) -> null)
                .strategy(new TextDelimitedStrategy<>())
                .build();
        assertNotNull(mapper);

        final List<DelimitedModelTest> testResult = mapper.map(testData);
        assertNotNull(testResult);
        assertTrue(testResult.isEmpty());
    }

    @Test
    public void testMapper3() throws Exception {
        final List<String> testData = new LinkedList<>();
        final DelimitedObjectMapper<String, DelimitedModelTest> mapper = new TextDelimitedBuilder<DelimitedModelTest>()
                .clazz(DelimitedModelTest.class)
                .instance(() -> null)
                .split((line, delimiter) -> null)
                .strategy(new TextDelimitedStrategy<>())
                .build();
        assertNotNull(mapper);

        final List<DelimitedModelTest> testResult = mapper.map(testData);
        assertNotNull(testResult);
        assertTrue(testResult.isEmpty());
    }

    private void validateTestModel(final DelimitedModelTest model) {
        final BigDecimal _0 = model.get_0();
        assertNotNull(_0);
        assertTrue(_0.toString().equals("0.12"));

        final BigInteger _1 = model.get_1();
        assertNotNull(_1);
        assertTrue(_1.toString().equals("123456789"));

        final Boolean _2 = model.get_2();
        assertNotNull(_2);
        assertTrue(_2.toString().equals("true"));

        final Date _3 = model.get_3();
        assertNotNull(_3);
        assertTrue(DATE_FORMAT.format(_3).equals(DATE_FORMAT.format(CURRENT_TIME_MILLIS)));

        final Double _4 = model.get_4();
        assertNotNull(_4);
        assertTrue(_4.toString().equals("4.12"));

        final Float _5 = model.get_5();
        assertNotNull(_5);
        assertTrue(_5.toString().equals("5.12"));

        final Integer _6 = model.get_6();
        assertNotNull(_6);
        assertTrue(_6.toString().equals("6789"));

        final Long _7 = model.get_7();
        assertNotNull(_7);
        assertTrue(_7.toString().equals("789"));

        final String _8 = model.get_8();
        assertNotNull(_8);
        assertTrue(_8.equals("abc"));

        final BigDecimal _9 = model.get_9();
        assertNotNull(_9);
        assertTrue(_9.toString().equals("9.1235"));

        final Double _10 = model.get_10();
        assertNotNull(_10);
        assertTrue(_10.toString().equals("10.1235"));

        final Float _11 = model.get_11();
        assertNotNull(_11);
        assertTrue(_11.toString().equals("11.1235"));

        final BigDecimal _12 = model.get_12();
        assertNotNull(_12);
        assertTrue(_12.toString().equals("12.1234"));

        final Double _13 = model.get_13();
        assertNotNull(_13);
        assertTrue(_13.toString().equals("13.1234"));

        final Float _14 = model.get_14();
        assertNotNull(_14);
        assertTrue(_14.toString().equals("14.1234"));

        final Integer _15 = model.get_15();
        assertNotNull(_15);
        assertTrue(_15.toString().equals("15"));

        final Date _16 = model.get_16();
        assertNotNull(_16);
        assertTrue(DATE_FORMAT_ISO.format(_16).equals(DATE_FORMAT_ISO.format(CURRENT_TIME_MILLIS)));

        final Integer _17 = model.get_17();
        assertNull(_17);
    }

    private String getTestLine() throws ParseException {
        final StringBuilder builder = new StringBuilder();
        assertNotNull(builder);
        {
            builder.append("0.123456789").append(TEST_DELIMITER);
            builder.append("123456789").append(TEST_DELIMITER);
            builder.append("true").append(TEST_DELIMITER);
            builder.append(DATE_FORMAT.format(CURRENT_TIME_MILLIS)).append(TEST_DELIMITER);
            builder.append("4.123456789").append(TEST_DELIMITER);
            builder.append("5.123456789").append(TEST_DELIMITER);
            builder.append("6789").append(TEST_DELIMITER);
            builder.append("789").append(TEST_DELIMITER);
            builder.append("abc").append(TEST_DELIMITER);
            builder.append("9.123456789").append(TEST_DELIMITER);
            builder.append("10.123456789").append(TEST_DELIMITER);
            builder.append("11.123456789").append(TEST_DELIMITER);
            builder.append("12.123456789").append(TEST_DELIMITER);
            builder.append("13.123456789").append(TEST_DELIMITER);
            builder.append("14.123456789").append(TEST_DELIMITER);
            builder.append("15").append(TEST_DELIMITER);
            builder.append(DATE_FORMAT_ISO.format(CURRENT_TIME_MILLIS)).append(TEST_DELIMITER);
        }
        return builder.toString();
    }
}
