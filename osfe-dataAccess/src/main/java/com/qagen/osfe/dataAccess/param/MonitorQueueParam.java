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
package com.qagen.osfe.dataAccess.param;

/**
 * Author: Hycel Taylor
 * <p>
 * 
 */
public class MonitorQueueParam {
  private final String monitorId;
  private final String queueId;

  public MonitorQueueParam(String monitorId, String queueId) {
    this.monitorId = monitorId;
    this.queueId = queueId;
  }

  public String getMonitorId() {
    return monitorId;
  }

  public String getQueueId() {
    return queueId;
  }
}
