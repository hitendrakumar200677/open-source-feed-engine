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
 * Author: Gregg Bolinger & Hycel Taylor
 * <p/>
 */
public class FeedFileFilterParam {

  private String feedFileStateId;
  private String feedFileDate;
  private String feedId;
  private Integer sequenceNumber;

  public FeedFileFilterParam(String feedFileStateId, String feedFileDate) {
    this.feedFileStateId = feedFileStateId;
    this.feedFileDate = feedFileDate;
  }

  public FeedFileFilterParam(String feedId, Integer sequenceNumber) {
    this.feedId = feedId;
    this.sequenceNumber = sequenceNumber;
  }

  public String getFeedFileStateId() {
    return feedFileStateId;
  }

  public String getFeedFileDate() {
    return feedFileDate;
  }

  public String getFeedId() {
    return feedId;
  }

  public Integer getSequenceNumber() {
    return sequenceNumber;
  }
}
