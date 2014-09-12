
# Traccar # 

Web page - http://www.traccar.org

Author - Anton Tananaev (anton.tananaev@gmail.com), Jed Jones (jedjones.uk@gmail.com)

SUMMARY:
-----------

Traccar is open source server for various GPS tracking devices.
Project is written in Java and should work on most platforms with
installed Java Runtime Environment.

CHANGES FROM DEFAULT:
-----------
THIS VERSION IS CURRENTLY ONLY DESIGNED TO USE MYSQL

This branch of Traccar is slightly different to the main branch.
Currently the biggest difference is  the query `<entry key='database.selectDevice'>`
requires a 3rd column called `database`. This is then accessed in the other queries
(`<entry key='database.updateLatestPosition'>` and `<entry key='database.insertPosition'>`)
with the placeholder `_database_`. The aim of this placeholder is to allow you to 
direct an insert or update to the correct database for a device in the event 
you have a multi-tenant system without using concat and prepare statement.


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

