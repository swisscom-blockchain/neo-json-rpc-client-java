# Neo Json RPC Client

Java Interface to communicate with a Neo Node over JSON-RPC interface

NEO API Reference: https://github.com/neo-project/neo/wiki/API-Reference

## Features
Network:
- Basic Authentication
- SSL and trust all certification manager

Supported JSON-RPC methods. See the [changelog](./CHANGELOG.md)

## Build
Building without tests
```
mvn clean package -DskipTests
```

## How to use

Plain HTTP connection or HTTPS with trusted certificate
```java
JsonRpcHttpClient client = NeoClientUtil.create("http://your-node:22332");

NeoBlock block = neoClient.getBestBlock();
```

With HTTPS disabled certifcate check and Basic Authentication
```java
JsonRpcHttpClient client = NeoClientUtil.create("https://your-node:22332");
NeoClientUtil.addBasicAuth(client, "user", "password");
NeoClientUtil.enableTrustAllCerts(client);

NeoBlock block = neoClient.getBestBlock();
```

## Testing
For testing you need access to a Neo Node respective the JSON-RPC interface.
The current setup is a Node with SSL and Basic Authentication.
If you have an other setup you may adjust the test classes.

- The tests need these system environment variables:
```
endpoint=<https://hostname:10332>
basicUser=<basic auth username>
basicAuth=<basic auth password>
```
- In IntelliJ you can set these environment variables under
    - Run -> Edit Configuration
    - Defaults -> JUnit -> Environment Variables

## Similar Projects
https://github.com/neo-ngd/neoj
More functions implemented.