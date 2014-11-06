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
import com.metamx.datatypes.openrtb.Banner;
import com.metamx.datatypes.openrtb.Deals;
import com.metamx.datatypes.openrtb.Imp;
import com.metamx.datatypes.openrtb.Pmp;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class DealsTest
{
  final MmxAuctionSummary auctionSummaryWithDeals = MmxAuctionSummary
      .builder()
      .timestamp(new DateTime("2014-01-01T00:00:00.000Z"))
      .impressions(
          Arrays.asList(
              Imp.builder()
                 .tagId("231")
                 .bidFloor(0.1)
                 .secure(0)
                 .banner(
                     Banner.builder().height(320).width(50).pos(3).api(Arrays.asList(3, 4)).build()
                 )
                 .displayManager("MyRenderer")
                 .displayManagerVer("v2")
                 .pmp(
                     Pmp.builder()
                        .privateAuction(1)
                        .deals(
                            Arrays.asList(
                                Deals.builder()
                                     .id("123ABC")
                                     .auctionType(1)
                                     .bidFloor(1.0)
                                     .bidFloorCur("USD")
                                     .wseat(Arrays.asList("1", "23", "456"))
                                     .wadomain(Arrays.asList("unicornsay.com", "unicornssay.com"))
                                     .build(),
                                Deals.builder()
                                     .id("ABC12")
                                     .auctionType(1)
                                     .build()
                            )
                        ).build()
                 ).build()
          )
          ).build();

  final String simpleJson = "{"
                            + "\"timestamp\":\"2014-01-01T00:00:00.000Z\","
                            + "\"imp\":[{\"banner\":{\"w\":50,\"h\":320,\"pos\":3,\"api\":[3,4]},\"displaymanager\":\"MyRenderer\",\"displaymanagerver\":\"v2\",\"tagid\":\"231\",\"bidfloor\":0.1,\"secure\":0,\"pmp\":{\"private_auction\":1,\"deals\":[{\"id\":\"123ABC\",\"bidfloor\":1.0,\"bidfloorcur\":\"USD\",\"wseat\":[\"1\",\"23\",\"456\"],\"wadomain\":[\"unicornsay.com\",\"unicornssay.com\"],\"at\":1},{\"id\":\"ABC12\",\"at\":1}]}}]"
                            + "}";

  @Test
  public void testSimpleSerialization() throws Exception
  {
    final ObjectMapper objectMapper = new ObjectMapper();
    System.out.println(objectMapper.writeValueAsString(auctionSummaryWithDeals));
    Assert.assertEquals(simpleJson, objectMapper.writeValueAsString(auctionSummaryWithDeals));
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
    final String dealId = auction.getImpressions().get(0).getPmp().getDeals().get(0).getId();
    Assert.assertEquals("123ABC", dealId);
  }

}
