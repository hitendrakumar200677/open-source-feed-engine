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
package com.qagen.osfe.examples.acme.phases;

import com.qagen.osfe.core.FeedErrorException;
import com.qagen.osfe.core.FooterSplitter;
import com.qagen.osfe.core.Phase;
import com.qagen.osfe.core.Splitter;
import com.qagen.osfe.core.row.Row;
import com.qagen.osfe.core.row.RowValue;
import com.qagen.osfe.core.utils.BeanPopulator;
import com.qagen.osfe.examples.acme.row.FooterRow;

import java.util.List;

public class FooterPhase extends Phase {
  private FooterSplitter footerSplitter;

  public void initialize() {
  }

  /**
   * Set the reference to the footer splitter.
   *
   * <ul><li>Injection - required</li></ul>
   *
   * @param footerSplitter reference to the footer splitter.
   */
  public void setFooterSplitter(Splitter footerSplitter) {
    this.footerSplitter = (FooterSplitter) footerSplitter;
  }

  public void execute() {
    final List<RowValue> rowValues = footerSplitter.getNextRow();
    final FooterRow footerRow = new FooterRow();

    BeanPopulator.populateBean(rowValues, footerRow);

    final Integer totalRowCount = footerSplitter.getTotalRowCount();
    final Integer minusRowCount = footerSplitter.getMinusRowCount();
    final Integer footerRowCount = footerRow.getRowCount();

    rowCountCheck(totalRowCount, footerRowCount, minusRowCount);
    context.setFeedRowCount(footerRowCount);

    echoRowInfo(footerRow);
  }

  private void echoRowInfo(Row row) {
    final FooterRow footerRow = (FooterRow) row;
    System.out.println("Footer: " + footerRow.getExamId() + "|" + footerRow.getCourseId() + "|" + footerRow.getRowCount());
  }

  private void rowCountCheck(Integer totalRowCount, Integer footerRowCount, Integer minusRowCount) {
    if ((totalRowCount - minusRowCount) != footerRowCount) {
      final String fileName = context.getFeedFileName();
      final String message =
        "The total number of rows in file, " + fileName + ", (" + totalRowCount + " <> " + minusRowCount + ") " +
          " does not match the rows count of " + footerRowCount + ", defined in the footer.";
      throw new FeedErrorException(message);
    }
  }

  /**
   * The method should be used to close resources. Any core FifeCycleService
   * should make sure to call the shutdown() method in all phases as a final
   * processe of its life cycle.
   */
  public void shutdown() {
    // No resources to close...
  }
}
