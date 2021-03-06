/* Copyright 2008 Hycel Taylor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qagen.osfe.core;

/**
 * Author: Hycel Taylor
 * <p/>
 * As it concerns OSFE, this interface should be implemented by concrete classes
 * that extend EngineService and need to handle special exceptions. OSFE will
 * pass the exception on to the custom exception handler before it does it's
 * own exception handling and fails the given feed.
 */
public abstract class ExceptionService extends EngineService {

  /**
   * Constructor
   */
  protected ExceptionService() {
  }

  /**
   * Set the reference to the exception and performs the necessary operations
   * to handle the given exception.
   *
   * @param exception the exception to handle.
   */
  public abstract void handleException(Exception exception);

}
