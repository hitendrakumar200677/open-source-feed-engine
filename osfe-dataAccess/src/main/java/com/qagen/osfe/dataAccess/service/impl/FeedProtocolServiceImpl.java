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

import com.qagen.osfe.dataAccess.dao.FeedProtocolDAO;
import com.qagen.osfe.dataAccess.service.FeedProtocolService;
import com.qagen.osfe.dataAccess.vo.FeedProtocol;
import com.qagen.osfe.dataAccess.param.LimitParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class FeedProtocolServiceImpl implements FeedProtocolService {
    private FeedProtocolDAO feedProtocolDAO;

    public void setFeedProtocolDAO(FeedProtocolDAO feedProtocolDAO) {
        this.feedProtocolDAO = feedProtocolDAO;
    }

    @Transactional
    public void insert(FeedProtocol model) {
        feedProtocolDAO.insert(model);
    }

    @Transactional
    public void update(FeedProtocol model) {
        feedProtocolDAO.update(model);
    }

    @Transactional
    public void delete(FeedProtocol model) {
        feedProtocolDAO.delete(model);
    }

    @Transactional
    public FeedProtocol findByPrimaryId(String primaryId) {
        return feedProtocolDAO.findByPrimaryId(primaryId);
    }

    @Transactional
    public List<FeedProtocol> findAll() {
        return feedProtocolDAO.findAll();
    }

    public List<FeedProtocol> findAllWithLimit(LimitParam limits) {
        return feedProtocolDAO.findAllWithLimit(limits);
    }
}
