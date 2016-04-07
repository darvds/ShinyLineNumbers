# Shiny Line Numbers

A simple library for displaying animated numbers, based on the [Google I/O 2016 countdown](https://events.google.com/io2016/)

![Example animation](https://raw.githubusercontent.com/darvds/ShinyLineNumbers/master/example.gif)

##Usage
It can be used in two ways:

###NumberView
This can be added via xml or programatically:
```xml
<com.darvds.shinylinenumbers.views.NumberView
    android:id="@+id/numberView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="4dp"
    app:strokeWidth="10"
    app:duration="400"
    app:number="0"
    app:velocity="100"/>
    ```
        
or
        
    NumberView numberView = new NumberView(context);

###ShinyNumber:
Create this class and get an array of `LineSegment` to draw on a `Canvas`


##License

Copyright 2016 David Scott

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
