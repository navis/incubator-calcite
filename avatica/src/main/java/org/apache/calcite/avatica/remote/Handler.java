/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.calcite.avatica.remote;

import java.util.Objects;

/**
 * API for text request-response calls to an Avatica server.
 *
 * @param <T> The type this handler accepts and returns
 */
public interface Handler<T> {
  int HTTP_OK = 200;
  int HTTP_INTERNAL_SERVER_ERROR = 500;

  /**
   * Struct that encapsulates the context of the result of a request to Avatica.
   */
  public class HandlerResponse<T> {
    private final T response;
    private final int statusCode;

    public HandlerResponse(T response, int statusCode) {
      this.response = Objects.requireNonNull(response);
      this.statusCode = statusCode;
    }

    public T getResponse() {
      return response;
    }

    public int getStatusCode() {
      return statusCode;
    }
  }

  HandlerResponse<T> apply(T request);
}

// End Handler.java
