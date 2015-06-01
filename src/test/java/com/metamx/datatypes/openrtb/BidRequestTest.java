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

public class BidRequestTest
{

  final Ext sampleExt = Ext.builder().put("sample_str","Test String").put("sample_int", 1).put("sample_double",2.0).put("sample_str_list",Arrays.asList("test1","test2")).build();

  final Geo sampleGeo = Geo.builder()
                           .city("US-SFO")
                           .country("USA")
                           .lat(37.790148)
                           .lon(-122.434103)
                           .metro("807")
                           .region("CA")
                           .regionfips104("US")
                           .type(1)
                           .zip("94107")
                           .ext(sampleExt)
                           .build();

  final Device sampleDevice = Device.builder()
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
                                    .geo(sampleGeo)
                                    .ext(sampleExt)
                                    .build();

  final Producer sampleProducer = Producer.builder()
                                          .id("123123123")
                                          .name("Netflix")
                                          .cat(Arrays.asList("IAB2"))
                                          .domain("unicornssay.com")
                                          .ext(sampleExt)
                                          .build();

  final Content sampleContent = Content.builder()
                                       .id("123123123")
                                       .episode(2)
                                       .title("Smug Alert")
                                       .series("South Park")
                                       .season("7")
                                       .url("unicornssay.com")
                                       .cat(Arrays.asList("IAB1"))
                                       .videoQuality(2)
                                       .keywords("kw1,kw3,kw9")
                                       .contentRating("MPAA")
                                       .userRating("5 Stars")
                                       .context("video")
                                       .liveStream(1)
                                       .sourceRelationship(1)
                                       .producer(sampleProducer)
                                       .len(9000)
                                       .qagMediaRating(2)
                                       .embeddable(1)
                                       .language("en-US")
                                       .ext(sampleExt)
                                       .build();


  final Publisher samplePub = Publisher.builder()
                                       .id("DSA1394D42D3")
                                       .name("Unicornssay")
                                       .cat(Arrays.asList("IAB2"))
                                       .domain("unicornssay.com")
                                       .ext(sampleExt)
                                       .build();

  final App sampleApp = App.builder()
                           .id("12312312")
                           .name("Unicornssay")
                           .domain("unicornssay.com")
                           .cat(Arrays.asList("IAB1"))
                           .sectionCat(Arrays.asList("IAB1"))
                           .pageCat(Arrays.asList("IAB1"))
                           .ver("2.2.2")
                           .bundle("bundlename")
                           .privacyPolicy(1)
                           .paid(2)
                           .publisher(samplePub)
                           .content(sampleContent)
                           .ext(sampleExt)
                           .build();

  final Site sampleSite = Site.builder()
                              .id("12312312")
                              .name("Unicornssay")
                              .domain("unicornssay.com")
                              .cat(Arrays.asList("IAB1", "IAB2"))
                              .sectionCat(Arrays.asList("IAB1"))
                              .pageCat(Arrays.asList("IAB1"))
                              .page("unicornssay.com")
                              .privacyPolicy(1)
                              .ref("unicornsay.com")
                              .search("Unicorns are great")
                              .publisher(samplePub)
                              .content(sampleContent)
                              .keywords("unicorns,unicorn")
                              .ext(sampleExt)
                              .build();

  final Banner sampleBanner = Banner.builder()
                                    .width(50)
                                    .height(320)
                                    .wmax(50)
                                    .hmax(320)
                                    .wmin(10)
                                    .hmin(10)
                                    .id("ABC123")
                                    .pos(3)
                                    .btype(Arrays.asList(3, 4))
                                    .battr(Arrays.asList(8, 9, 10))
                                    .mimes(Arrays.asList("image/jpg", "image/gif"))
                                    .topframe(0)
                                    .expdir(Arrays.asList(1, 2, 3, 4, 5))
                                    .api(Arrays.asList(3, 4))
                                    .ext(sampleExt)
                                    .build();


