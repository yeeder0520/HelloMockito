package com.tradevan.demo.wiremockdemo;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.tradevan.demo.Cashier;
import com.tradevan.demo.exception.PhoneNotConnectedException;
import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WireMockTest {

  @InjectMocks
  Cashier cashier;

  private static WireMockServer wireMockServer;

  @BeforeEach
  void startWireMockServer() {
    wireMockServer = new WireMockServer(8088);
    configureFor("localhost", 8088);
    wireMockServer.start();
    System.out.println("WireMock server started on port 8088");

  }

  @AfterEach
  void stopWireMockServer() {
    wireMockServer.stop();
  }

  @Test
  void test_callMyBoyFriendSayILoveYou_should_be_successful()
      throws URISyntaxException, IOException, InterruptedException {
    stubFor(get(urlEqualTo("/call-john/i-love-u"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "text/plain")
                                .withBody("I love you too")));

    String actual = cashier.callMyBoyFriendSayILoveYou();

    assertThat(actual).isEqualToIgnoringCase("HAPPY");

  }

  @Test
  void test_callMyBoyFriendSayILoveYou_when_body_is_not_contain_i_love_u_will_return_sad()
      throws URISyntaxException, IOException, InterruptedException {
    stubFor(get(urlEqualTo("/call-john/i-love-u"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "text/plain")
                                .withBody("You are so annoying")));

    String actual = cashier.callMyBoyFriendSayILoveYou();

    assertThat(actual).isEqualToIgnoringCase("SAD");

  }

  @Test
  void test_callMyBoyFriendSayILoveYou_should_be_failed() {
    stubFor(get(urlEqualTo("/call-john/i-love-u"))
                .willReturn(aResponse()
                                .withStatus(404)
                                .withHeader("Content-Type", "text/plain")
                                .withBody("I love you too")));

    assertThatThrownBy(() -> cashier.callMyBoyFriendSayILoveYou())
        .isInstanceOf(PhoneNotConnectedException.class)
        .hasFieldOrPropertyWithValue("errorCode", "My boyfriend doesn't care about me anymore");

  }
}
