package com.trader;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
//        assertTrue( true );
//        LocalDateTime now = LocalDateTime.now();
//        String shortDate = now.toLocalDate().toString();
//        LocalDateTime amStart = LocalDateTime.parse(String.format("%s 09:30", shortDate), formatter);
//        LocalDateTime amEnd = LocalDateTime.parse(String.format("%s 11:30", shortDate), formatter);
//        LocalDateTime pmStart = LocalDateTime.parse(String.format("%s 13:00", shortDate), formatter);
//        LocalDateTime pmEnd = LocalDateTime.parse(String.format("%s 15:00", shortDate),formatter);
//
//        if(now.compareTo(amStart) >=0 && now.compareTo(amEnd) <= 0) {
//           System.out.println("hello,world.");
//        }
//        String command = "display notification \"Hello, world\" with title \"Hello\" subtitle \"world\"";
//        String command = "display notification \"Hello, world\" with title \"Hello\" sound name \"default\"";
//        Runtime runtime = Runtime.getRuntime();
//        try {
//            runtime.exec(new String[] {"osascript","-e", command});
//            //Runtime.getRuntime().exec(new String[] { "osascript", "-e", "display notification "This is a message" with title "Title" subtitle "Subtitle" sound name "Funk"" });
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Double a1 = 0.05;
        Double a2 = 0.04;
        Double a3 = a1 - a2;

        BigDecimal b1 = BigDecimal.valueOf(0.05);
        BigDecimal b2 = BigDecimal.valueOf(0.04);
        BigDecimal b3 = b1.subtract(b2);

        if(a3.compareTo(0.01) > 0) {
            System.out.println("ok....");
        }

        if(b3.compareTo(BigDecimal.valueOf(0.01)) > 0) {
            System.out.println("should not execute here....");
        }





    }
}
