/*
 * Rad-tech-datatypes.
 * Copyright 2014 Metamarkets Group Inc.
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

package com.metamx.datatypes.openrtb;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class App
{

  private final String id;
  private final String name;
  private final String domain;
  private final String bundle;
  private final List<String> cat;
  private final Publisher publisher;
  private final Ext ext;

  public App(
      @JsonProperty("id") String id,
      @JsonProperty("name") String name,
      @JsonProperty("domain") String domain,
      @JsonProperty("bundle") String bundle,
      @JsonProperty("cat") List<String> cat,
      @JsonProperty("publisher") Publisher publisher,
      @JsonProperty("ext") Ext ext
  )
  {
    this.id = id;
    this.name = name;
    this.domain = domain;
    this.bundle = bundle;
    this.cat = cat;
    this.publisher = publisher;
    this.ext = ext;
  }

  @JsonProperty
  public String getId()
  {
    return id;
  }

  @JsonProperty
  public String getName()
  {
    return name;
  }

  @JsonProperty
  public String getDomain()
  {
    return domain;
  }

  @JsonProperty
  public String getBundle()
  {
    return bundle;
  }

  @JsonProperty
  public List<String> getCat()
  {
    return cat;
  }

  @JsonProperty
  public Publisher getPublisher()
  {
    return publisher;
  }

  @JsonProperty
  public Ext getExt()
  {
    return ext;
  }

  public static Builder builder()
  {
    return new Builder();
  }

  public static class Builder
  {
    private String id;
    private String name;
    private String domain;
    private String bundle;
    private List<String> cat;
    private Publisher publisher;
    private Ext ext;

    public Builder() {}

    public Builder id(final String id)
    {
      this.id = id;
      return this;
    }

    public Builder name(final String name)
    {
      this.name = name;
      return this;
    }

    public Builder domain(final String domain)
    {
      this.domain = domain;
      return this;
    }

    public Builder bundle(final String bundle)
    {
      this.bundle = bundle;
      return this;
    }

    public Builder cat(final List<String> cat)
    {
      this.cat = cat;
      return this;
    }

    public Builder publisher(final Publisher publisher)
    {
      this.publisher = publisher;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public App build()
    {
      return new App(id, name, domain, bundle, cat, publisher, ext);
    }
  }
}
