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

import com.qagen.osfe.common.utils.DomReader;
import com.qagen.osfe.core.column.ColumnDescription;
import org.dom4j.Element;

/**
 * Author: Hycel Taylor
 * <p/>
 * This classe extends ColumnDescription and addes specific attributes for
 * describing a fixed column.
 */
public class FixedColumnDescription extends ColumnDescription {
  private static enum ATTRIBUTE {
    start,
    length
  }

  protected final Integer start;
  protected final Integer length;

  /**
   * Constructor
   *
   * @param element reference to element that contains attributes for the given
   *                column description.
   */
  public FixedColumnDescription(Element element) {
    super(element);
    start = DomReader.getIntValue(element, ATTRIBUTE.start.name());
    length = DomReader.getIntValue(element, ATTRIBUTE.length.name());
  }

  /**
   * Retrieves the starting position of column within the row of characters.
   *
   * @return starting position of the column.
   */
  public Integer getStart() {
    return start;
  }

  /**
   * Retreives the fixed length of characters the column occupies.
   *
   * @return fixed length of character the column occuies.
   */
  public Integer getLength() {
    return length;
  }
}