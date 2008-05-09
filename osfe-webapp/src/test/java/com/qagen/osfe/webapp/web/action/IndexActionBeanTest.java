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
package com.qagen.osfe.webapp.web.action;

import net.sourceforge.stripes.mock.MockRoundtrip;
import net.sourceforge.stripes.mock.MockServletContext;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Author: Gregg Bolinger
 * <p>
 */
public class IndexActionBeanTest extends BaseActionBeanTest {

  @Test
  public void testDefaultHandler() throws Exception {
    MockServletContext context = getContext();

    MockRoundtrip trip = new MockRoundtrip(context, IndexActionBean.class);
    trip.execute();
    //IndexActionBean indexActionBean = trip.getActionBean(IndexActionBean.class);
    Assert.assertEquals(trip.getDestination(), "/WEB-INF/jsp/index.jsp");    
  }
}
