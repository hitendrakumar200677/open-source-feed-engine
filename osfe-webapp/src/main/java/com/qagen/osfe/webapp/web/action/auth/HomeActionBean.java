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
package com.qagen.osfe.webapp.web.action.auth;

import com.qagen.osfe.common.RoleConstants;
import com.qagen.osfe.webapp.web.action.BaseActionBean;
import com.qagen.osfe.webapp.web.security.Secure;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

/**
 * Author: Gregg Bolinger
 * <p/>
 */
@UrlBinding("/action/home")
@Secure(roles = {RoleConstants.ADMINISTRATOR, RoleConstants.DATA_MANAGER, RoleConstants.FEED_MANAGER, RoleConstants.USER})
public class HomeActionBean extends BaseActionBean {

  @Override
  public Resolution display() {
    return new ForwardResolution(HOME_VIEW);
  }

  public Resolution managementFormsHome() {
    return new ForwardResolution(MANAGEMENT_FORMS_HOME_VIEW);
  }

  public Resolution queryFormsHome() {
    return new ForwardResolution(QUERY_FORMS_HOME_VIEW);
  }

  public Resolution schedulingFormsHome() {
    return null;
  }

}
