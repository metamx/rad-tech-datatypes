# RadTech Datatypes

Rad-Tech-Datatypes is a Java library built to assist in the serialization & validation of JSON event records designed for the reporting use cases of programmatic media markets.

These records are further outlined in the [Metamarkets Real-time Data Ingestion (RDI) API documentation](https://metamarkets.com/what-we-do/docs/formatting-openrtb-exchangessp-data/), and are based on the protocol defined by the [OpenRTB API Specification](http://www.iab.net/guidelines/rtbproject).

## JARs

Rad-Tech-Datatypes artifacts are hosted on the Metamarkets maven repository: https://metamx.artifactoryonline.com/metamx/pub-libs-releases-local/.
If you set up your project to know about this repository, you can depend on one of the hosted versions.

While there is not yet a stable release, the current version in beta testing is:
```xml
<dependency>
  <groupId>com.metamx</groupId>
  <artifactId>rad-tech-datatypes</artifactId>
  <version>0.0.5</version>
</dependency>
```
## Usage

### Jackson

Rad-Tech-Datatypes uses the Jackson data-binding API, so we start by creating a `com.fasterxml.jackson.databind.ObjectMapper` instance:
```java
final ObjectMapper objectMapper = new ObjectMapper();
```

### Serialization
The MMX Auction Summary record consists of an OpenRTB bid request with an array of nested OpenRTB bid responses. Additional parameters for denoting information about the auction and bids have been added where applicable.  
```java
// Build the Auction Summary record
final MmxAuctionSummary auctionSummary = MmxAuctionSummary
    .builder()
    .timestamp(new DateTime("2014-01-01T00:00:00.000Z"))
    .auctionType(2)
    .bcat(Arrays.asList("IAB26", "IAB25"))
    .requestId("AFEWSEBD5EB5FI32DASFCD452BB78DVE")
    .app(
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
            .publisher(
                Publisher.builder().id("pub12345").name("Publisher A").build()
            ).build()
    ).impressions(
        Arrays.asList(
            Imp.builder().tagId("231").bidFloor(0.1).secure(0).banner(
                Banner.builder().height(320).width(50).pos(3).apiFrameworks(Arrays.asList(3, 4)).build()
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
                                                          .status(1)
                                                          .price(5.43)
                                                          .clearPrice(1.1)
                                                          .adId("314")
                                                          .attr(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 12))
                                                          .crId("1234")
                                                          .cId("229")
                                                          .adomain(Arrays.asList("realtime4real.mmx.org"))
                                                          .build()
                                                )
                                            ).build()
                              )
                          ).build()
        )
    ).build();

```
Custom JSON can be added to all objects via an extension object.  Supported types include `String`, `Integer`, `Double` and `List`s of `String`s.
```java
final ObjectMapper objectMapper = new ObjectMapper();
final MmxAuctionSummary auctionSummary = MmxAuctionSummary
    .builder()
    .timestamp(new DateTime("2014-01-01T00:00:00.000Z"))
    .requestId("AFEWSEBD5EB5FI32DASFCD452BB78DVE")
    .ext(
        Ext.builder().put("custFlag", 3).put("custStr", "Unicorns are the best!").build()
    )
```

### Uploading Data to Metamarkets Real-time Data Ingestion

Data uploaded to RDI consists of newline separated JSON records posted continuously to an HTTPS endpoint.  Here is an example illustrating how Rad-Tech-Datatypes can be applied to do so.
```java
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metamx.datatypes.mmx.MmxAuctionSummary;
import org.joda.time.DateTime;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class ExampleWriteNewLineJson
{
  public static void main(String[] args) throws Exception
  {
    final MmxAuctionSummary sampleAuction1 = MmxAuctionSummary
        .builder()
        .timestamp(new DateTime("2014-01-01T00:00:00.000Z")).auctionType(2).build();
    final MmxAuctionSummary sampleAuction2 = MmxAuctionSummary
        .builder()
        .timestamp(new DateTime("2014-01-01T01:00:00.000Z")).auctionType(1).build();

    List<MmxAuctionSummary> auctionList = Arrays.asList(sampleAuction1, sampleAuction2);
    final String separator = "\n";

    final ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    final OutputStream outStream = new ByteArrayOutputStream();

    for (MmxAuctionSummary auction : auctionList) {
      outStream.write(objectMapper.writeValueAsBytes(auction));
      outStream.write(separator.getBytes());
    }

    System.out.println(outStream.toString());
  }
}
```
Note: RDI users are encouraged to use GZIP compression.

For more information on posting data to RDI, click [here](https://metamarkets.com/what-we-do/docs/uploading-data-for-ingestion/).


