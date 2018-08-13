# Neo Json RPC Client

Java Interface to communicate with a Neo Node over JSON-RPC interface


## Features
Network:
- Basic Authentication
- SSL and trust all SSL

Neo JSON-RPC
- getBestBlockHash
- getConnectionCount
- getBlock

## Testing
For testing you need access to a Neo Node respective the JSON-RPC itnerface.
The current setup is a Node with SSL and Basic Authentication.

The tests need these system environment variables:
```
endpoint=https://hostname:10332
basicUser=<basic auth username>
basicAuth=<basic auth password>
```

The tests requires a Neo Test node.

## Similar Projects
https://github.com/neo-ngd/neoj
More functions implemented.