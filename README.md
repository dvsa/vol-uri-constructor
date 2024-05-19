## URL Constructor

This library handles creating environment specific URLs. It is intended to be used for test automation for initial page load.

## Code Example
How to construct a URL for the external web-app on production environment
```
org.dvsa.testing.lib.url.webapp.URL.build(ApplicationType.INTERNAL, Environment.PRODUCTION)
```
Note that there are overloaded versions that accept a string as an argument for specifying which environment, meaning that the above example can be written as:
```
org.dvsa.testing.lib.url.webapp.URL.build(ApplicationType.INTERNAL, "prod")
```

The above code snippet will return the string "https://www.vehicle-operator-licensing.service.gov.uk/"

## Installation.
Add the following Maven dependency to your project's `pom.xml` file:
```xml
<dependency>
    <groupId>org.dvsa.testing.lib</groupId>
    <artifactId>vol-uri-constructor</artifactId>
    <version>[LATEST VERSION HERE]</version>
</dependency>
