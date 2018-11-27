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

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pmp
{
  private final Integer privateAuction;
  private final List<Deals> deals;
  private final Ext ext;

  public Pmp(
      @JsonProperty("private_auction") Integer privateAuction,
      @JsonProperty("deals") List<Deals> deals,
      @JsonProperty("ext") Ext ext
  )
  {
    this.privateAuction = privateAuction;
    this.deals = deals;
    this.ext = ext;
  }

  @JsonProperty("private_auction")
  public Integer getPrivateAuction()
  {
    return privateAuction;
  }

  @JsonProperty
  public List<Deals> getDeals()
  {
    return deals;
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
    private Integer privateAuction;
    private List<Deals> deals;
    private Ext ext;

    public Builder() {}

    public Builder privateAuction(final Integer privateAuction)
    {
      this.privateAuction = privateAuction;
      return this;
    }

    public Builder deals(final List<Deals> deals)
    {
      this.deals = deals;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public Pmp build()
    {
      return new Pmp(privateAuction, deals, ext);
    }
  }
}
