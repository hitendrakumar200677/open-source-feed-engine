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

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Hycel Taylor
 * <p/>
 * This is the value object class for table t_feed
 *
 * @table t_feed
 */
public class Feed extends VO {
  private String feedId;
  private Timestamp activationDate;
  private Timestamp terminationDate;
  private boolean allowConcurrentRuns;
  private boolean allowFailedStateRuns;
  private boolean restartAtCheckpoint;
  private boolean collectPhaseStats;
  private Integer nextSequenceNumber;
  private Integer maxConcurrentRuns;
  private String feedDirectory;
  private String feedDocument;
  private FeedDataSource fromDataSource;
  private FeedDataSource toDataSource;
  private FeedType feedType;
  private FeedProtocol feedProtocol;
  private FeedDirection feedDirection;
  private FeedGroup feedGroup;

  public Feed() {
  }

  public String getFeedId() {
    return feedId;
  }

  public void setFeedId(String feedId) {
    this.feedId = feedId;
  }

  public Timestamp getActivationDate() {
    return activationDate;
  }

  public void setActivationDate(Timestamp activationDate) {
    this.activationDate = activationDate;
  }

  public Timestamp getTerminationDate() {
    return terminationDate;
  }

  public void setTerminationDate(Timestamp terminationDate) {
    this.terminationDate = terminationDate;
  }

  public Boolean getAllowConcurrentRuns() {
    return allowConcurrentRuns;
  }

  public void setAllowConcurrentRuns(Boolean allowConcurrentRuns) {
    this.allowConcurrentRuns = allowConcurrentRuns;
  }

  public Boolean getAllowFailedStateRuns() {
    return allowFailedStateRuns;
  }

  public void setAllowFailedStateRuns(Boolean allowFailedStateRuns) {
    this.allowFailedStateRuns = allowFailedStateRuns;
  }

  public Boolean getRestartAtCheckpoint() {
    return restartAtCheckpoint;
  }

  public void setRestartAtCheckpoint(Boolean restartAtCheckpoint) {
    this.restartAtCheckpoint = restartAtCheckpoint;
  }

  public Boolean getCollectPhaseStats() {
    return collectPhaseStats;
  }

  public void setCollectPhaseStats(Boolean collectPhaseStats) {
    this.collectPhaseStats = collectPhaseStats;
  }

  public Integer getNextSequenceNumber() {
    return nextSequenceNumber;
  }

  public void setNextSequenceNumber(Integer nextSequenceNumber) {
    this.nextSequenceNumber = nextSequenceNumber;
  }

  public Integer getMaxConcurrentRuns() {
    return maxConcurrentRuns;
  }

  public void setMaxConcurrentRuns(Integer maxConcurrentRuns) {
    this.maxConcurrentRuns = maxConcurrentRuns;
  }

  public String getFeedDirectory() {
    return feedDirectory;
  }

  public void setFeedDirectory(String feedDirectory) {
    this.feedDirectory = feedDirectory;
  }

  public String getFeedDocument() {
    return feedDocument;
  }

  public void setFeedDocument(String feedDocument) {
    this.feedDocument = feedDocument;
  }

  public FeedDataSource getFromDataSource() {
    return fromDataSource;
  }

  public void setFromDataSource(FeedDataSource fromDataSource) {
    this.fromDataSource = fromDataSource;
  }

  public FeedDataSource getToDataSource() {
    return toDataSource;
  }

  public void setToDataSource(FeedDataSource toDataSource) {
    this.toDataSource = toDataSource;
  }

  public FeedType getFeedType() {
    return feedType;
  }

  public void setFeedType(FeedType feedType) {
    this.feedType = feedType;
  }

  public FeedProtocol getFeedProtocol() {
    return feedProtocol;
  }

  public void setFeedProtocol(FeedProtocol feedProtocol) {
    this.feedProtocol = feedProtocol;
  }

  public FeedDirection getFeedDirection() {
    return feedDirection;
  }

  public void setFeedDirection(FeedDirection feedDirection) {
    this.feedDirection = feedDirection;
  }

  public FeedGroup getFeedGroup() {
    return feedGroup;
  }

  public void setFeedGroup(FeedGroup feedGroup) {
    this.feedGroup = feedGroup;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }

    if (!(object instanceof Feed)) {
      return false;
    }

    final Feed model = (Feed) object;
    return feedId.equals(model.feedId);
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder(17, 37);
    builder.append(feedId);
    return builder.toHashCode();
  }

  @Override
  public String toString() {
    final List<String> list = new ArrayList<String>();

    list.add(feedId);

    return toString(list);
  }
}
