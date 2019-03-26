package edu.harrisburgu.cisc525.app;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Unit test
 */
public class GreetingsTest {
    @Before
    public void setup() throws UnknownHostException, SocketException {
        System.out.println("Your Host addr: " + InetAddress.getLocalHost().getHostAddress()); // often returns
                                                                                              // "127.0.0.1"
        Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
        for (; n.hasMoreElements();) {
            NetworkInterface e = n.nextElement();

            Enumeration<InetAddress> a = e.getInetAddresses();
            for (; a.hasMoreElements();) {
                InetAddress addr = a.nextElement();
                System.out.println("  " + addr.getHostAddress());
            }
        }
    }

    @Test
    public void shouldReturnProperGreetings() throws UnknownHostException {
        Greetings greetings = new Greetings();
        String actual = greetings.hello("John");
        String expected = String.format("Hello, %s from %s/%s", "John", 
                            InetAddress.getLocalHost().getHostName(),
                            ManagementFactory.getRuntimeMXBean().getName());
        assertThat(actual, equalTo(expected));
    }
}
