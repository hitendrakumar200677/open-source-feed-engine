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
package com.qagen.osfe.dataAccess.vo;

import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Hycel Taylor
 * <p/>
 * This is the value object class for table t_feed_job_state
 *
 * @table t_feed_job_state
 */
public class FeedJobState extends VO {
  private String feedJobStateId;
  private String description;

  public FeedJobState() {
  }

  public FeedJobState(String feedJobStateId) {
    this.feedJobStateId = feedJobStateId;
  }

  public String getFeedJobStateId() {
    return feedJobStateId;
  }

  public void setFeedJobStateId(String feedJobStateId) {
    this.feedJobStateId = feedJobStateId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }

    if (!(object instanceof FeedJobState)) {
      return false;
    }

    final FeedJobState model = (FeedJobState) object;
    if (feedJobStateId.equals(model.feedJobStateId)) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder(17, 37);
    builder.append(feedJobStateId);
    return builder.toHashCode();
  }

  @Override
  public String toString() {
    final List<String> list = new ArrayList<String>();

    list.add(feedJobStateId);

    return toString(list);
  }
}