  final Video sampleVideo = Video.builder()
                                 .mimes(Arrays.asList("video/x-ms-wmv"))
                                 .minDuration(300)
                                 .maxDuration(900)
                                 .protocol(3)
                                 .protocols(Arrays.asList(1,2,3))
                                 .width(320)
                                 .height(50)
                                 .startDelay(10)
                                 .linearity(2)
                                 .sequence(1)
                                 .battr(Arrays.asList(8, 9, 10))
                                 .maxExtended(0)
                                 .minBitrate(200)
                                 .maxBitrate(1000)
                                 .boxingAllowed(1)
                                 .playbackMethod(Arrays.asList(1, 2, 3))
                                 .delivery(Arrays.asList(1, 8, 9))
                                 .pos(1)
                                 .companionAd(Arrays.asList(sampleBanner))
                                 .api(Arrays.asList(1, 3))
                                 .companionType(Arrays.asList(3, 4))
                                 .ext(sampleExt)
                                 .build();

  final Deals sampleDeals = Deals.builder()
                                 .id("deal-for-unicorns-1")
                                 .bidFloor(0.1)
                                 .bidFloorCur("USD")
                                 .wseat(Arrays.asList("1", "2"))
                                 .wadomain(Arrays.asList("advertiser1.com", "advertiser2.com"))
                                 .auctionType(1)
                                 .ext(sampleExt)
                                 .build();

  final Pmp samplePmp = Pmp.builder().privateAuction(1).deals(Arrays.asList(sampleDeals)).ext(sampleExt).build();

  final Regs sampleRegs = Regs.builder().coppa(1).ext(sampleExt).build();

  final Imp sampleImp = Imp.builder()
                           .id("1")
                           .banner(sampleBanner)
                           .video(sampleVideo)
                           .displayManager("MyRenderer")
                           .displayManagerVer("v2")
                           .instl(0)
                           .tagId("231")
                           .bidFloor(0.1)
                           .bidFloorCur("USD")
                           .secure(0)
                           .iframebuster(Arrays.asList("buster1", "buster2"))
                           .pmp(samplePmp)
                           .ext(sampleExt)
                           .build();

  final Segment sampleSegment = Segment.builder().id("abc1").name("gender").value("male").ext(sampleExt).build();

  final Data sampleData = Data.builder()
                              .id("123")
                              .name("bluesky")
                              .segment(Arrays.asList(sampleSegment))
                              .ext(sampleExt)
                              .build();

  final User sampleUser = User.builder()
                              .id("456789876567897654678987656789")
                              .buyerid("ABC123")
                              .yob(1987)
                              .gender("M")
                              .keywords("kw1,kw2")
                              .customData("Supervaluable")
                              .geo(sampleGeo)
                              .data(Arrays.asList(sampleData))
                              .ext(sampleExt)
                              .build();

  final BidRequest sampleBidRequest = BidRequest
      .builder()
      .requestId("AFEWSEBD5EB5FI32DASFCD452BB78DVE")
      .impressions(Arrays.asList(Imp.builder().id("1").build()))
      .site(Site.builder().name("Unicornssay.com").build())
      .app(App.builder().name("Unicornssay.com").build())
      .device(Device.builder().carrier("Verizon").build())
      .user(User.builder().id("456789876567897654678987656789").build())
      .auctionType(2)
      .tmax(200)
      .wseat(Arrays.asList("2", "22"))
      .allimps(0)
      .cur(Arrays.asList("USD", "AUD"))
      .bcat(Arrays.asList("IAB26", "IAB25"))
      .badv(Arrays.asList("sampleadvertiser", "ihateunicorns.com"))
      .regs(Regs.builder().coppa(1).build())
      .ext(sampleExt)
      .build();

  @Test
  public void printJson() throws Exception
  {
    final ObjectMapper objectMapper = new ObjectMapper();
    System.out.println(objectMapper.writeValueAsString(sampleBidRequest));
  }

