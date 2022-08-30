package com.ubicompsystem.testing;

import java.sql.Timestamp;

public final class TimeUtil {

    public static Rounding roundTo( long target ){
        return new Rounding(target);
    }

    public static TimestampRounding roundTo( Timestamp time ){
        return new TimestampRounding(time);
    }

    public static class TimestampRounding {
        Rounding rounding;

        public TimestampRounding( Timestamp time ){
            this.rounding = new Rounding(time.getTime());
        }

        public Timestamp nearestMillisecond( long interval ){
            return new Timestamp(this.rounding.nearest(interval));
        }

        public Timestamp nearestSecond( long interval ){
            return new Timestamp(this.rounding.nearest(interval * 1000));
        }
    }

    public static class Rounding {

        long target;

        public Rounding( long value ){
            target = value;
        }

        public Long nearest( long interval ){
            if( target > 0 ){
                return target - ( target % interval );
            } else {
                return target - ( target % interval );
            }
        }

    }


}
