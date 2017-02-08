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

import com.commercehub.sensu.api.exceptions.SensuErrorException;
import com.commercehub.sensu.api.exceptions.SensuMalformedDataException;
import com.commercehub.sensu.api.exceptions.SensuNotAuthorizedException;
import com.commercehub.sensu.api.exceptions.SensuNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

class SensuErrorDecoder implements ErrorDecoder {
    private static final int NOT_AUTHORIZED = 401;
    private static final int NOT_FOUND = 404;
    private static final int MALFORMED = 400;

    @Override
    public Exception decode(String methodKey, Response response) {
        String message = String.format("status %s reading %s", response.status(), methodKey);
        switch (response.status()) {
            case NOT_AUTHORIZED: return new SensuNotAuthorizedException(message);
            case NOT_FOUND: return new SensuNotFoundException(message);
            case MALFORMED: return new SensuMalformedDataException(message);
            default: return new SensuErrorException(message);
        }
    }
}
