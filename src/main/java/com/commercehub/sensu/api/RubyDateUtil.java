package com.commercehub.sensu.api;

import java.util.Date;

/**
 * Utility for converting Ruby Time values to/from Java Dates.  Both are based on the Unix Epoch, but Ruby uses "seconds since" and Java
 * uses "milliseconds since".
 *
 * @see <a href="http://www.ruby-doc.org/core-2.1.1/Time.html">Ruby Time</a>
 */
public class RubyDateUtil {
    private static final long MILLISECONDS_PER_SECOND = 1000L;

    /**
     * Converts a Ruby time (seconds since epoch) to a Java Date.
     *
     * @param rubyTime a Ruby time (seconds since epoch)
     * @return the corresponding Java Date
     */
    public static Date toJavaDate(int rubyTime) {
        return new Date((long) rubyTime * MILLISECONDS_PER_SECOND);
    }

    /**
     * Converts a Java Date to a Ruby time (seconds since epoch).
     *
     * @param javaDate a Java Date
     * @return the corresponding Ruby time (second since epoch)
     */
    public static int toRubyTime(Date javaDate) {
        return (int) (javaDate.getTime() / MILLISECONDS_PER_SECOND);
    }
}
