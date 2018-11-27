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

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BidResponseTest
{

  final Ext sampleExt = Ext.builder()
                           .put("sample_str", "Test String")
                           .put("sample_int", 1)
                           .put("sample_double",2.0)
                           .put("sample_str_list", Arrays.asList("test1", "test2"))
                           .build();

  final Bid sampleBid = Bid.builder()
                           .id("1")
                           .impId("102")
                           .price(5.43)
                           .adId("314")
                           .nurl("unicornssay.com")
                           .adm("XHTML markup")
                           .adomain(Arrays.asList("realtime4real.mmx.org"))
                           .iUrl("http://adserver.com/pathtosampleimage")
                           .cId("229")
                           .crId("1234")
                           .attr(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 12))
                           .dealId("123Deal")
                           .height(320)
                           .width(50)
                           .ext(sampleExt)
                           .build();

  final SeatBid sampleSeatBid = SeatBid.builder()
                                       .seat("512")
                                       .bid(Arrays.asList(sampleBid))
                                       .group(1)
                                       .ext(sampleExt)
                                       .build();

  final BidResponse sampleBidResponse = BidResponse.builder()
                                                   .id("123ABC")
                                                   .seatBid(Arrays.asList(sampleSeatBid))
                                                   .bidId("1234ABCD")
                                                   .cur("USD")
                                                   .customData("customID123")
                                                   .nbr(0)
                                                   .ext(sampleExt)
                                                   .build();

  @Test
  public void printJson() throws Exception
  {
    final ObjectMapper objectMapper = new ObjectMapper();
    System.out.println(objectMapper.writeValueAsString(sampleExt));
  }

  final String extJson = "{\"sample_str\":\"Test String\",\"sample_int\":1,\"sample_str_list\":[\"test1\",\"test2\"],\"sample_double\":2.0}";
  final String bidJson = "{\"id\":\"1\",\"impid\":\"102\",\"price\":5.43,\"adid\":\"314\",\"nurl\":\"unicornssay.com\",\"adm\":\"XHTML markup\",\"adomain\":[\"realtime4real.mmx.org\"],\"iurl\":\"http://adserver.com/pathtosampleimage\",\"cid\":\"229\",\"crid\":\"1234\",\"attr\":[1,2,3,4,5,6,7,12],\"dealid\":\"123Deal\",\"h\":320,\"w\":50,\"ext\":{\"sample_str\":\"Test String\",\"sample_int\":1,\"sample_str_list\":[\"test1\",\"test2\"],\"sample_double\":2.0}}";
  final String seatBidJson = "{\"seat\":\"512\",\"bid\":[{\"id\":\"1\",\"impid\":\"102\",\"price\":5.43,\"adid\":\"314\",\"nurl\":\"unicornssay.com\",\"adm\":\"XHTML markup\",\"adomain\":[\"realtime4real.mmx.org\"],\"iurl\":\"http://adserver.com/pathtosampleimage\",\"cid\":\"229\",\"crid\":\"1234\",\"attr\":[1,2,3,4,5,6,7,12],\"dealid\":\"123Deal\",\"h\":320,\"w\":50,\"ext\":{\"sample_str\":\"Test String\",\"sample_int\":1,\"sample_str_list\":[\"test1\",\"test2\"],\"sample_double\":2.0}}],\"group\":1,\"ext\":{\"sample_str\":\"Test String\",\"sample_int\":1,\"sample_str_list\":[\"test1\",\"test2\"],\"sample_double\":2.0}}";
  final String bidResponseJson = "{\"id\":\"123ABC\",\"seatbid\":[{\"seat\":\"512\",\"bid\":[{\"id\":\"1\",\"impid\":\"102\",\"price\":5.43,\"adid\":\"314\",\"nurl\":\"unicornssay.com\",\"adm\":\"XHTML markup\",\"adomain\":[\"realtime4real.mmx.org\"],\"iurl\":\"http://adserver.com/pathtosampleimage\",\"cid\":\"229\",\"crid\":\"1234\",\"attr\":[1,2,3,4,5,6,7,12],\"dealid\":\"123Deal\",\"h\":320,\"w\":50,\"ext\":{\"sample_str\":\"Test String\",\"sample_int\":1,\"sample_str_list\":[\"test1\",\"test2\"],\"sample_double\":2.0}}],\"group\":1,\"ext\":{\"sample_str\":\"Test String\",\"sample_int\":1,\"sample_str_list\":[\"test1\",\"test2\"],\"sample_double\":2.0}}],\"bidid\":\"1234ABCD\",\"cur\":\"USD\",\"customdata\":\"customID123\",\"nbr\":0,\"ext\":{\"sample_str\":\"Test String\",\"sample_int\":1,\"sample_str_list\":[\"test1\",\"test2\"],\"sample_double\":2.0}}";

  @Test
  public void testSerializationByObject() throws Exception
  {
    final ObjectMapper objectMapper = new ObjectMapper();

    Assert.assertEquals(extJson, objectMapper.writeValueAsString(sampleExt));
    Assert.assertEquals(bidJson, objectMapper.writeValueAsString(sampleBid));
    Assert.assertEquals(seatBidJson, objectMapper.writeValueAsString(sampleSeatBid));
    Assert.assertEquals(bidResponseJson, objectMapper.writeValueAsString(sampleBidResponse));

  }

  @Test
  public void testRoundTripByObject() throws Exception
  {
    final ObjectMapper objectMapper = new ObjectMapper();

    final String roundTripExtJson = objectMapper.writeValueAsString(
        objectMapper.readValue(extJson, Ext.class)
    );
    Assert.assertEquals(extJson, roundTripExtJson);

    final String roundTripBidJson = objectMapper.writeValueAsString(
        objectMapper.readValue(bidJson, Bid.class)
    );
    Assert.assertEquals(bidJson, roundTripBidJson);

    final String roundTripSeatBidJson = objectMapper.writeValueAsString(
        objectMapper.readValue(seatBidJson, SeatBid.class)
    );
    Assert.assertEquals(seatBidJson, roundTripSeatBidJson);

    final String roundTripBidResponseJson = objectMapper.writeValueAsString(
        objectMapper.readValue(bidResponseJson, BidResponse.class)
    );
    Assert.assertEquals(bidResponseJson, roundTripBidResponseJson);

  }

}
