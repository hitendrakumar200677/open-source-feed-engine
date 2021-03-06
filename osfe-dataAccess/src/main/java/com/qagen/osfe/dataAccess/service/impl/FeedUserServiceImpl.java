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

import com.qagen.osfe.dataAccess.dao.FeedUserDAO;
import com.qagen.osfe.dataAccess.service.FeedUserService;
import com.qagen.osfe.dataAccess.vo.FeedUser;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class FeedUserServiceImpl implements FeedUserService {
  private FeedUserDAO feedUserDAO;

  public void setFeedUserDAO(FeedUserDAO feedUserDAO) {
    this.feedUserDAO = feedUserDAO;
  }

  @Transactional
  public void insert(FeedUser model) {
    feedUserDAO.insert(model);
  }

  @Transactional
  public void update(FeedUser model) {
    feedUserDAO.update(model);
  }

  @Transactional
  public void delete(FeedUser model) {
    feedUserDAO.delete(model);
  }

  @Transactional
  public FeedUser findByPrimaryId(Integer primaryId) {
    return feedUserDAO.findByPrimaryId(primaryId);
  }

  @Transactional
  public List<FeedUser> findAll() {
    return feedUserDAO.findAll();
  }

  @Transactional
  public FeedUser authenticateFeedUser(FeedUser feedUser) {
    return feedUserDAO.findByUsernameAndPassword(feedUser);
  }
}