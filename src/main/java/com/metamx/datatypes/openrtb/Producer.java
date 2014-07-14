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
public class Producer
{
  private final String id;
  private final String name;
  private final List<String> cat;
  private final String domain;
  private final Ext ext;

  public Producer(
      @JsonProperty("id") String id,
      @JsonProperty("name") String name,
      @JsonProperty("cat") List<String> cat,
      @JsonProperty("domain") String domain,
      @JsonProperty("ext") Ext ext
  )
  {
    this.id = id;
    this.name = name;
    this.cat = cat;
    this.domain = domain;
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

  @JsonProperty public List<String> getCat()
  {
    return cat;
  }

  @JsonProperty
  public String getDomain()
  {
    return domain;
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
    private List<String> cat;
    private String domain;
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

    public Builder cat(final List<String> cat)
    {
      this.cat = cat;
      return this;
    }

    public Builder domain(final String domain)
    {
      this.domain = domain;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public Producer build()
    {
      return new Producer(id, name, cat, domain, ext);
    }
  }
}
