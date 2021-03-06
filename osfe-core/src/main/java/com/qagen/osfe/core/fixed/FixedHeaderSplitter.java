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
package com.qagen.osfe.core.fixed;

import com.qagen.osfe.core.EngineContext;
import com.qagen.osfe.core.row.RowValue;

import java.util.List;

/**
 * Author: Hycel Taylor
 * <p/>
 * This class operates on the footer rows of a fixed feed file.
 */
public class FixedHeaderSplitter extends FixedSplitter {
  private FixedFileReader fileReader;
  private Integer rowIndex;

  public void setContext(EngineContext context) {
    fileReader = new FixedFileReader(context);
  }

  /**
   * Get the fileReader from the context.
   */
  public void initialize() {
    super.initialize();
    rowIndex = 0;
  }

  /**
   * Retrieves a list or RowValue objects for the given feed file.
   *
   * @return reference to a list of RowValue objects.
   */
  public List<RowValue> getNextRow() {
    // make sure file pointer is at the beginning of the file.
    if (rowIndex == 0) {
      fileReader.movePointer(0L);
    }

    if (hasNextRow()) {
      rowIndex++;
      final String row = fileReader.getRow(rowLength);
      return rowParser.parseRow(row);
    }
    return null;
  }

  /**
   * Determines if there is another row to retrieve from the feed file.
   *
   * @return true if more rows. false if end of file has been reached.
   */
  public Boolean hasNextRow() {
    return rowIndex < rowCount;
  }

  /**
   * Sometimes certain operations need to be executed prior to the first row
   * being retrieved but after initialization.
   */
  public void prePhaseExecute() {
  }

  /**
   * Stores the name of the given service as it is defined in the feed
   * configuration document.
   *
   * @return the name of the service as it is defined in the feed configuration
   *         document.
   */
  public String name() {
    return this.getClass().getSimpleName();
  }

  /**
   * Depending on the behavior of the service, it's shutdown method may be
   * called in order to perform house keeping tasks such as closing files
   * and other depended services.
   */
  public void shutdown() {
  }
}