  final String extJson = "{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}";
  final String geoJson = "{\"lat\":37.790148,\"lon\":-122.434103,\"country\":\"USA\",\"region\":\"CA\",\"regionfips104\":\"US\",\"metro\":\"807\",\"city\":\"US-SFO\",\"zip\":\"94107\",\"type\":1,\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}";
  final String deviceJson = "{\"dnt\":0,\"ua\":\"Crazy UA String!\",\"ip\":\"192.168.1.8\",\"geo\":{\"lat\":37.790148,\"lon\":-122.434103,\"country\":\"USA\",\"region\":\"CA\",\"regionfips104\":\"US\",\"metro\":\"807\",\"city\":\"US-SFO\",\"zip\":\"94107\",\"type\":1,\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}},\"didsha1\":\"AA023\",\"didmd5\":\"AA003\",\"dpidsha1\":\"AA0\",\"dpidmd5\":\"A400FABFB5\",\"macsha1\":\"E50BB11\",\"macmd5\":\"BB11\",\"carrier\":\"Verizon\",\"language\":\"en\",\"make\":\"Apple\",\"model\":\"iPhone 3GS\",\"os\":\"iOS\",\"osv\":\"4.2.1\",\"js\":1,\"connectiontype\":2,\"devicetype\":1,\"flashver\":\"2.1\",\"ifa\":\"123\",\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}";
  final String producerJson = "{\"id\":\"123123123\",\"name\":\"Netflix\",\"cat\":[\"IAB2\"],\"domain\":\"unicornssay.com\",\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}";
  final String contentJson = "{\"id\":\"123123123\",\"episode\":2,\"title\":\"Smug Alert\",\"series\":\"South Park\",\"season\":\"7\",\"url\":\"unicornssay.com\",\"cat\":[\"IAB1\"],\"videoquality\":2,\"keywords\":\"kw1,kw3,kw9\",\"contentrating\":\"MPAA\",\"userrating\":\"5 Stars\",\"context\":\"video\",\"livestream\":1,\"sourcerelationship\":1,\"producer\":{\"id\":\"123123123\",\"name\":\"Netflix\",\"cat\":[\"IAB2\"],\"domain\":\"unicornssay.com\",\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}},\"len\":9000,\"qagmediarating\":2,\"embeddable\":1,\"language\":\"en-US\",\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}";
  final String pubJson = "{\"id\":\"DSA1394D42D3\",\"name\":\"Unicornssay\",\"cat\":[\"IAB2\"],\"domain\":\"unicornssay.com\",\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}";
  final String appJson = "{\"id\":\"12312312\",\"name\":\"Unicornssay\",\"domain\":\"unicornssay.com\",\"cat\":[\"IAB1\"],\"sectioncat\":[\"IAB1\"],\"pagecat\":[\"IAB1\"],\"ver\":\"2.2.2\",\"bundle\":\"bundlename\",\"privacypolicy\":1,\"paid\":2,\"publisher\":{\"id\":\"DSA1394D42D3\",\"name\":\"Unicornssay\",\"cat\":[\"IAB2\"],\"domain\":\"unicornssay.com\",\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}},\"content\":{\"id\":\"123123123\",\"episode\":2,\"title\":\"Smug Alert\",\"series\":\"South Park\",\"season\":\"7\",\"url\":\"unicornssay.com\",\"cat\":[\"IAB1\"],\"videoquality\":2,\"keywords\":\"kw1,kw3,kw9\",\"contentrating\":\"MPAA\",\"userrating\":\"5 Stars\",\"context\":\"video\",\"livestream\":1,\"sourcerelationship\":1,\"producer\":{\"id\":\"123123123\",\"name\":\"Netflix\",\"cat\":[\"IAB2\"],\"domain\":\"unicornssay.com\",\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}},\"len\":9000,\"qagmediarating\":2,\"embeddable\":1,\"language\":\"en-US\",\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}},\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}";
  final String siteJson = "{\"id\":\"12312312\",\"name\":\"Unicornssay\",\"domain\":\"unicornssay.com\",\"cat\":[\"IAB1\",\"IAB2\"],\"sectioncat\":[\"IAB1\"],\"pagecat\":[\"IAB1\"],\"page\":\"unicornssay.com\",\"privacypolicy\":1,\"ref\":\"unicornsay.com\",\"search\":\"Unicorns are great\",\"publisher\":{\"id\":\"DSA1394D42D3\",\"name\":\"Unicornssay\",\"cat\":[\"IAB2\"],\"domain\":\"unicornssay.com\",\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}},\"content\":{\"id\":\"123123123\",\"episode\":2,\"title\":\"Smug Alert\",\"series\":\"South Park\",\"season\":\"7\",\"url\":\"unicornssay.com\",\"cat\":[\"IAB1\"],\"videoquality\":2,\"keywords\":\"kw1,kw3,kw9\",\"contentrating\":\"MPAA\",\"userrating\":\"5 Stars\",\"context\":\"video\",\"livestream\":1,\"sourcerelationship\":1,\"producer\":{\"id\":\"123123123\",\"name\":\"Netflix\",\"cat\":[\"IAB2\"],\"domain\":\"unicornssay.com\",\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}},\"len\":9000,\"qagmediarating\":2,\"embeddable\":1,\"language\":\"en-US\",\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}},\"keywords\":\"unicorns,unicorn\",\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}";
  final String bannerJson = "{\"w\":50,\"h\":320,\"wmax\":50,\"hmax\":320,\"wmin\":10,\"hmin\":10,\"id\":\"ABC123\",\"pos\":3,\"btype\":[3,4],\"battr\":[8,9,10],\"mimes\":[\"image/jpg\",\"image/gif\"],\"topframe\":0,\"expdir\":[1,2,3,4,5],\"api\":[3,4],\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}";
  final String videoJson = "{\"mimes\":[\"video/x-ms-wmv\"],\"minduration\":300,\"maxduration\":900,\"protocol\":3,\"protocols\":[1,2,3],\"w\":320,\"h\":50,\"startdelay\":10,\"linearity\":2,\"sequence\":1,\"battr\":[8,9,10],\"maxextended\":0,\"minbitrate\":200,\"maxbitrate\":1000,\"boxingallowed\":1,\"playbackmethod\":[1,2,3],\"delivery\":[1,8,9],\"pos\":1,\"companionad\":[{\"w\":50,\"h\":320,\"wmax\":50,\"hmax\":320,\"wmin\":10,\"hmin\":10,\"id\":\"ABC123\",\"pos\":3,\"btype\":[3,4],\"battr\":[8,9,10],\"mimes\":[\"image/jpg\",\"image/gif\"],\"topframe\":0,\"expdir\":[1,2,3,4,5],\"api\":[3,4],\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}],\"api\":[1,3],\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]},\"companionType\":[3,4]}";
  final String dealsJson = "{\"id\":\"deal-for-unicorns-1\",\"bidfloor\":0.1,\"bidfloorcur\":\"USD\",\"wseat\":[\"1\",\"2\"],\"wadomain\":[\"advertiser1.com\",\"advertiser2.com\"],\"at\":1,\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}";
  final String pmpJson = "{\"private_auction\":1,\"deals\":[{\"id\":\"deal-for-unicorns-1\",\"bidfloor\":0.1,\"bidfloorcur\":\"USD\",\"wseat\":[\"1\",\"2\"],\"wadomain\":[\"advertiser1.com\",\"advertiser2.com\"],\"at\":1,\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}],\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}";
  final String regsJson = "{\"coppa\":1,\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}";
  final String impJson = "{\"id\":\"1\",\"banner\":{\"w\":50,\"h\":320,\"wmax\":50,\"hmax\":320,\"wmin\":10,\"hmin\":10,\"id\":\"ABC123\",\"pos\":3,\"btype\":[3,4],\"battr\":[8,9,10],\"mimes\":[\"image/jpg\",\"image/gif\"],\"topframe\":0,\"expdir\":[1,2,3,4,5],\"api\":[3,4],\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}},\"video\":{\"mimes\":[\"video/x-ms-wmv\"],\"minduration\":300,\"maxduration\":900,\"protocol\":3,\"protocols\":[1,2,3],\"w\":320,\"h\":50,\"startdelay\":10,\"linearity\":2,\"sequence\":1,\"battr\":[8,9,10],\"maxextended\":0,\"minbitrate\":200,\"maxbitrate\":1000,\"boxingallowed\":1,\"playbackmethod\":[1,2,3],\"delivery\":[1,8,9],\"pos\":1,\"companionad\":[{\"w\":50,\"h\":320,\"wmax\":50,\"hmax\":320,\"wmin\":10,\"hmin\":10,\"id\":\"ABC123\",\"pos\":3,\"btype\":[3,4],\"battr\":[8,9,10],\"mimes\":[\"image/jpg\",\"image/gif\"],\"topframe\":0,\"expdir\":[1,2,3,4,5],\"api\":[3,4],\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}],\"api\":[1,3],\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]},\"companionType\":[3,4]},\"displaymanager\":\"MyRenderer\",\"displaymanagerver\":\"v2\",\"instl\":0,\"tagid\":\"231\",\"bidfloor\":0.1,\"bidfloorcur\":\"USD\",\"secure\":0,\"iframebuster\":[\"buster1\",\"buster2\"],\"pmp\":{\"private_auction\":1,\"deals\":[{\"id\":\"deal-for-unicorns-1\",\"bidfloor\":0.1,\"bidfloorcur\":\"USD\",\"wseat\":[\"1\",\"2\"],\"wadomain\":[\"advertiser1.com\",\"advertiser2.com\"],\"at\":1,\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}],\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}},\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}";
  final String segmentJson = "{\"id\":\"abc1\",\"name\":\"gender\",\"value\":\"male\",\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}";
  final String dataJson = "{\"id\":\"123\",\"name\":\"bluesky\",\"segment\":[{\"id\":\"abc1\",\"name\":\"gender\",\"value\":\"male\",\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}],\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}";
  final String userJson = "{\"id\":\"456789876567897654678987656789\",\"buyerid\":\"ABC123\",\"yob\":1987,\"gender\":\"M\",\"keywords\":\"kw1,kw2\",\"customdata\":\"Supervaluable\",\"geo\":{\"lat\":37.790148,\"lon\":-122.434103,\"country\":\"USA\",\"region\":\"CA\",\"regionfips104\":\"US\",\"metro\":\"807\",\"city\":\"US-SFO\",\"zip\":\"94107\",\"type\":1,\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}},\"data\":[{\"id\":\"123\",\"name\":\"bluesky\",\"segment\":[{\"id\":\"abc1\",\"name\":\"gender\",\"value\":\"male\",\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}],\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}],\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}";
  final String bidRequestJson = "{\"id\":\"AFEWSEBD5EB5FI32DASFCD452BB78DVE\",\"imp\":[{\"id\":\"1\"}],\"site\":{\"name\":\"Unicornssay.com\"},\"app\":{\"name\":\"Unicornssay.com\"},\"device\":{\"carrier\":\"Verizon\"},\"user\":{\"id\":\"456789876567897654678987656789\"},\"at\":2,\"tmax\":200,\"wseat\":[\"2\",\"22\"],\"allimps\":0,\"cur\":[\"USD\",\"AUD\"],\"bcat\":[\"IAB26\",\"IAB25\"],\"badv\":[\"sampleadvertiser\",\"ihateunicorns.com\"],\"regs\":{\"coppa\":1},\"ext\":{\"sample_double\":2.0,\"sample_int\":1,\"sample_str\":\"Test String\",\"sample_str_list\":[\"test1\",\"test2\"]}}";

