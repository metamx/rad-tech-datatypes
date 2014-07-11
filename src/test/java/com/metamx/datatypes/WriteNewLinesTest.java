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

package com.metamx.datatypes;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metamx.datatypes.mmx.MmxAuctionSummary;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class WriteNewLinesTest
{
  final MmxAuctionSummary sampleAuction1 = MmxAuctionSummary
      .builder()
      .timestamp(new DateTime("2014-01-01T00:00:00.000Z")).auctionType(2).build();
  final MmxAuctionSummary sampleAuction2 = MmxAuctionSummary
      .builder()
      .timestamp(new DateTime("2014-01-01T01:00:00.000Z")).auctionType(1).build();

  final String outputString = "{\"timestamp\":\"2014-01-01T00:00:00.000Z\",\"at\":2}\n"
                              + "{\"timestamp\":\"2014-01-01T01:00:00.000Z\",\"at\":1}\n";

  @Test
  public void testSimpleDeserialization() throws Exception
  {
    List<MmxAuctionSummary> auctionList = Arrays.asList(sampleAuction1, sampleAuction2);
    final String separator = "\n";

    final ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    final OutputStream outStream = new ByteArrayOutputStream();

    for (MmxAuctionSummary auction : auctionList) {
      outStream.write(objectMapper.writeValueAsBytes(auction));
      outStream.write(separator.getBytes());
    }

    Assert.assertEquals(outputString, outStream.toString());
  }
}
