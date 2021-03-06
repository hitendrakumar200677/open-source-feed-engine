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
package com.qagen.osfe.core.utils;

import com.qagen.osfe.core.FeedErrorException;

/**
 * Created by IntelliJ IDEA.
 * User: htaylor
 * Date: Aug 9, 2008
 * Time: 3:25:55 PM
 */
public class CheckNullUtil {

  public static void checkNull(Object object, String name) {
    if (object == null) {
      final String message =
        "Unable to object for value, " + name + ". This will result in a null pointer exception without a good stack trace.";
      throw new FeedErrorException(message);
    }
  }
}
