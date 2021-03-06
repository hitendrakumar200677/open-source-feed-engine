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
package com.qagen.osfe.core;

import org.dom4j.Element;

/**
 * Author : Hycel Taylor
 * <p/>
 * The abstract Loader class defines the contract for concrete classes implemented
 * to parse and load data from a specific type of XML element into Java objects.
 * Extending the Loader class enforces a design pattern for parsing XML documents.
 * Classes the extend the abstract Loader class can easily use other Loaders to
 * shorten the coding complexity of parsing complex XML documents.
 * <p/>
 * Example:  The code below shows the load method for a class the extend Loader
 * and uses to other loaders, NameLoader and AddressLoader in order to
 * parse the element data structure defined below.
 * <hr><blockquote><pre>
 *    &lt;person id="232325235"&gt;
 *      &lt;nameInfo last="Doe" first="John" middle="M"/&gt;
 *      &lt;addressInfo address"234 Pine St" city="Boston" state="MA" zipcode="02134"/&gt;
 *    &lt;/person&gt;
 *    <hr><blockquote><pre>
 *    public void load(Element parent) {
 *      list = new ArrayList<Person>();
 * <p/>
 *      final Iterator it = parent.elementIterator(ELEMENT.person.name());
 * <p/>
 *      while (it.hasNext()) {
 *        final Element element = (Element) it.next();
 *        final Integer id = DomReader.getRequiredValue(ATTRIBUTE.id.name());
 * <p/>
 *        final NameLoader nameLoader = new NameLoader(element);
 *        final AddressLoader addressLoader = new AddressLoader(element);
 * <p/>
 *        final NameInfo nameInfo = nameLoader.getNameInfo();
 *        final AddressInfo addressInfo = addressLoader.getAddressInfo();
 * <p/>
 *        list.add(new Person(id, nameInfo, addressInfo));
 *      }
 *    }
 *  </pre></blockquote><hr>
 */
public abstract class Loader implements Configurable, Initializeable, Contextable {
  protected String name;
  protected Element root;
  protected EngineContext context;

  /**
   * Constructor<p>
   * <p/>
   * This constructor in normally used for automatic dependency injection
   * when the feed config file is loaded.<p>
   * If this constructor is used then the following setters must be called:
   * <ul>
   * <li>setRoot(Element)
   * <li>setName(String)
   * <ul>
   */
  protected Loader() {
  }

  /**
   * Constructor
   *
   * @param root the element from which contains the sub element
   *             that will be parsed and referenced as the parent element.
   * @param name the name of the sub element to retrieve for data
   *             extraction.
   */
  public Loader(Element root, String name) {
    this.root = root;
    final Element parent = root.element(name);
    if (parent != null) {
      load(parent);
    }
  }

  /**
   * The bean loader can inject the root element of the feed document before
   * initialization.
   *
   * @param root
   */
  public void setRoot(Element root) {
    this.root = root;
  }

  /**
   * The bean loader can inject the reference to engine context before
   * initialztion.
   *
   * @param context reference to the engine context.
   */
  public void setContext(EngineContext context) {
    this.context = context;
  }

  public void load(Element root, String name) {
    this.root = root;
    this.name = name;

    final Element parent = root.element(name);
    if (parent != null) {
      load(parent);
    }
  }

  /**
   * Contains the instructions for parsing data from child elements within
   * the parent element. If the element is complex, other loaders should
   * be used within this method to parse different sub elements.
   *
   * @param parent container of child element to parse.
   */
  public abstract void load(Element parent);

  /**
   * Useful for knowing the number of data objects created from the number of
   * elements that were parsed.  Also useful to know if the element set was
   * empty.
   *
   * @return 0 if no elements were parsed.
   */
  public abstract int size();
}
