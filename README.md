# URI Constructor

This library handles creating environment specific URIs. It is intended to be used for test automation for initial page load.

## Code Example
Constructing production external URI
```$xslt
URI.build(ApplicationType.INTERNAL, Environment.PRODUCTION)
```
The above code snippet will return the string "https://www.vehicle-operator-licensing.service.gov.uk/"