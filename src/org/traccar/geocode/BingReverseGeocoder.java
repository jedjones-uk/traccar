/*
 * Copyright 2014 Jed Jones (jedjones.uk@gmail.com)
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
package org.traccar.geocode;

import java.net.URL;
import java.net.URLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.traccar.helper.Log;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author Jed
 */
public class BingReverseGeocoder implements ReverseGeocoder {

    private final String url;

    public BingReverseGeocoder(String key) {
        this.url = "http://dev.virtualearth.net/REST/v1/Locations/%f,%f?o=xml&key=" + key;
    }

    @Override
    public String getAddress(double latitude, double longitude) {

        try {

            URLConnection conn = new URL(String.format(url, latitude, longitude)).openConnection();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(conn.getInputStream());
            String formattedAddress = doc.getElementsByTagName("FormattedAddress").item(0).getTextContent();
            String countryRegion = doc.getElementsByTagName("CountryRegion").item(0).getTextContent();

            return formattedAddress + ", " + countryRegion;

        } catch (Exception error) {
            Log.warning(error);
        }

        return null;
    }

}
