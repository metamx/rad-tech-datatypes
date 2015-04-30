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
import com.metamx.datatypes.mmx.MmxBid;
import com.metamx.datatypes.mmx.MmxSeatBid;
import com.metamx.datatypes.mmx.MmxAuctionSummary;
import com.metamx.datatypes.mmx.MmxBidResponse;
import com.metamx.datatypes.openrtb.App;
import com.metamx.datatypes.openrtb.Banner;
import com.metamx.datatypes.openrtb.Data;
import com.metamx.datatypes.openrtb.Device;
import com.metamx.datatypes.openrtb.Ext;
import com.metamx.datatypes.openrtb.Geo;
import com.metamx.datatypes.openrtb.Imp;
import com.metamx.datatypes.openrtb.Publisher;
import com.metamx.datatypes.openrtb.Segment;
import com.metamx.datatypes.openrtb.Site;
import com.metamx.datatypes.openrtb.User;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class AuctionSummaryTest
{
  final MmxAuctionSummary simpleAuctionSummary = MmxAuctionSummary
      .builder()
      .timestamp(new DateTime("2014-01-01T00:00:00.000Z"))
      .auctionType(2)
      .bcat(Arrays.asList("IAB26", "IAB25"))
      .badv(Arrays.asList("unicornsay.com","unicornssay.com"))
      .requestId("AFEWSEBD5EB5FI32DASFCD452BB78DVE")
      .ext(
          Ext.builder().put("custFlag",3).put("custStr","Unicorns are the best!").build()
      ).app(
          App.builder()
             .bundle("bundlename")
             .cat(Arrays.asList("IAB1"))
             .domain("unicornssay.com")
             .id("12312312")
             .name("Unicornssay")
             .publisher(
                 Publisher.builder().id("DSA1394D42D3").name("Unicornssay").build()
             ).build()
      ).site(
          Site.builder()
              .cat(Arrays.asList("IAB1", "IAB2"))
              .domain("unicornssay.com")
              .id("1345135123")
              .name("Unicornssay")
              .mobile(0)
              .publisher(
                  Publisher.builder().id("pub12345").name("Publisher A").build()
              ).build()
      ).impressions(
          Arrays.asList(
              Imp.builder().tagId("231").bidFloor(0.1).secure(0).banner(
                  Banner.builder().height(320).width(50).pos(3).api(Arrays.asList(3, 4)).build()
              ).displayManager("MyRenderer").displayManagerVer("v2").build()
          )
      ).device(
          Device.builder()
                .carrier("Verizon")
                .connectionType(2)
                .deviceType(1)
                .didmd5("AA003")
                .didsha1("AA023")
                .dnt(0)
                .dpidmd5("A400FABFB5")
                .dpidsha1("AA0")
                .flashVer("2.1")
                .ifa("123")
                .ip("192.168.1.8")
                .jsSupport(1)
                .language("en")
                .macsha1("E50BB11")
                .macmd5("BB11")
                .make("Apple")
                .model("iPhone 3GS")
                .osVer("4.2.1")
                .os("iOS")
                .ua("Crazy UA String!")
                .geo(
                    Geo.builder()
                       .city("US-SFO")
                       .country("USA")
                       .lat(37.790148)
                       .lon(-122.434103)
                       .metro("807")
                       .region("CA")
                       .type(1)
                       .zip("94107")
                       .build()
                ).ext(
              Ext.builder().put("customField", "sam").build()
          ).build()
      ).user(
          User.builder().id("456789876567897654678987656789").yob(1987).gender("M").data(
              Arrays.asList(
                  Data.builder().id("123").name("bluesky").segment(
                      Arrays.asList(
                          Segment.builder().id("abc1").name("gender").value("male").build()
                      )
                  ).build()
              )
          ).build()
      ).responses(
          Arrays.asList(
              MmxBidResponse.builder()
                            .timestamp(new DateTime("2014-03-05T04:58:23.200Z"))
                            .status(1)
                            .totalDuration(43L)
                            .bidderId("1921")
                            .bidderName("RealAds")
                            .cur("USD")
                            .seatBid(
                                Arrays.asList(
                                    MmxSeatBid.builder()
                                              .seat("512")
                                              .bid(
                                                  Arrays.asList(
                                                      MmxBid.builder()
                                                            .id("1")
                                                            .impId("102")
                                                            .dealId("123ABC")
                                                            .status(1)
                                                            .cat("IAB1")
                                                            .price(5.43)
                                                            .clearPrice(1.1)
                                                            .adId("314")
                                                            .attr(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 12))
                                                            .crId("1234")
                                                            .cId("229")
                                                            .adomain(Arrays.asList("realtime4real.mmx.org"))
                                                            .iUrl("http://adserver.com/pathtosampleimage")
                                                            .build()
                                                  )
                                              ).build()
                                )
                            ).build()
          )
      ).build();

  final String simpleJson = "{"
                            + "\"timestamp\":\"2014-01-01T00:00:00.000Z\","
                            + "\"id\":\"AFEWSEBD5EB5FI32DASFCD452BB78DVE\","
                            + "\"at\":2,"
                            + "\"bcat\":[\"IAB26\",\"IAB25\"],"
                            + "\"badv\":[\"unicornsay.com\",\"unicornssay.com\"],"
                            + "\"imp\":[{\"banner\":{\"w\":50,\"h\":320,\"pos\":3,\"api\":[3,4]},\"displaymanager\":\"MyRenderer\",\"displaymanagerver\":\"v2\",\"tagid\":\"231\",\"bidfloor\":0.1,\"secure\":0}],"
                            + "\"app\":{\"id\":\"12312312\",\"name\":\"Unicornssay\",\"domain\":\"unicornssay.com\",\"cat\":[\"IAB1\"],\"bundle\":\"bundlename\",\"publisher\":{\"id\":\"DSA1394D42D3\",\"name\":\"Unicornssay\"}},"
                            + "\"site\":{\"id\":\"1345135123\",\"name\":\"Unicornssay\",\"domain\":\"unicornssay.com\",\"cat\":[\"IAB1\",\"IAB2\"],\"mobile\":0,\"publisher\":{\"id\":\"pub12345\",\"name\":\"Publisher A\"}},"
                            + "\"device\":{\"dnt\":0,\"ua\":\"Crazy UA String!\",\"ip\":\"192.168.1.8\",\"geo\":{\"lat\":37.790148,\"lon\":-122.434103,\"country\":\"USA\",\"region\":\"CA\",\"metro\":\"807\",\"city\":\"US-SFO\",\"zip\":\"94107\",\"type\":1},\"didsha1\":\"AA023\",\"didmd5\":\"AA003\",\"dpidsha1\":\"AA0\",\"dpidmd5\":\"A400FABFB5\",\"macsha1\":\"E50BB11\",\"macmd5\":\"BB11\",\"carrier\":\"Verizon\",\"language\":\"en\",\"make\":\"Apple\",\"model\":\"iPhone 3GS\",\"os\":\"iOS\",\"osv\":\"4.2.1\",\"js\":1,\"connectiontype\":2,\"devicetype\":1,\"flashver\":\"2.1\",\"ifa\":\"123\",\"ext\":{\"customField\":\"sam\"}},"
                            + "\"user\":{\"id\":\"456789876567897654678987656789\",\"yob\":1987,\"gender\":\"M\",\"data\":[{\"id\":\"123\",\"name\":\"bluesky\",\"segment\":[{\"id\":\"abc1\",\"name\":\"gender\",\"value\":\"male\"}]}]},"
                            + "\"bid_responses\":[{\"timestamp\":\"2014-03-05T04:58:23.200Z\",\"bidder_id\":\"1921\",\"bidder_name\":\"RealAds\",\"status\":1,\"total_duration\":43,\"cur\":\"USD\",\"seatbid\":[{\"seat\":\"512\",\"bid\":[{\"id\":\"1\",\"impid\":\"102\",\"status\":1,\"price\":5.43,\"clear_price\":1.1,\"adid\":\"314\",\"adomain\":[\"realtime4real.mmx.org\"],\"iurl\":\"http://adserver.com/pathtosampleimage\",\"cid\":\"229\",\"crid\":\"1234\",\"cat\":\"IAB1\",\"attr\":[1,2,3,4,5,6,7,12],\"dealid\":\"123ABC\"}]}]}],"
                            + "\"ext\":{\"custStr\":\"Unicorns are the best!\",\"custFlag\":3}"
                            + "}";

  /*
   * Add tests for:
   * - device object fields
   * - utcoffset in geo
   * - nbr in bidresponse
   * - group in mmx seat bid
   * - bundle and cat on bid and mmxbid
   */

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
    final String country = auction.getDevice().getGeo().getCountry();
    Assert.assertEquals("USA", country);
  }

}
