package com.ubicompsystem.testing;

import static com.ubicompsystem.testing.TimeUtil.*;
import java.sql.Timestamp;
import org.junit.Test;

public class TimePeriodTest {


    @Test
    public void timePeriodTest(){

        int quantum = 30000;
        int secondQuantum = 5;
        for( int i = 0; i < 100; i++ ){
            Timestamp now = new Timestamp(System.currentTimeMillis());
            Timestamp quantumNow = roundTo(now).nearestMillisecond(quantum);
            Timestamp secondQuantumNow = roundTo(now).nearestSecond(secondQuantum);
            System.out.printf( "%s24 -> %24s : Time Period (%d ms) %n", now, quantumNow, quantum );
            System.out.printf( "%s24 -> %24s : Time Period (%d s) %n", now, secondQuantumNow, secondQuantum );
            try{
                Thread.sleep(1000);
            } catch( InterruptedException irEx ){
                System.err.println( "Interrupted" );
            }
        }
    }

}
