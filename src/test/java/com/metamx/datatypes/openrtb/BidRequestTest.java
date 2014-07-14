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
  final BidRequest simpleBidRequest = BidRequest
      .builder()
      .requestId("AFEWSEBD5EB5FI32DASFCD452BB78DVE")
      .bcat(Arrays.asList("IAB26", "IAB25"))
      .auctionType(2)
      .build();

  final Device device = Device.builder().deviceType(1).carrier("Verizon").build();

  final String simpleJson = "{"
                            + "\"timestamp\":\"2014-01-01T00:00:00.000Z\","
                            + "\"id\":\"AFEWSEBD5EB5FI32DASFCD452BB78DVE\","
                            + "\"at\":2,"
                            + "\"bcat\":[\"IAB26\",\"IAB25\"],"
                            + "\"device\":{\"dnt\":0,\"ua\":\"Crazy UA String!\",\"ip\":\"192.168.1.8\",\"geo\":{\"lat\":37.790148,\"lon\":-122.434103,\"country\":\"USA\",\"region\":\"CA\",\"metro\":\"807\",\"city\":\"US-SFO\",\"zip\":\"94107\",\"type\":1},\"didsha1\":\"AA023\",\"didmd5\":\"AA003\",\"dpidsha1\":\"AA0\",\"dpidmd5\":\"A400FABFB5\",\"macsha1\":\"E50BB11\",\"macmd5\":\"BB11\",\"carrier\":\"Verizon\",\"language\":\"en\",\"make\":\"Apple\",\"model\":\"iPhone 3GS\",\"os\":\"iOS\",\"osv\":\"4.2.1\",\"js\":1,\"connectiontype\":2,\"devicetype\":1,\"flashver\":\"2.1\",\"ifa\":\"123\",\"ext\":{\"customField\":\"sam\"}},"
                            + "\"ext\":{\"custStr\":\"Unicorns are the best!\",\"custFlag\":3}"
                            + "}";

  @Test
  public void testSimpleSerialization() throws Exception
  {
    final ObjectMapper objectMapper = new ObjectMapper();
    Assert.assertEquals(simpleJson, objectMapper.writeValueAsString(simpleBidRequest));
  }

  @Test
  public void testSimpleRoundTrip() throws Exception
  {
    final ObjectMapper objectMapper = new ObjectMapper();
    final String roundTripJson = objectMapper.writeValueAsString(
        objectMapper.readValue(
            simpleJson,
            BidRequest.class
        )
    );
    Assert.assertEquals(simpleJson, roundTripJson);
  }

}
