# Java Deserialize vulnerability test server

This is a lightweight Spring-boot based HTTP server for testing Java Deserialize payloads.

The server is very simple, it listens on a HTTP POST requests at endpoint `http://localhost:8222/suffer`
and deserializes everything that is passed in BASE64 encoding as a POST body.

 Result of the processing is logged. Server helps with testing blind java deserialization.
 

## Running the server

```bash
./gradlew bootRun
```

## Testing

```bash
 curl  --insecure 'http://localhost:8222/suffer' -d 'rO0ABXNyABFqYXZhLnV0aWwuSGFzaE1hcAUH2sHDFmDRAwACRgAKbG9hZEZhY3RvckkACXRocmVzaG9sZHhwP0AAAAAAAAx3CAAAABAAAAADdAAFYWxwaGFzcgARamF2YS5sYW5nLkludGVnZXIS4qCk94GHOAIAAUkABXZhbHVleHIAEGphdmEubGFuZy5OdW1iZXKGrJUdC5TgiwIAAHhwAAAAAXQAA251bXNyABRqYXZhLm1hdGguQmlnSW50ZWdlcoz8nx+pO/sdAwAGSQAIYml0Q291bnRJAAliaXRMZW5ndGhJABNmaXJzdE5vbnplcm9CeXRlTnVtSQAMbG93ZXN0U2V0Qml0SQAGc2lnbnVtWwAJbWFnbml0dWRldAACW0J4cQB+AAT///////////////7////+AAAAAXVyAAJbQqzzF/gGCFTgAgAAeHAAAAABAXh0AARiZXRhdAAEQkVUQXg='
```

## Compilation on Mac with Java8

Place `gradle.properties` to the root of the project:
```
org.gradle.java.home=/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/
```

