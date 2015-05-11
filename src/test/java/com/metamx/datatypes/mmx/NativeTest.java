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

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metamx.datatypes.openrtb.App;
import com.metamx.datatypes.openrtb.Banner;
import com.metamx.datatypes.openrtb.Data;
import com.metamx.datatypes.openrtb.Device;
import com.metamx.datatypes.openrtb.Ext;
import com.metamx.datatypes.openrtb.Geo;
import com.metamx.datatypes.openrtb.Imp;
import com.metamx.datatypes.openrtb.Native;
import com.metamx.datatypes.openrtb.Publisher;
import com.metamx.datatypes.openrtb.Segment;
import com.metamx.datatypes.openrtb.Site;
import com.metamx.datatypes.openrtb.User;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class NativeTest
{
  final MmxAuctionSummary simpleAuctionSummary = MmxAuctionSummary
      .builder()
      .timestamp(new DateTime("2014-01-01T00:00:00.000Z"))
      .impressions(
          Arrays.asList(
              Imp.builder().tagId("231").nativeObj(
                  Native.builder()
                        .request("String complying w/ Native Spec.")
                        .api(Arrays.asList(1, 2, 3))
                        .battr(Arrays.asList(2, 43, 2))
                        .ext(Ext.builder().put("testDouble", 2.2).build())
                        .build()
              ).build()
          )
      ).build();

  final String simpleJson = "{"
                            + "\"timestamp\":\"2014-01-01T00:00:00.000Z\","
                            + "\"imp\":[{\"tagid\":\"231\",\"nativeObj\":{\"request\":\"String complying w/ Native Spec.\",\"ver\":\"1\",\"api\":[1,2,3],\"battr\":[2,43,2],\"ext\":{\"testDouble\":2.2}}}]"
                            + "}";

  @Test
  public void testSimpleSerialization() throws Exception
  {
    final ObjectMapper objectMapper = new ObjectMapper();
    Assert.assertEquals(simpleJson, objectMapper.writeValueAsString(simpleAuctionSummary));
  }

  @Test
  public void testSimpleRoundTrip() throws Exception
  {
    final ObjectMapper objectMapper = new ObjectMapper();
    final String roundTripJson = objectMapper.writeValueAsString(
        objectMapper.readValue(
            simpleJson,
            MmxAuctionSummary.class
        )
    );
    Assert.assertEquals(simpleJson, roundTripJson);
  }

  @Test
  public void testSimpleDeserialization() throws Exception
  {
    final ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    final MmxAuctionSummary auction = objectMapper.readValue(
        simpleJson,
        MmxAuctionSummary.class
    );
    final String nativeVer = auction.getImpressions().get(0).getNativeObj().getVer();
    Assert.assertEquals("1", nativeVer);
  }

}
