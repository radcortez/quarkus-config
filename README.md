# Quarkus Config

This example adds additional files to set configuration with the property `smallrye.config.locations`.

- config.properties (classpath resource)
- external.properties (an external file to the application)

The `external.properties` file requires an additional maven setup to copy the resources to the target folder.

## Expected Results in Dev mode:

```
curl http://localhost:8080/config/simple.property
{"name":"simple.property","value":"from-application"}
curl http://localhost:8080/config/override.property
{"name":"override.property","value":"from-config"}
curl http://localhost:8080/config/override.profile.property
{"name":"override.profile.property","value":"from-config-dev"}
curl http://localhost:8080/config/override.profile.main.property
{"name":"override.profile.main.property","value":"from-config-%dev"}

curl http://localhost:8080/config/external.property
{"name":"external.property","value":"from-external"}
curl http://localhost:8080/config/override.external.profile.property
{"name":"override.external.profile.property","value":"from-external-dev"
```

## Expected Results in Prod mode:

```
curl http://localhost:8080/config/simple.property
{"name":"simple.property","value":"from-application"}
curl http://localhost:8080/config/override.property
{"name":"override.property","value":"from-config"}
curl http://localhost:8080/config/override.profile.property
{"name":"override.profile.property","value":"from-config-prod"}
curl http://localhost:8080/config/override.profile.main.property
{"name":"override.profile.main.property","value":"from-config-%prod"}

curl http://localhost:8080/config/external.property
{"name":"external.property","value":"from-external"}
curl http://localhost:8080/config/override.external.profile.property
{"name":"override.external.profile.property","value":"from-external-prod"
```
