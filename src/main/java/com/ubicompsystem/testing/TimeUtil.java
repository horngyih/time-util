package com.ubicompsystem.testing;

import java.sql.Timestamp;

public final class TimeUtil {

    public static Rounding round( long target ){
        return new Rounding(target);
    }

    public static TimestampRounding round( Timestamp time ){
        return new TimestampRounding(time);
    }

    public static class TimestampRounding {
        Rounding rounding;

        public TimestampRounding( Timestamp time ){
            this.rounding = new Rounding(time.getTime());
        }

        public Timestamp toNearestMillisecond( long interval ){
            return new Timestamp(this.rounding.toNearest(interval));
        }

        public Timestamp toNearestSecond( long interval ){
            return new Timestamp(this.rounding.toNearest(interval * 1000));
        }
    }

    public static class Rounding {

        long target;

        public Rounding( long value ){
            target = value;
        }

        public Long toNearest( long interval ){
            if( target > 0 ){
                return target - ( target % interval );
            } else {
                return target - ( target % interval );
            }
        }

    }


}
