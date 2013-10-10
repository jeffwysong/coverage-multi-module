package com.jeff;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.*;

/**
 * @since 10/9/13 9:32 PM
 */
public class HelloIT {

    private String baseUrl;

    @Before
    public void setUp() {
        String port = System.getProperty("servlet.port");
        System.out.println(port);
        setBaseUrl("http://localhost:" + port + "/hello");
//        setBaseUrl("http://localhost:9191/hello");
    }

    @Test
    public void testGetHelloPage() throws Exception {
        System.out.println(getBaseUrl());
        URL url = new URL(getBaseUrl());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        assertEquals(200, connection.getResponseCode());
//        System.out.println(connection.getContent());

        BufferedReader rd  = null;
        StringBuilder sb = null;
        String line = null;

        //read the result from the server
        rd  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        sb = new StringBuilder();

        while ((line = rd.readLine()) != null)
        {
            sb.append(line + '\n');
        }
        assertTrue(StringUtils.hasText(sb.toString()));
//        System.out.println(sb.toString());

    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
