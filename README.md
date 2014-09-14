
# Traccar 

Web page - http://www.traccar.org

Author - Anton Tananaev (anton.tananaev@gmail.com), Jed Jones (jedjones.uk@gmail.com)

SUMMARY:
-----------

Traccar is open source server for various GPS tracking devices.
Project is written in Java and should work on most platforms with
installed Java Runtime Environment.

CHANGES FROM DEFAULT:
-----------
THIS VERSION IS CURRENTLY ONLY DESIGNED TO USE MYSQL. THE CHANGES ARE NOT COMPATIBLE WITH TRACCAR WEB

This version of Traccar is slightly different to the main branch.
Currently the biggest difference is  the query `<entry key='database.selectDevice'>`
requires a 3rd column called `database`. This is then accessed in the other queries
(`<entry key='database.updateLatestPosition'>` and `<entry key='database.insertPosition'>`)
with the placeholder `_database_`. The aim of this placeholder is to allow you to 
direct an insert or update to the correct database for a device in the event 
you have a multi-tenant system without using concat and prepare statement.

CONFIG OPTIONS:
-----------
Below is a list of some of the config options that are available for this release and suggested options for use.

##Geocoder options
`<entry key='geocoder.enable'>true</entry>` Is required for any geocoder to be used  
`<entry key='geocoder.type'>bing</entry>` nominatim/bing/google are the options aviable. If none is given, google is used by default.  
### Geocoder specific options
`<entry key='geocoder.key'>BING API KEY HERE</entry>` to use the bing geocoder you must provider a valid api key with this option  
`<entry key='geocoder.url'>http://nominatim.openstreetmap.org/reverse</entry>` to use nominatim you must provide a url that is a valid nominatim geocode server  

##Web interface port
`<entry key='http.enable'>false</entry>` It is advised that you disable the built in traccar web access as it is not compatible with changes in this release.  

##Notes
It is advised that you append `&amp;useUnicode=true&amp;characterEncoding=UTF-8` to the database.url 
connection string if you intended to use a geocoder otherwise there may be display issues for utf8
addresses.

LICENSE:
-----------
Apache License, Version 2.0

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

