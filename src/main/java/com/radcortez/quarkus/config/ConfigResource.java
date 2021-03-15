package com.radcortez.quarkus.config;

import io.quarkus.runtime.annotations.RegisterForReflection;
import io.smallrye.config.SmallRyeConfig;
import org.eclipse.microprofile.config.Config;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/config")
@Produces(MediaType.APPLICATION_JSON)
public class ConfigResource {
    @Inject
    Config config;

    @GET
    @Path("/{name}")
    public Response configValue(@PathParam("name") final String name) {
        final io.smallrye.config.ConfigValue configValue = ((SmallRyeConfig) config).getConfigValue(name);
        return Response.ok(new ConfigValue(configValue.getName(), configValue.getValue())).build();
    }

    @RegisterForReflection
    public static class ConfigValue {
        final String name;
        final String value;

        public ConfigValue(final String name, final String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }
}
