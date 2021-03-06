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
 * This is the value object class for table t_feed_group
 *
 * @table t_feed_group
 */
public class FeedGroup extends VO {
    private String feedGroupId;
    private boolean allowConcurrentRuns;
    private boolean allowFailedStateRuns;
    private boolean collectPhaseStats;

    public String getFeedGroupId() {
        return feedGroupId;
    }

    public void setFeedGroupId(String feedGroupId) {
        this.feedGroupId = feedGroupId;
    }

    public boolean isAllowConcurrentRuns() {
        return allowConcurrentRuns;
    }

    public void setAllowConcurrentRuns(boolean allowConcurrentRuns) {
        this.allowConcurrentRuns = allowConcurrentRuns;
    }

    public boolean isAllowFailedStateRuns() {
        return allowFailedStateRuns;
    }

    public void setAllowFailedStateRuns(boolean allowFailedStateRuns) {
        this.allowFailedStateRuns = allowFailedStateRuns;
    }

    public boolean isCollectPhaseStats() {
        return collectPhaseStats;
    }

    public void setCollectPhaseStats(boolean collectPhaseStats) {
        this.collectPhaseStats = collectPhaseStats;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof FeedGroup)) {
            return false;
        }

        final FeedGroup model = (FeedGroup) object;
        if (feedGroupId.equals(model.feedGroupId)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder(17, 37);
        builder.append(feedGroupId);
        return builder.toHashCode();
    }

    @Override
    public String toString() {
        final List<String> list = new ArrayList<String>();

        list.add(feedGroupId.toString());

        return toString(list);
    }
}
