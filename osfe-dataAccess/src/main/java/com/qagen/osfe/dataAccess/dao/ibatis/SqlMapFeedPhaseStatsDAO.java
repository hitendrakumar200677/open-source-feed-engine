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
package com.qagen.osfe.dataAccess.dao.ibatis;

import com.qagen.osfe.dataAccess.dao.FeedPhaseStatsDAO;
import com.qagen.osfe.dataAccess.vo.FeedPhaseStats;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.util.List;

public class SqlMapFeedPhaseStatsDAO extends SqlMapClientDaoSupport implements FeedPhaseStatsDAO {

  public void insert(FeedPhaseStats model) {
    getSqlMapClientTemplate().insert("FeedPhaseStats.insert", model);
  }

  public void update(FeedPhaseStats model) {
    getSqlMapClientTemplate().update("FeedPhaseStats.update", model);
  }

  public void delete(FeedPhaseStats model) {
    getSqlMapClientTemplate().delete("FeedPhaseStats.delete", model);
  }

  public FeedPhaseStats findByPrimaryId(Object primaryId) {
    return (FeedPhaseStats) getSqlMapClientTemplate().queryForObject("FeedPhaseStats.findByPrimaryId", primaryId);
  }

  @SuppressWarnings("unchecked")
  public List<FeedPhaseStats> findByFeedFileId(Integer feedFileId) {
    return getSqlMapClientTemplate().queryForList("FeedPhaseStats.findByFeedFileId", feedFileId);
  }
}