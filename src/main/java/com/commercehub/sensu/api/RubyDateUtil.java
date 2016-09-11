/*
 * Copyright (C) 2016 Commerce Technologies, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
