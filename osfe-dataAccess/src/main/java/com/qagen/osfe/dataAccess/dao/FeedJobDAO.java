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
package com.qagen.osfe.dataAccess.dao;

import com.qagen.osfe.dataAccess.param.LimitParam;
import com.qagen.osfe.dataAccess.vo.FeedJob;

import java.util.List;

public interface FeedJobDAO extends DAO<FeedJob> {

  public List<FeedJob> findByFeedJobStateId(String stateId);

  public List<FeedJob> findByActiveFailedJobStateId();

  public List<FeedJob> findByActiveFailedJobStateIdWithLimit(LimitParam limitParam);

  public List<FeedJob> findByFeedFileId(Integer feedFileId);
}
