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
            Timestamp quantumNow = round(now).toNearestMillisecond(quantum);
            Timestamp secondQuantumNow = round(now).toNearestSecond(secondQuantum);
            System.out.printf( "%-24s -> %-24s : Time Period (%6d ms) %n", now, quantumNow, quantum );
            System.out.printf( "%-24s -> %-24s : Time Period (%6d s ) %n", now, secondQuantumNow, secondQuantum );
            try{
                Thread.sleep(1000);
            } catch( InterruptedException irEx ){
                System.err.println( "Interrupted" );
            }
        }
    }

}
