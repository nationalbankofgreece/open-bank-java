# Java client for the NBG Open Bank API

This repository contains a simple Java client for accessing the API of the National Bank of Greece.

More information on the NBG Open Bank API can be found at https://nbgdemo.portal.azure-api.net/docs/services/570d09697a995a13c499072f/

## Usage

First, fill in your secondary API key in a file named `.env`. To do so, you could copy and paste the contents of the `.env.example` file - replacing with your key.  
In order to compile your code using the [Apache HTTP client from HTTP Components](http://hc.apache.org/httpcomponents-client-ga/),  you will need to run the provided `run.sh` script. Open it and use the _"Run file"_ command.  
The scripts will:

1. Expose the environmental variables defined in `.env` file
2. Include the `.jar` files inside the `lib` direcotry
3. Compile all files in the `src/com/sourcelair/bankjava` directory
4. Run the `main` function inside the `JavaSample.java` file

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