  @Test
  public void testSerializationByObject() throws Exception
  {
    final ObjectMapper objectMapper = new ObjectMapper();

    Assert.assertEquals(extJson, objectMapper.writeValueAsString(sampleExt));
    Assert.assertEquals(geoJson, objectMapper.writeValueAsString(sampleGeo));
    Assert.assertEquals(deviceJson, objectMapper.writeValueAsString(sampleDevice));
    Assert.assertEquals(producerJson, objectMapper.writeValueAsString(sampleProducer));
    Assert.assertEquals(contentJson, objectMapper.writeValueAsString(sampleContent));
    Assert.assertEquals(pubJson, objectMapper.writeValueAsString(samplePub));
    Assert.assertEquals(appJson, objectMapper.writeValueAsString(sampleApp));
    Assert.assertEquals(siteJson, objectMapper.writeValueAsString(sampleSite));
    Assert.assertEquals(bannerJson, objectMapper.writeValueAsString(sampleBanner));
    Assert.assertEquals(videoJson, objectMapper.writeValueAsString(sampleVideo));
    Assert.assertEquals(dealsJson, objectMapper.writeValueAsString(sampleDeals));
    Assert.assertEquals(pmpJson, objectMapper.writeValueAsString(samplePmp));
    Assert.assertEquals(regsJson, objectMapper.writeValueAsString(sampleRegs));
    Assert.assertEquals(impJson, objectMapper.writeValueAsString(sampleImp));
    Assert.assertEquals(segmentJson, objectMapper.writeValueAsString(sampleSegment));
    Assert.assertEquals(dataJson, objectMapper.writeValueAsString(sampleData));
    Assert.assertEquals(userJson, objectMapper.writeValueAsString(sampleUser));
    Assert.assertEquals(bidRequestJson, objectMapper.writeValueAsString(sampleBidRequest));
  }

