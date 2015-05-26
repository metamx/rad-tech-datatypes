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

package com.metamx.datatypes.mmx;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.metamx.datatypes.openrtb.App;
import com.metamx.datatypes.openrtb.Device;
import com.metamx.datatypes.openrtb.Ext;
import com.metamx.datatypes.openrtb.Imp;
import com.metamx.datatypes.openrtb.Site;
import com.metamx.datatypes.openrtb.User;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MmxAuctionSummary
{
  private final String timestamp;
  private final String requestId;
  private final String supplySourceId;
  private final String supplySourceName;
  private final Integer auctionType;
  private final List<String> bcat;
  private final List<String> badv;
  private final List<Imp> impressions;
  private final App app;
  private final Site site;
  private final Device device;
  private final User user;
  private final Integer test;
  private final List<MmxBidResponse> responses;
  private final Ext ext;

  public MmxAuctionSummary(
      @JsonProperty("timestamp") String timestamp,
      @JsonProperty("id") String requestId,
      @JsonProperty("sourceid") String supplySourceId,
      @JsonProperty("sourcename") String supplySourceName,
      @JsonProperty("at") Integer auctionType,
      @JsonProperty("bcat") List<String> bcat,
      @JsonProperty("badv") List<String> badv,
      @JsonProperty("imp") List<Imp> impressions,
      @JsonProperty("app") App app,
      @JsonProperty("site") Site site,
      @JsonProperty("device") Device device,
      @JsonProperty("user") User user,
      @JsonProperty("test") Integer test,
      @JsonProperty("bid_responses") List<MmxBidResponse> responses,
      @JsonProperty("ext") Ext ext
  )
  {
    this.timestamp = timestamp;
    this.requestId = requestId;
    this.supplySourceId = supplySourceId;
    this.supplySourceName = supplySourceName;
    this.auctionType = auctionType;
    this.bcat = bcat;
    this.badv = badv;
    this.impressions = impressions;
    this.app = app;
    this.site = site;
    this.device = device;
    this.user = user;
    this.test = test;
    this.responses = responses;
    this.ext = ext;
  }

  @JsonProperty
  public String getTimestamp()
  {
    return timestamp;
  }

  @JsonProperty("id")
  public String getRequestId()
  {
    return requestId;
  }

  @JsonProperty("sourceid")
  public String getSupplySourceId()
  {
    return supplySourceId;
  }

  @JsonProperty("sourcename")
  public String getSupplySourceName()
  {
    return supplySourceName;
  }

  @JsonProperty("at")
  public Integer getAuctionType()
  {
    return auctionType;
  }

  @JsonProperty
  public List<String> getBcat()
  {
    return bcat;
  }

  @JsonProperty
  public List<String> getBadv()
  {
    return badv;
  }

  @JsonProperty("imp")
  public List<Imp> getImpressions()
  {
    return impressions;
  }

  @JsonProperty
  public App getApp()
  {
    return app;
  }

  @JsonProperty
  public Site getSite()
  {
    return site;
  }

  @JsonProperty
  public Device getDevice()
  {
    return device;
  }

  @JsonProperty
  public User getUser()
  {
    return user;
  }

  @JsonProperty
  public Integer getTest()
  {
    return test;
  }

  @JsonProperty("bid_responses")
  public List<MmxBidResponse> getResponses()
  {
    return responses;
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
    private DateTime timestamp;
    private String requestId;
    private String supplySourceId;
    private String supplySourceName;
    private Integer auctionType;
    private List<String> bcat;
    private List<String> badv;
    private List<Imp> impressions;
    private App app;
    private Site site;
    private Device device;
    private User user;
    private Integer test;
    private List<MmxBidResponse> responses;
    private Ext ext;

    public Builder() {}

    public Builder timestamp(final DateTime timestamp)
    {
      this.timestamp = timestamp;
      return this;
    }

    public Builder requestId(final String requestId)
    {
      this.requestId = requestId;
      return this;
    }

    public Builder supplySourceId(final String supplySourceId)
    {
      this.supplySourceId = supplySourceId;
      return this;
    }

    public Builder supplySourceName(final String supplySourceName)
    {
      this.supplySourceName = supplySourceName;
      return this;
    }

    public Builder auctionType(final Integer auctionType)
    {
      this.auctionType = auctionType;
      return this;
    }

    public Builder bcat(final List<String> bcat)
    {
      this.bcat = bcat;
      return this;
    }

    public Builder badv(final List<String> badv)
    {
      this.badv = badv;
      return this;
    }

    public Builder impressions(final List<Imp> impressions)
    {
      this.impressions = impressions;
      return this;
    }

    public Builder app(final App app)
    {
      this.app = app;
      return this;
    }

    public Builder site(final Site site)
    {
      this.site = site;
      return this;
    }

    public Builder device(final Device device)
    {
      this.device = device;
      return this;
    }

    public Builder user(final User user)
    {
      this.user = user;
      return this;
    }

    public Builder test(final Integer test)
    {
      this.test = test;
      return this;
    }

    public Builder responses(final List<MmxBidResponse> responses)
    {
      this.responses = responses;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public MmxAuctionSummary build()
    {
      if (timestamp == null) {
        throw new NullPointerException("null timestamp");
      }
      return new MmxAuctionSummary(
          timestamp.withZone(DateTimeZone.UTC).toString(),
          requestId,
          supplySourceId,
          supplySourceName,
          auctionType,
          bcat,
          badv,
          impressions,
          app,
          site,
          device,
          user,
          test,
          responses,
          ext
      );
    }
  }
}
