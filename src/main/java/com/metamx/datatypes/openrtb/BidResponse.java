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
public class BidResponse
{
  private final String id;
  private final String bidid;
  private final String cur;
  private final List<SeatBid> seatBid;
  private final Integer nbr;
  private final Ext ext;

  public BidResponse(
      @JsonProperty("id") String id,
      @JsonProperty("bidid") String bidid,
      @JsonProperty("cur") String cur,
      @JsonProperty("seatbid") List<SeatBid> seatBid,
      @JsonProperty("nbr") Integer nbr,
      @JsonProperty("ext") Ext ext
  )
  {
    this.id = id;
    this.bidid = bidid;
    this.cur = cur;
    this.seatBid = seatBid;
    this.nbr = nbr;
    this.ext = ext;
  }

  @JsonProperty
  public String getId()
  {
    return id;
  }

  @JsonProperty
  public String getBidid()
  {
    return bidid;
  }

  @JsonProperty
  public Integer getNbr()
  {
    return nbr;
  }

  @JsonProperty
  public String getCur()
  {
    return cur;
  }

  @JsonProperty("seatbid")
  public List<SeatBid> getSeatBid()
  {
    return seatBid;
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
    private String bidid;
    private String cur;
    private List<SeatBid> seatBid;
    private Integer nbr;
    private Ext ext;

    public Builder() {}

    public Builder id(final String id)
    {
      this.id = id;
      return this;
    }

    public Builder bidid(final String bidid)
    {
      this.bidid = bidid;
      return this;
    }

    public Builder cur(final String cur)
    {
      this.cur = cur;
      return this;
    }

    public Builder seatBid(final List<SeatBid> seatBid)
    {
      this.seatBid = seatBid;
      return this;
    }

    public Builder nbr(final Integer nbr)
    {
      this.nbr = nbr;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public BidResponse build()
    {
      return new BidResponse(
          id,
          bidid,
          cur,
          seatBid,
          nbr,
          ext
      );
    }
  }
}
