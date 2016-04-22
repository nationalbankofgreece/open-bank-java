# Java client for the NBG Open Bank API

This repository contains a simple Java client for accessing the API of the National Bank of Greece.

More information on the NBG Open Bank API can be found at https://nbgdemo.portal.azure-api.net/docs/services/570d09697a995a13c499072f/

## Usage

In order to compile your code using the [Apache HTTP client from HTTP Components](http://hc.apache.org/httpcomponents-client-ga/),  you will need to run the provided `run.sh` script. Open it and use the _"Run file"_ command.

### List available banks

```java
String resourcePath = "/api/banks/rest";
try {
    HttpResponse response = getResource(resourcePath);
    HttpEntity entity = response.getEntity();
    if (entity != null) {
        System.out.println(EntityUtils.toString(entity));
    }
} catch (IOException e) {
    System.out.println(e.getMessage());
} catch (URISyntaxException e) {
    System.out.println("Wrong URI \"" + resourcePath + "\" given:\n" + e.getMessage());
}
 ```
