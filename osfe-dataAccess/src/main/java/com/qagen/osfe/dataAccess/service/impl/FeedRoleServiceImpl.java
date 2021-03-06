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
package com.qagen.osfe.dataAccess.service.impl;

import com.qagen.osfe.dataAccess.dao.FeedRoleDAO;
import com.qagen.osfe.dataAccess.service.FeedRoleService;
import com.qagen.osfe.dataAccess.vo.FeedRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class FeedRoleServiceImpl implements FeedRoleService {
  private FeedRoleDAO feedRoleDAO;

  public void setFeedRoleDAO(FeedRoleDAO feedRoleDAO) {
    this.feedRoleDAO = feedRoleDAO;
  }

  @Transactional
  public void insert(FeedRole model) {
    feedRoleDAO.insert(model);
  }

  @Transactional
  public void update(FeedRole model) {
    feedRoleDAO.update(model);
  }

  @Transactional
  public void delete(FeedRole model) {
    feedRoleDAO.delete(model);
  }

  @Transactional
  public FeedRole findByPrimaryId(Integer primaryId) {
    return feedRoleDAO.findByPrimaryId(primaryId);
  }

  @Transactional
  public List<FeedRole> findAll() {
    return feedRoleDAO.findAll();
  }
}