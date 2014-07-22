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
import com.metamx.datatypes.openrtb.Ext;
import com.metamx.datatypes.openrtb.Pmp;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MmxImpDelivery
{
  private final String timestamp;
  private final String requestId;
  private final Double chargePrice;
  private final Double pubRevenue;
  private final Pmp pmp;
  private final Ext ext;

  public MmxImpDelivery(
      @JsonProperty("timestamp") String timestamp,
      @JsonProperty("id") String requestId,
      @JsonProperty("charge_price") Double chargePrice,
      @JsonProperty("pub_revenue") Double pubRevenue,
      @JsonProperty("pmp") Pmp pmp,
      @JsonProperty("ext") Ext ext

  )
  {
    this.timestamp = timestamp;
    this.requestId = requestId;
    this.chargePrice = chargePrice;
    this.pubRevenue = pubRevenue;
    this.pmp = pmp;
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

  @JsonProperty("charge_price")
  public Double getChargePrice()
  {
    return chargePrice;
  }

  @JsonProperty("pub_revenue")
  public Double getPubRevenue()
  {
    return pubRevenue;
  }

  @JsonProperty
  public Pmp getPmp() { return pmp; }

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
    private Double chargePrice;
    private Double pubRevenue;
    private Pmp pmp;
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

    public Builder chargePrice(final Double chargePrice)
    {
      this.chargePrice = chargePrice;
      return this;
    }

    public Builder pubRevenue(final Double pubRevenue)
    {
      this.pubRevenue = pubRevenue;
      return this;
    }

    public Builder pmp(final Pmp pmp)
    {
      this.pmp = pmp;
      return this;
    }

    public Builder ext(final Ext ext)
    {
      this.ext = ext;
      return this;
    }

    public MmxImpDelivery build()
    {
      return new MmxImpDelivery(
          timestamp.withZone(DateTimeZone.UTC).toString(),
          requestId,
          chargePrice,
          pubRevenue,
          pmp,
          ext
      );
    }
  }
}
