# Good to know for writing tests:


## Using Groovy closure to find stuff in collections

This works when using REST assured. 
See [Groovy documentation](http://groovy.codehaus.org/groovy-jdk/java/util/Collection.html#find(groovy.lang.Closure)).


## Hamcrest

Great stuff, but unless you really work with it daily, I doubt it makes you really faster. 
Nevertheless, check out the [tutorial](http://code.google.com/p/hamcrest/wiki/Tutorial). 
This [blog post](http://edgibbs.com/junit-4-with-hamcrest/) also has some nice code snippets.


## REST assured

A comparison with Jersey can be found 
[here](http://www.hascode.com/2011/09/rest-assured-vs-jersey-test-framework-testing-your-restful-web-services/). The 
same author has some more [detailled information](http://www.hascode.com/2011/10/testing-restful-web-services-made-easy-using-the-rest-assured-framework/) on
how to use REST assured.

The official documentation has a [getting started](http://code.google.com/p/rest-assured/wiki/GettingStarted) document and a [cookbook](http://code.google.com/p/rest-assured/wiki/Usage). 
Also worth reading: the unit tests for [JsonPath](https://github.com/jayway/rest-assured/blob/master/rest-assured/src/test/java/com/jayway/restassured/path/json/JsonPathTest.java), 
and - of course - the [JsonPath source](http://rest-assured.googlecode.com/svn/tags/1.6.2/apidocs/com/jayway/restassured/path/json/JsonPath.html). 