  @Test
  public void testRoundTripByObject() throws Exception
  {
    final ObjectMapper objectMapper = new ObjectMapper();

    final String roundTripExtJson = objectMapper.writeValueAsString(
        objectMapper.readValue(extJson, Ext.class)
    );
    Assert.assertEquals(extJson, roundTripExtJson);

    final String roundTripGeoJson = objectMapper.writeValueAsString(
        objectMapper.readValue(geoJson, Geo.class)
    );
    Assert.assertEquals(geoJson, roundTripGeoJson);

    final String roundTripDeviceJson = objectMapper.writeValueAsString(
        objectMapper.readValue(deviceJson, Device.class)
    );
    Assert.assertEquals(deviceJson, roundTripDeviceJson);

    final String roundTripProducerJson = objectMapper.writeValueAsString(
        objectMapper.readValue(producerJson, Producer.class)
    );
    Assert.assertEquals(producerJson, roundTripProducerJson);

    final String roundTripContentJson = objectMapper.writeValueAsString(
        objectMapper.readValue(contentJson, Content.class)
    );
    Assert.assertEquals(contentJson, roundTripContentJson);

    final String roundTripPubJson = objectMapper.writeValueAsString(
        objectMapper.readValue(pubJson, Publisher.class)
    );
    Assert.assertEquals(pubJson, roundTripPubJson);

    final String roundTripAppJson = objectMapper.writeValueAsString(
        objectMapper.readValue(appJson, App.class)
    );
    Assert.assertEquals(appJson, roundTripAppJson);

    final String roundTripSiteJson = objectMapper.writeValueAsString(
        objectMapper.readValue(siteJson, Site.class)
    );
    Assert.assertEquals(siteJson, roundTripSiteJson);

    final String roundTripBannerJson = objectMapper.writeValueAsString(
        objectMapper.readValue(bannerJson, Banner.class)
    );
    Assert.assertEquals(bannerJson, roundTripBannerJson);

    final String roundTripVideoJson = objectMapper.writeValueAsString(
        objectMapper.readValue(videoJson, Video.class)
    );
    Assert.assertEquals(videoJson, roundTripVideoJson);

    final String roundTripDealsJson = objectMapper.writeValueAsString(
        objectMapper.readValue(dealsJson, Deals.class)
    );
    Assert.assertEquals(dealsJson, roundTripDealsJson);

    final String roundTripPmpJson = objectMapper.writeValueAsString(
        objectMapper.readValue(pmpJson, Pmp.class)
    );
    Assert.assertEquals(pmpJson, roundTripPmpJson);

    final String roundTripRegsJson = objectMapper.writeValueAsString(
        objectMapper.readValue(regsJson, Regs.class)
    );
    Assert.assertEquals(regsJson, roundTripRegsJson);

    final String roundTripImpJson = objectMapper.writeValueAsString(
        objectMapper.readValue(impJson, Imp.class)
    );
    Assert.assertEquals(impJson, roundTripImpJson);

    final String roundTripSegmentJson = objectMapper.writeValueAsString(
        objectMapper.readValue(segmentJson, Segment.class)
    );
    Assert.assertEquals(segmentJson, roundTripSegmentJson);

    final String roundTripDataJson = objectMapper.writeValueAsString(
        objectMapper.readValue(dataJson, Data.class)
    );
    Assert.assertEquals(dataJson, roundTripDataJson);

    final String roundTripUserJson = objectMapper.writeValueAsString(
        objectMapper.readValue(userJson, User.class)
    );
    Assert.assertEquals(userJson, roundTripUserJson);

    final String roundTripBidRequestJson = objectMapper.writeValueAsString(
        objectMapper.readValue(bidRequestJson, BidRequest.class)
    );
    Assert.assertEquals(bidRequestJson, roundTripBidRequestJson);
  }

}
